package com.mercadolibre.be_java_hisp_w28_g10.service.impl;

import com.mercadolibre.be_java_hisp_w28_g10.dto.post.PostDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.post.ProductDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.follow.ResponseFollowedPostsDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ProductsWithPromoDTO;
import com.mercadolibre.be_java_hisp_w28_g10.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w28_g10.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w28_g10.model.Post;
import com.mercadolibre.be_java_hisp_w28_g10.model.User;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponsePostNoPromoDTO;
import com.mercadolibre.be_java_hisp_w28_g10.model.Product;
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
        User user = validateUser(id);
        List<Post> product = productRepository.findAllPost();
        List<Post> productFilter = product.stream()
                .filter(p -> p.getId() == user.getId()).filter(Post::isHasPromo)
                .toList();

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
    public ResponseFollowedPostsDTO getLastFollowedPosts(Integer userId, String order) {
        validateUser(userId);
        List<Integer> followedIds = getFollowedUserIds(userId);
        List<Post> followedPosts = getFollowedPostsAfterDate(followedIds, LocalDate.now().minusWeeks(2));
        List<Post> sortedFollowedPosts = sortPostsByDate(followedPosts, order);

        List<ResponsePostNoPromoDTO> responsePosts = sortedFollowedPosts.stream()
                .map(post -> new ResponsePostNoPromoDTO(
                        post.getId(),
                        post.getPostId(),
                        post.getDate().toString(),
                        post.getCategory(),
                        post.getPrice(),
                        utilities.convertValue(post.getProduct(), ProductDTO.class)))
                .toList();

        return new ResponseFollowedPostsDTO(userId, responsePosts);
    }

    /**
     * Validates that the user exists.
     *
     * @param userId the ID of the user to validate.
     * @throws NotFoundException if the user doesn't exist in the system.
     * @return the User object if found.
     */
    private User validateUser(Integer userId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }

    /**
     * Retrieves a list of IDs for the users that the specified user follows.
     *
     * @param userId the ID of the user whose followed users' IDs are to be retrieved.
     * @return a list of user IDs that the specified user follows.
     */
    private List<Integer> getFollowedUserIds(Integer userId) {
        return userRepository.getFollowRelationsByFollowerId(userId)
                .stream()
                .map(FollowRelation::getIdFollowed)
                .toList();
    }

    /**
     * Filters and retrieves posts from followed users created after the specified date.
     *
     * @param followedIds a list of IDs corresponding to users that are followed.
     * @param sinceDate the date representing the cutoff for post retrieval.
     * @return a list of posts from followed users created after the specified date.
     */
    private List<Post> getFollowedPostsAfterDate(List<Integer> followedIds, LocalDate sinceDate) {
        List<Post> posts = productRepository.findAllPost();

        return posts.stream()
                .filter(post -> followedIds.contains(post.getId()) && post.getDate().isAfter(sinceDate))
                .toList();
    }

    /**
     * Sorts the list of posts based on the order criteria.
     *
     * @param posts the list of posts to be sorted.
     * @param order parameter indicating the order criteria.
     * @return a sorted list of Posts.
     * @throws BadRequestException if the order criteria is invalid.
     */
    private List<Post> sortPostsByDate(List<Post> posts, String order) {
        Comparator<Post> comparator;

        if (order.isEmpty() || order.equals("date_desc")) {
            comparator = Comparator.comparing(Post::getDate).reversed();
        } else if (order.equals("date_asc")) {
            comparator = Comparator.comparing(Post::getDate);
        } else {
            throw new BadRequestException("That's not a valid order criteria: " + order);
        }

        return posts.stream()
                .sorted(comparator)
                .toList();
    }

    /**
     * Validates the provided post data and saves it. This includes ensuring the associated product exists.
     *
     * @param post the {@link PostDTO} to be validated and saved.
     * @return true if the operation was successful; false otherwise.
     */
    private boolean savePostLogic(PostDTO post) {
        Product product = utilities.convertValue(post.getProduct(), Product.class);
        if (!productRepository.existsProduct(post.getProduct().getId())) {
            productRepository.addProduct(product);
        }
        Post.counterPostId += 1;
        post.setPostId(Post.counterPostId);
        return productRepository.addPost(utilities.convertValue(post, Post.class));
    }

}
