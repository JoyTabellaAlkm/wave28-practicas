package com.spring1.meliSocial.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring1.meliSocial.dto.request.RequestPostDto;
import com.spring1.meliSocial.dto.response.*;
import com.spring1.meliSocial.exception.ExistingDataException;
import com.spring1.meliSocial.mapper.IMapper;
import com.spring1.meliSocial.model.Post;
import com.spring1.meliSocial.model.Product;
import com.spring1.meliSocial.model.User;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.spring1.meliSocial.dto.request.ProductPromoDto;
import com.spring1.meliSocial.exception.BadRequestException;
import com.spring1.meliSocial.exception.NotFoundException;
import com.spring1.meliSocial.repository.IPostRepository;
import com.spring1.meliSocial.repository.IProductRepository;
import com.spring1.meliSocial.repository.IUserRepository;
import com.spring1.meliSocial.service.IPostService;
import com.spring1.meliSocial.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;


@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    final private ObjectMapper objectMapper;

    @Autowired
    private IMapper customMapper;

    public PostService() {
        this.objectMapper = new ObjectMapper();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));

        this.objectMapper.registerModule(javaTimeModule);
    }

    @Override
    public ResponseDto saveNewPost(RequestPostDto requestPostDto) {
        Optional<User> idUser = userRepository.getUserById(requestPostDto.getUserId());
        if(idUser.isEmpty()){
            throw new NotFoundException("El usuario con id: " + requestPostDto.getUserId() + " no existe");
        }

        Post post = objectMapper.convertValue(requestPostDto,Post.class);
        saveNewProduct(post);
        postRepository.saveNewPost(post);
        return new ResponseDto("Publicación creada");
    }

    public void saveNewProduct(Post post){
        Product product = objectMapper.convertValue(post.getProduct(), Product.class);
        if(productRepository.existsProductWithId(product.getId())){
            throw new ExistingDataException("El producto con el id " + post.getProduct().getId() + " ya existe");
        }

        productRepository.addProduct(post.getProduct());
    }

    @Override
    public ResponseDto addNewProductPromo(ProductPromoDto productDto) {
        Post post = objectMapper.convertValue(productDto, Post.class);

        Product product = objectMapper.convertValue(productDto.getProduct(), Product.class);

        if(productRepository.existsProductWithId(product.getId()))
            throw new BadRequestException("El id del producto ya existe en una publicación");

        Optional<User> user = userRepository.getUserById(post.getUserId());
        if (user.isPresent()){
            if(!user.get().isSeller())
                throw new BadRequestException("El id que ingresó es de un usuario comprador");
        }

        if(!userRepository.existsUserWithId(post.getUserId()))
            throw new NotFoundException("El id del vendedor no existe");


        productRepository.addProduct(product);
        postRepository.addNewProductPromo(post);
        return new ResponseDto("Publicación con promoción creada");
    }

    @Override
    public PostIndexDto getPostsByUser(int userId, String order) {
        UserValidation.validateGetPostsByUserParams(userId, order);
        Optional<User> user = userRepository.getUserById(userId);

        if (user.isEmpty()) {
            throw new NotFoundException("No se encontró el usuario.");
        }

        List<Integer> followedIds = user.get().getFollowed();

        Comparator<Post> comparator = (order.equalsIgnoreCase("date_asc"))
                ? Comparator.comparing(Post::getDate)
                : Comparator.comparing(Post::getDate).reversed();

        List<Post> filteredPosts = postRepository.getPosts().stream()
                .filter(p -> followedIds.contains(p.getUserId()))
                .filter(p -> p.getDate() != null && ChronoUnit.DAYS.between(p.getDate(), LocalDate.now()) <= 14)
                .sorted(comparator)
                .toList();

        return new PostIndexDto(userId, filteredPosts.stream()
                .map(fp -> customMapper.mapToResponsePostDto(fp))
                .toList());
    }

    @Override
    public PostPromoDto getProductsOnPromo(int userId) {
        Optional<User> optionalUser = userRepository.getUserById(userId);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("El usuario con ID: " + userId + " no existe.");
        }

        User user = optionalUser.get();

        if (!user.isSeller()) {
            throw new BadRequestException("El usuario con ID: " + userId + " no es un vendedor.");
        }

        int promoProductsCount = postRepository.countProductsOnPromo(userId);

        return new PostPromoDto(
                user.getId(),
                user.getUserName(),
                promoProductsCount
        );
    }

    public List<ResponsePostDto> getAll(){
        return postRepository.getPosts().stream().map(p -> customMapper.mapToResponsePostDto(p)).toList();
    }

    @Override
    public ResponseDto updatePromoDiscount(int id, double discount) {
        if(!postRepository.existsPost(id))
            throw new NotFoundException("La publicación que quiere modificar no existe");

        if (discount > 1)
            throw new BadRequestException("El descuento no puede superar el 100%");

        if (discount < 0.01)
            throw new BadRequestException("El descuento no puede ser menor o igual a 0");

        postRepository.updatePromoDiscount(id, discount);
        return new ResponseDto("La promoción se actualizó correctamente");
    }



    @Override
    public List<ResponsePostDto> getBestProductsOnPromo(Integer category) {
        List<Post> bestProductsOnPromo = postRepository.getBestProductsOnPromo();

        if (bestProductsOnPromo.isEmpty()) {
            throw new NotFoundException("No hay productos en promo");
        }

        return bestProductsOnPromo.stream()
                .filter(post -> post.getDiscount() > 0)
                .filter(post -> category == null || post.getCategory() == (int) category)
                .sorted((p1, p2) -> Double.compare(p2.getDiscount(), p1.getDiscount()))
                .limit(10)
                .map(post -> customMapper.mapToResponsePostDto(post))
                .toList();
    }

    @Override
    public ResponseDto updatePrice(int id, double price) {
        if (!postRepository.existsPost(id))
            throw new NotFoundException ("La publicación que quiere modificar con ID: " + id + " no existe.");

        if (price <= 0)
            throw new BadRequestException("El precio no puede ser menor o igual a 0");

        postRepository.updatePrice(id,price);
        return new ResponseDto("Se actualizó el precio del posteo con ID: " + id);
    }

}
