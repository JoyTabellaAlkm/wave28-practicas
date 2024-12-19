package com.mercadolibre.social.service.impl;

import com.mercadolibre.social.dto.request.PostPromotionRequestDto;
import com.mercadolibre.social.dto.request.PostRequestDto;
import com.mercadolibre.social.dto.response.*;
import com.mercadolibre.social.entity.Post;
import com.mercadolibre.social.entity.Product;
import com.mercadolibre.social.entity.User;
import com.mercadolibre.social.exception.BadRequestException;
import com.mercadolibre.social.exception.NotFoundException;
import com.mercadolibre.social.repository.IPostRepository;
import com.mercadolibre.social.repository.IProductRepository;
import com.mercadolibre.social.repository.IUserRepository;
import com.mercadolibre.social.service.IPostService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;
import java.util.ListResourceBundle;
import java.util.Set;

@Service
public class PostService implements IPostService {

    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;

    public PostService(IPostRepository postRepository, IUserRepository userRepository, IProductRepository productRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public MessageDto createPost(PostRequestDto postRequestDTO) {
        LocalDate date = postRequestDTO.getDate();

        // Se valida si el usuario ingresado existe en el sistema
        userRepository.findById(postRequestDTO.getUserId());

        // Se valida que el producto ingresado sea correcto
        Product product = productRepository.findById(postRequestDTO.getProduct().getProductId());

        if (!product.getName().equalsIgnoreCase(postRequestDTO.getProduct().getProductName())) {
            throw new BadRequestException("The product name is incorrect");
        }
        if (!product.getType().equalsIgnoreCase(postRequestDTO.getProduct().getType())) {
            throw new BadRequestException("The product type is incorrect");
        }
        if (!product.getBrand().equalsIgnoreCase(postRequestDTO.getProduct().getBrand())) {
            throw new BadRequestException("The product brand is incorrect");
        }
        if (!product.getColor().equalsIgnoreCase(postRequestDTO.getProduct().getColor())) {
            throw new BadRequestException("The product color is incorrect");
        }
        if (!product.getNotes().equalsIgnoreCase(postRequestDTO.getProduct().getNotes())) {
            throw new BadRequestException("The product notes are incorrect");
        }

        // Crea el objeto Post
        Post post = new Post();
        post.setUserId(postRequestDTO.getUserId());
        post.setDate(date);
        post.setProductId(postRequestDTO.getProduct().getProductId());
        post.setCategory(postRequestDTO.getCategory());
        post.setPrice(postRequestDTO.getPrice());
        post.setHasPromo(false);
        post.setDiscount(0.0);


        post = postRepository.save(post);

        // Retorna el mensaje de éxito
        return new MessageDto("The post with id " + post.getId() + " has been created correctly");
    }

    @Override
    public ProductCountPromoPostDto getCountPromoPost(int userId) {
        // TODOS LOS POST
        List<Post> posts = postRepository.findAll();

        // FILTRAR POR USUARIO
        List<Post> postsFilterByUser = posts.stream()
                .filter(post -> post.getUserId().equals(userId))
                .toList();

        // FILTRAR LOS POST QUE TENGA PROMO
        List<Post> postFilterByUserAndPromoPost = postsFilterByUser.stream().
                filter(Post::getHasPromo)
                .toList();

        // CONTAR LOS POST QUE TENGA PROMO
        Integer countPromoPost = postFilterByUserAndPromoPost.size();

        // CONSEGUIR EL USERNAME O EL USUARIO POR EL ID
        User user = userRepository.findById(userId);

        // ARMAR LA RESPUESTA EN EL FORMATO DTO
        return new ProductCountPromoPostDto(
                user.getId(), user.getUsername(), countPromoPost
        );
    }

    public MessageDto createPostPromotion(PostPromotionRequestDto postPromotionRequestDto) {
        Integer userId = postPromotionRequestDto.getUserId();

        userRepository.findById(postPromotionRequestDto.getUserId());

        // Se valida que el producto ingresado sea correcto
        Product product = productRepository.findById(postPromotionRequestDto.getProduct().getProductId());

        // Validación del descuento: debe estar entre 0 y 1 (porcentaje entre 0% y 100%)
        if (postPromotionRequestDto.getHasPromo() != null && postPromotionRequestDto.getHasPromo() &&
                (postPromotionRequestDto.getDiscount() == null || postPromotionRequestDto.getDiscount() < 0 || postPromotionRequestDto.getDiscount() > 1)) {
            throw new BadRequestException("The discount must be between 0 and 1");
        }

        if (!product.getName().equalsIgnoreCase(postPromotionRequestDto.getProduct().getProductName())) {
            throw new BadRequestException("The product name is incorrect");
        }
        if (!product.getType().equalsIgnoreCase(postPromotionRequestDto.getProduct().getType())) {
            throw new BadRequestException("The product type is incorrect");
        }
        if (!product.getBrand().equalsIgnoreCase(postPromotionRequestDto.getProduct().getBrand())) {
            throw new BadRequestException("The product brand is incorrect");
        }
        if (!product.getColor().equalsIgnoreCase(postPromotionRequestDto.getProduct().getColor())) {
            throw new BadRequestException("The product color is incorrect");
        }
        if (!Objects.equals(product.getNotes(), postPromotionRequestDto.getProduct().getNotes())) {
            throw new BadRequestException("The product notes are incorrect");
        }
        // Validar que los demás campos tengan valores válidos
        if (postPromotionRequestDto.getPrice() == null || postPromotionRequestDto.getPrice() <= 0) {
            throw new BadRequestException("Invalid price value");
        }
        if (postPromotionRequestDto.getCategory() == null || postPromotionRequestDto.getCategory() <= 0) {
            throw new BadRequestException("Invalid category value");
        }

        // Crea el objeto Post
        LocalDate date = postPromotionRequestDto.getDate();
        Post post = new Post();
        post.setUserId(userId);
        post.setDate(date);
        post.setProductId(postPromotionRequestDto.getProduct().getProductId());
        post.setCategory(postPromotionRequestDto.getCategory());
        post.setPrice(postPromotionRequestDto.getPrice());
        post.setHasPromo(postPromotionRequestDto.getHasPromo());
        post.setDiscount(postPromotionRequestDto.getDiscount() != null ? postPromotionRequestDto.getDiscount() : 0.0);

        post = postRepository.save(post);

        return new MessageDto("The post with promotion with id " + post.getId() + " has been successfully created");
    }

    @Override
    public UserPostsResponseDTO getPostsByFollowedUsers(Integer userId, String order) {
        // Verifica que el usuario existe
        User user = userRepository.findById(userId);

        // Obtén los IDs de los usuarios seguidos
        Set<Integer> followedUsers = user.getFollowed();

        // Filtra las publicaciones realizadas por los usuarios seguidos
        List<Post> filteredPosts = postRepository.findAll().stream()
                .filter(post -> followedUsers.contains(post.getUserId()))
                .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2))) // Últimas dos semanas
                .toList();

        List<Post> orderedPosts;

        if(order.equalsIgnoreCase("date_asc")) {
            orderedPosts = filteredPosts
                    .stream()
                    .sorted(Comparator.comparing(Post::getDate))
                    .toList();
        } else { // date_desc
            orderedPosts = filteredPosts
                    .stream()
                    .sorted(Comparator.comparing(Post::getDate).reversed())
                    .toList();
        }


        // Mapea las publicaciones a PostDetailsDTO
        List<PostDetailsDTO> posts = orderedPosts.stream()
                .map(post -> {
                    Product product = productRepository.findById(post.getProductId());
                    return new PostDetailsDTO(
                            post.getUserId(),
                            post.getId(),
                            post.getDate(),
                            new ProductResponseDTO(
                                    product.getId(),
                                    product.getName(),
                                    product.getType(),
                                    product.getBrand(),
                                    product.getColor(),
                                    product.getNotes()
                            ),
                            post.getCategory(),
                            post.getPrice()
                    );
                })
                .toList();

        // Construye la respuesta completa
        return new UserPostsResponseDTO(userId, posts);
    }
}
