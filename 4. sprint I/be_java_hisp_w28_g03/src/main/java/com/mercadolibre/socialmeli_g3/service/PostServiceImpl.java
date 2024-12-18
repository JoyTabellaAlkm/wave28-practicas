package com.mercadolibre.socialmeli_g3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.socialmeli_g3.dto.*;
import com.mercadolibre.socialmeli_g3.dto.response.PostResponseDto;
import com.mercadolibre.socialmeli_g3.dto.response.ProductResponseDTO;
import com.mercadolibre.socialmeli_g3.dto.response.ProductByIdUserResponseDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FindProductsPromoResponseDTO;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.socialmeli_g3.entity.Post;
import com.mercadolibre.socialmeli_g3.entity.User;
import com.mercadolibre.socialmeli_g3.exception.NotFoundException;
import com.mercadolibre.socialmeli_g3.exception.BadRequestException;
import com.mercadolibre.socialmeli_g3.repository.IPostRepository;
import com.mercadolibre.socialmeli_g3.repository.IUserRepository;
import com.mercadolibre.socialmeli_g3.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public PostServiceImpl(IPostRepository postRepository, IProductRepository productRepository, IUserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAllPosts();
    }

    @Override
    public ProductByIdUserResponseDTO findProductByIdUser(int userId, String order) {
        if(userId <= 0) {
            throw new BadRequestException("The user id provided is not valid");
        }
        ProductByIdUserResponseDTO response = new ProductByIdUserResponseDTO();
        response.setUser_id(userId);
        List<Post> listOfPosts;
        if(order == null) {
            listOfPosts = postRepository.findProductByIdUser(userId);
        }
        else {
            validateOrder(order);
            listOfPosts = postRepository.findProductByIdUserOrderedByDate(userId, order);
        }
        List<PostResponseDto> posts = listOfPosts.stream().map( post -> {
            PostResponseDto res = new PostResponseDto();
            ProductResponseDTO prodResponse = new ProductResponseDTO();
            prodResponse.setProduct_id(post.getProduct().getProductId());
            prodResponse.setType(post.getProduct().getType());
            prodResponse.setBrand(post.getProduct().getBrand());
            prodResponse.setColor(post.getProduct().getColor());
            prodResponse.setNotes(post.getProduct().getNotes());
            prodResponse.setProduct_name(post.getProduct().getProductName());

            res.setPost_id(post.getPostId());
            res.setUser_id(post.getUserId());
            res.setProduct(prodResponse);
            res.setCategory(post.getCategory());
            res.setPrice(post.getPrice());
            res.setDate(post.getDate());
            return res;
        }).toList();

        response.setPosts(posts);
        if(response.getPosts().isEmpty()){
            throw new NotFoundException("Post not found");
        }
        return response;
    }

    @Override
    public FindProductsPromoResponseDTO findProductsPromoCount(int userId) {
        FindProductsPromoResponseDTO response = new FindProductsPromoResponseDTO();
        User usuario = userRepository.findUserById(userId);
        if(usuario == null){
            throw new NotFoundException("User not found");
        }
        response.setUser_id(userId);
        response.setUser_name(usuario.getUserName());
        response.setPromos_products_count(postRepository.findProductsPromoCount(userId));
        return response;
    }

    @Override
    public MessageDTO createPost(ProductPostDTO productPostDTO) {
        validateUser(productPostDTO.getUserId());
        validatePostExistence(productPostDTO.getUserId(), productPostDTO.getProduct().getProductId(), false);
        validateProduct(productPostDTO.getProduct().getProductId());
        validateCategory(productPostDTO.getCategory());
        validatePrice(productPostDTO.getPrice());

        postRepository.createPost(objectMapper.convertValue(productPostDTO, Post.class));
        return new MessageDTO("Post created successfully");
    }

    @Override
    public MessageDTO createPromoPost(PromoProductPostDTO promoProductPostDTO) {
        validateUser(promoProductPostDTO.getUserId());
        validatePostExistence(promoProductPostDTO.getUserId(), promoProductPostDTO.getProduct().getProductId(), true);
        validateProduct(promoProductPostDTO.getProduct().getProductId());
        validateCategory(promoProductPostDTO.getCategory());
        validatePrice(promoProductPostDTO.getPrice());
        validateDiscount(promoProductPostDTO.getDiscount());

        postRepository.createPost(objectMapper.convertValue(promoProductPostDTO, Post.class));
        return new MessageDTO("Post Promo created successfully");
    }

    // region Validations for Post methods
    private void validateUser(int userId) {
        if (userRepository.findUserById(userId) == null) {
            throw new BadRequestException("User not found");
        }
    }

    private void validatePostExistence(int userId, int productId, boolean isPromo) {
        if (postRepository.findAllPosts().stream().anyMatch(p -> p.getUserId() == userId &&
                p.getProduct().getProductId() == productId)) {
            throw new BadRequestException(isPromo ? "Post Promo already exists for this user and product" : "Post already exists for this user and product");
        }
    }

    private void validateProduct(int productId) {
        if (productRepository.findProductById(productId).isEmpty()) {
            throw new NotFoundException("Product Not Found");
        }
    }

    private void validateCategory(int category) {
        if (category < 0) {
            throw new BadRequestException("Category must be positive");
        }
    }

    private void validatePrice(double price) {
        if (price < 0) {
            throw new BadRequestException("Price must be positive");
        }
    }

    private void validateDiscount(double discount) {
        if (discount < 0 || discount > 1) {
            throw new BadRequestException("Discount must be between 0 and 1");
        }
    }
    // endregion

    @Override
    public PromoProductPostListDTO getProductsOnPromoByUser(String userId) {
        if (userId == null) {
            throw new BadRequestException("User ID cannot be null");
        }
        try {
            int userIdParsed = Integer.parseInt(userId);
            PromoProductPostListDTO promoProductPostListDTO = new PromoProductPostListDTO();
            User user = userRepository.findUserById(userIdParsed);
            if (user == null) throw new NotFoundException("User not found by userId");

            List<Post> postsOnPromoByUser = postRepository.findAllPostsOnPromoByUser(userIdParsed);
            if (postsOnPromoByUser == null || postsOnPromoByUser.isEmpty())
                throw new NotFoundException("Post on promo not found by userId");

            promoProductPostListDTO.setUserId(user.getUserId());
            promoProductPostListDTO.setUsername(user.getUserName());
            List<PostDTO> postDtos = postsOnPromoByUser
                    .stream()
                    .map(p -> objectMapper.convertValue(p, PostDTO.class))
                    .toList();

            promoProductPostListDTO.setPosts(postDtos);
            return promoProductPostListDTO;

        } catch (NumberFormatException e) {
            throw new BadRequestException("User ID must be a valid integer.");
        }
    }

    @Override
    public List<PostDTO> findProductByPrice(double minPrice, double maxPrice) {
        List<PostDTO> response = new ArrayList<>();
        if(minPrice <= 0 || maxPrice <= 0 || maxPrice <= minPrice){
            throw new BadRequestException("The provided price is not valid");
        }
        response = postRepository.findProductByPrice(minPrice,maxPrice).stream().map( post -> objectMapper.convertValue(post,PostDTO.class)).toList();
        if(response.isEmpty()){
            throw new NotFoundException("Product Not Found");
        }
        return response;
    }


    @Override
    public List<PostDTO> getPostsByProductAttributes(Map<String, String> filterParams) {
        List<Post> postList = postRepository.findPostsByProductAttributes(filterParams);

        if(postList.isEmpty()) {
            throw new NotFoundException("No posts have been found with the provided filters");
        }

        return postList.stream().map(post -> objectMapper.convertValue(post, PostDTO.class)).toList();
    }

    private void validateOrder(String order) {
        if(!order.equalsIgnoreCase("date_asc") && !order.equalsIgnoreCase("date_desc")) {
            throw new BadRequestException("The provided order for sorting by date is not valid");
        }
    }

    //CU 016
    @Override
    public List<PostDTO > findProductsByCategory(int category) {
        try {
            validateCategory(category);
            List<Post> listPost = postRepository.findPostbyCategory(category);
            if (listPost.isEmpty()) {
                throw new NotFoundException("Category not found");
            }

            // Convierte la lista de Post a una lista de PostDTO y la devuelve
            return listPost.stream()
                    .map(post -> objectMapper.convertValue(post, PostDTO.class))
                    .collect(Collectors.toList());
        }catch (NumberFormatException e) {
            throw new BadRequestException("The category must be a valid integer.");
        }

    }

    @Override
    public PromoProductPostDTO makePostAPromo(int postId, double discount) {
        validateDiscount(discount);

        Post post = postRepository.findPostById(postId);
        if (post == null) {
            throw new NotFoundException("Post not found");
        }

        if (post.isHasPromo()) {
            throw new BadRequestException("Post is already a promo post");
        }

        post.setHasPromo(true);
        post.setDiscount(discount);
        postRepository.updatePost(post);
        return objectMapper.convertValue(post, PromoProductPostDTO.class);
    }
}
