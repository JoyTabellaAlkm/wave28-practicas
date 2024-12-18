package com.mercadolibre.be_java_hisp_w28_g10.service.impl;

import com.mercadolibre.be_java_hisp_w28_g10.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.ProductDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ProductsWithPromoDTO;
import com.mercadolibre.be_java_hisp_w28_g10.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w28_g10.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w28_g10.model.Post;
import com.mercadolibre.be_java_hisp_w28_g10.model.User;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponsePostNoPromoDTO;
import com.mercadolibre.be_java_hisp_w28_g10.model.Product;
import com.mercadolibre.be_java_hisp_w28_g10.dto.*;
import com.mercadolibre.be_java_hisp_w28_g10.model.FollowRelation;
import com.mercadolibre.be_java_hisp_w28_g10.repository.IProductRepository;
import com.mercadolibre.be_java_hisp_w28_g10.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w28_g10.service.IProductService;
import com.mercadolibre.be_java_hisp_w28_g10.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link IProductService} interface for managing product-related operations.
 * This service offers functionality to retrieve products and posts, add new posts (with or without promotions),
 * validate input data, and retrieve posts from followed users, among other functionalities.
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private Utilities utilities;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(p -> utilities.convertValue(p, ProductDTO.class)).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PostDTO> getAllPost() {
        return productRepository.findAllPost().stream().map(p -> utilities.convertValue(p, PostDTO.class)).toList();
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method processes the given post and performs any necessary validations before saving it.
     */
    @Override
    public PostDTO addPromoPost(PostDTO post) {
        savePostLogic(post);
        return post;
    }


    /**
     * {@inheritDoc}
     * <p>
     * This method handles the addition of a regular post. If the save operation fails, a
     */
    @Override
    public ResponsePostNoPromoDTO addPost(PostDTO newPost) {
        savePostLogic(newPost);
        Post post = utilities.convertValue(newPost, Post.class);
        ProductDTO productDto = utilities.convertValue(post.getProduct(), ProductDTO.class);

        return new ResponsePostNoPromoDTO(post.getId(), post.getPostId(), post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), post.getCategory(), post.getPrice(),
                productDto);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Retrieves the number of promotional products associated with a specified user.
     *
     * @throws NotFoundException if the user is not found or if there are no posts.
     */
    @Override
    public ProductsWithPromoDTO productsWithPromoDTO(int id) {
        //Find the user with id
        User user = userRepository.findUserById(id);
        //Get all the list of Post
        List<Post> product = productRepository.findAllPost();
        //Validate if the list is empty or the user id exist in the json
        if (user == null || product.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        //Filter the post fot user id and if the post has promo
        List<Post> productFilter = product.stream()
                .filter(p -> p.getId() == user.getId()).filter(Post::isHasPromo)
                .toList();
        //return a DTO
        return new ProductsWithPromoDTO(user.getId(), user.getName(), productFilter.size());
    }

    /**
     * {@inheritDoc}
     * <p>
     * Retrieves the most recent posts from users that the specified user follows within a two-week period.
     *
     * @throws NotFoundException   if userId doesn't exist in the system.
     * @throws BadRequestException if the order parameter is invalid.
     */
    @Override
    public ResponseFollowedPostsDTO getLastFollowedPosts(Integer userId, Optional<String> order) {

        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new NotFoundException("User not found");
        }

        //Time filter. Two Weeks
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        //Get the ID list of related users
        List<Integer> followedIds = userRepository.getFollowRelationsByFollowerId(userId)
                .stream()
                .map(FollowRelation::getIdFollowed)
                .toList();

        //Get the list of every post
        List<Post> postList = productRepository.findAllPost();

        //Filter by followed users
        List<Post> postListByUserId = postList.stream().filter(post -> followedIds.contains(post.getId())).toList();

        //Filter to get the posts in the specified time
        List<Post> followedPostsfromTwoWeeksAgo = postListByUserId
                .stream()
                .filter(post -> post.getDate()
                        .isAfter(twoWeeksAgo))
                .toList();

        //Sort by date. Ascending or Descending
        if (order.isEmpty() || order.get().equals("date_desc")) {
            return new ResponseFollowedPostsDTO(userId, followedPostsfromTwoWeeksAgo.stream().sorted(Comparator.comparing(Post::getDate).reversed()).map(post -> new ResponsePostNoPromoDTO(post.getId(), post.getPostId(), post.getDate().toString(), post.getCategory(), post.getPrice(), utilities.convertValue(post.getProduct(), ProductDTO.class))).toList());
        } else if (order.get().equals("date_asc")) {
            return new ResponseFollowedPostsDTO(userId, followedPostsfromTwoWeeksAgo.stream().sorted(Comparator.comparing(Post::getDate)).map(post -> new ResponsePostNoPromoDTO(post.getId(), post.getPostId(), post.getDate().toString(), post.getCategory(), post.getPrice(), utilities.convertValue(post.getProduct(), ProductDTO.class))).toList());
        } else {
            throw new BadRequestException("That's not a valid order criteria");
        }
    }

    /**
     * Validates the provided post data and saves it. This includes ensuring the associated product exists.
     *
     * @param post the {@link PostDTO} to be validated and saved.
     * @return true if the operation was successful; false otherwise.
     */
    private boolean savePostLogic(PostDTO post) {
        validatePostDto(post);
        validateProductDto(post.getProduct());
        Product product = utilities.convertValue(post.getProduct(), Product.class);
        if (!productRepository.existsProduct(post.getProduct().getId())) {
            productRepository.addProduct(product);
        }
        Post.counterPostId += 1;
        post.setPostId(Post.counterPostId);
        return productRepository.addPost(utilities.convertValue(post, Post.class));
    }

    /**
     * Validates the given {@link PostDTO} for required fields and constraints.
     *
     * @param post the post data to validate.
     * @throws BadRequestException if validation fails.
     */
    private void validatePostDto(PostDTO post) {
        try {
            LocalDate ld = utilities.convertValue(post.getDate(), LocalDate.class);
        } catch (Exception e) {
            throw new BadRequestException("The date field must be in the dd/MM/yyyy format.");
        }

        if (post.getId() <= 0) {
            throw new IllegalArgumentException("The ID must be a positive number.");
        }
        if (post.getDate() == null || post.getDate().isEmpty()) {
            throw new IllegalArgumentException("Date is required.");
        }
        if (post.getCategory() <= 0) {
            throw new IllegalArgumentException("Category must be a positive value.");
        }
        if (post.getPrice() <= 0) {
            throw new IllegalArgumentException("The price must be a positive number.");
        }
    }

    /**
     * Validates the provided {@link ProductDTO} for required fields.
     *
     * @param productDto the product data to validate.
     * @throws IllegalArgumentException if validation fails.
     */
    private void validateProductDto(ProductDTO productDto) {
        if (productDto.getId() <= 0) {
            throw new IllegalArgumentException("The product ID must be a positive number.");
        }
        if (productDto.getName() == null || productDto.getName().isEmpty()) {
            throw new IllegalArgumentException("The product name is required.");
        }
        if (productDto.getType() == null || productDto.getType().isEmpty()) {
            throw new IllegalArgumentException("The product type is required.");
        }
        if (productDto.getBrand() == null || productDto.getBrand().isEmpty()) {
            throw new IllegalArgumentException("The product brand is required.");
        }
        if (productDto.getColor() == null || productDto.getColor().isEmpty()) {
            throw new IllegalArgumentException("The product color is required.");
        }
    }
}
