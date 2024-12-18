package com.bootcamp.social_meli.service.impl;

import com.bootcamp.social_meli.dto.PostDTO;
import com.bootcamp.social_meli.dto.PromoPostDTO;
import com.bootcamp.social_meli.dto.response.MostPostsUsersResponseDTO;
import com.bootcamp.social_meli.dto.response.SimpleUserWithPostsCountDTO;
import com.bootcamp.social_meli.dto.response.PostsWithProductDTO;
import com.bootcamp.social_meli.dto.response.UserPostResponse;
import com.bootcamp.social_meli.exception.BadRequestException;
import com.bootcamp.social_meli.exception.NotFoundException;
import com.bootcamp.social_meli.model.Post;
import com.bootcamp.social_meli.model.User;
import com.bootcamp.social_meli.repository.IPostRepository;
import com.bootcamp.social_meli.repository.IProductRepository;
import com.bootcamp.social_meli.repository.IUserRepository;
import com.bootcamp.social_meli.service.IPostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {
    private IPostRepository postRepository;
    private IUserRepository userRepository;
    private IProductRepository productRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public PostServiceImpl(IPostRepository postRepository, IUserRepository userRepository, IProductRepository productRepository, ObjectMapper objectMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserPostResponse createPost(PostDTO postDTO) {
        Long userId = postDTO.getUserId();
        Long productId = postDTO.getProduct().getProduct_id();

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userId));
        Optional<Post> existingPostOpt = postRepository.findByUserIdAndProductId(userId,productId);

        if(existingPostOpt.isPresent()){
            throw new BadRequestException("Post ya existente para el usuario "+postDTO.getUserId());
        }

        Post post = objectMapper.convertValue(postDTO,Post.class);
        post.setCreatorUser(user);
        post.setHasDiscount(false);
        post.setDiscountPercentage(0.00);

        if(productRepository.findAll().stream().noneMatch(product -> product.getId().equals(post.getProduct().getId()))){
            productRepository.create(post.getProduct());
        }

        postRepository.create(post);

        return createUserResponse(post,"Post creado exitosamente!");
    }

    @Override
    public UserPostResponse createPromoPost(PromoPostDTO promoPostDTO) {
        Long userId = promoPostDTO.getUserId();
        Long productId = promoPostDTO.getProduct().getProduct_id();

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userId));
        Optional<Post> postOptional = postRepository.findByUserIdAndProductId(userId,productId);

        if(postOptional.isPresent()){
            return updatePromoPost(promoPostDTO);
        }

        Post post = objectMapper.convertValue(promoPostDTO,Post.class);
        post.setCreatorUser(user);


        if(productRepository.findAll().stream().noneMatch(product -> product.getId().equals(post.getProduct().getId()))){
            productRepository.create(post.getProduct());
        }

        postRepository.create(post);

        return createUserResponse(post,"Post creado exitosamente!");
    }

    @Override
    public UserPostResponse updatePromoPost(PromoPostDTO promoPostDTO) {
        Post existingPost = postRepository.findByUserIdAndProductId(promoPostDTO.getUserId(), promoPostDTO.getProduct().getProduct_id())
                .orElseThrow(() -> new BadRequestException("Post no encontrado para actualizar"));

        Post post = objectMapper.convertValue(promoPostDTO,Post.class);
        post.setCreatorUser(existingPost.getCreatorUser());
        post.setId(existingPost.getId());

        postRepository.update(post);

        return createUserResponse(post,"Post actualizado exitosamente!");
    }

    @Override
    public PostsWithProductDTO getPostsWithProduct(String productName) {
        return new PostsWithProductDTO(productName, postRepository.getPostsWithProduct(productName));
    }

    public UserPostResponse createUserResponse(Post post, String message){
        UserPostResponse userPostResponse = new UserPostResponse();
        userPostResponse.setMessage(message);
        userPostResponse.setUser_id(post.getCreatorUser().getId());
        userPostResponse.setDate(post.getCreateDate());
        userPostResponse.setProduct(post.getProduct());
        userPostResponse.setCategory(post.getCategory());
        userPostResponse.setPrice(post.getPrice());
        if(post.getHasDiscount() != null)
            userPostResponse.setHas_promo(post.getHasDiscount());
        if(post.getDiscountPercentage() != null)
            userPostResponse.setDiscount(post.getDiscountPercentage());

        return userPostResponse;
    }

    @Override
    public MostPostsUsersResponseDTO mostPostsUsers() {
        return mostPostsUsers(5);
    }

    @Override
    public MostPostsUsersResponseDTO mostPostsUsers(Integer rank) {
        if(rank <= 0) {
            throw new BadRequestException("'rank' no puede ser <= 0");
        }

        HashMap<Long, SimpleUserWithPostsCountDTO> usersWithProducts = new HashMap<>();

        postRepository.findAll().forEach(p -> {
            // 1. Obtengo el creador del posteo
            Long postCreatorId = p.getCreatorUser().getId();
            String postCreatorUsername = p.getCreatorUser().getUsername();
            // 2. Me fijo si ya lo incluí en el HashMap "usersWithProducts"
            if(usersWithProducts.containsKey(postCreatorId)) {
                // 3a. Lo obtengo, incrementó en 1 y actualizo en el mapa
                SimpleUserWithPostsCountDTO user = usersWithProducts.get(postCreatorId);
                user.setPosts_amount(user.getPosts_amount() + 1);
                usersWithProducts.replace(postCreatorId, user);
            } else {
                // 3b. Lo agregó por primera vez y setteo en 1
                usersWithProducts.put(postCreatorId,
                        new SimpleUserWithPostsCountDTO(postCreatorId,
                                postCreatorUsername,
                                1));
            }
        });

        List<SimpleUserWithPostsCountDTO> result;
        if(usersWithProducts.size() < rank) {
            result = usersWithProducts.values().stream().toList();
        } else {
            result = usersWithProducts.values().stream().toList().subList(0, rank);
        }

        return new MostPostsUsersResponseDTO(result);
    }

    @Override
    public List<PostDTO> getPostsByPriceRange(String min, String max) {
        Double minPrice = parseStringToDouble(min).orElseThrow(() -> new BadRequestException("Formato precio minimo invalido"));
        Double maxPrice = parseStringToDouble(max).orElseThrow(() -> new BadRequestException("Formato precio maximo invalido"));

        if(minPrice > maxPrice){
            throw new BadRequestException("El precio maximo no puede ser menor que el precio minimo");
        }
        return postRepository.getPostsByPriceRange(minPrice, maxPrice).stream().map(this::convertToPostDTO).toList();
    }

    public Optional<Double> parseStringToDouble(String price) {
        try {
            double value = Double.parseDouble(price);
            if (value <= 0)
                throw new BadRequestException("El precio debe ser mayor a 0");

            return Optional.of(value);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
    public PostDTO convertToPostDTO(Post post){
        PostDTO postDTO = objectMapper.convertValue(post,PostDTO.class);
        postDTO.setUserId(post.getCreatorUser().getId());
        return postDTO;
    }


}
