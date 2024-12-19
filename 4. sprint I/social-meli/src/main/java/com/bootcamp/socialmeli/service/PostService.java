package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.request.PostDto;
import com.bootcamp.socialmeli.dto.response.PromoPostsDto;
import com.bootcamp.socialmeli.dto.response.RecentPostDto;
import com.bootcamp.socialmeli.dto.response.RecentPostsDto;
import com.bootcamp.socialmeli.dto.response.ResponseMessageDto;
import com.bootcamp.socialmeli.exception.BadRequestException;
import com.bootcamp.socialmeli.mapper.ProductMapper;
import com.bootcamp.socialmeli.repository.*;
import com.bootcamp.socialmeli.entity.Post;
import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.exception.NotFoundException;
import com.bootcamp.socialmeli.mapper.PostMapper;
import com.bootcamp.socialmeli.utils.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {
    private final UserRepository userRepository;
    private final IPostRepository postRepository;
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    public PostService(IPostRepository postRepository, UserRepository userRepository, IProductRepository productRepository, ICategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public RecentPostsDto getRecentFollowedPosts(int userId, String order) {
        User user = getUserIfExists(userId);
        List<Post> posts = postRepository.findAll();
        List<Post> postsCreatedByFollowed = postsCreatedByFollowedSellers(posts, user);
        List<Post> lastTwoWeeksPosts = postsCreatedRecently(postsCreatedByFollowed);
        List<RecentPostDto> mappedPosts = mapToRecentPostDto(lastTwoWeeksPosts, userId);
        List<RecentPostDto> orderedMappedPosts = orderAndReversePostsByDate(mappedPosts);

        RecentPostsDto recentPostDtoList = PostMapper.mapToRecentPostsDto(userId, orderedMappedPosts);
        recentPostDtoList.setPosts(Utils.sortList(recentPostDtoList.getPosts(), RecentPostDto::getDate, order.contains("asc")));

        return recentPostDtoList;
    }

    @Override
    public ResponseMessageDto publishPost(PostDto newPost, boolean isPromo) {

        int id = getAllPosts().getLast().getId() + 1;
        boolean productExist = productRepository.productExist(newPost.getProduct().getId());
        if (productExist) {
            throw new BadRequestException("El producto ya existe");
        }
        Post post = new Post();
        post = mapToPost(newPost, id);
        if (!isPromo) {
            post.setDiscount(0);
            post.setHasPromo(isPromo);
        }
        productRepository.addProduct(post.getProduct());
        postRepository.addPromotionalPost(post);
        return new ResponseMessageDto("Post creado con éxito!");
    }

    private List<RecentPostDto> orderAndReversePostsByDate(List<RecentPostDto> mappedPosts) {
        return mappedPosts.stream()
                .sorted(Comparator.comparing(RecentPostDto::getDate).reversed())
                .toList();
    }

    private User getUserIfExists(int userId) {
        Optional<User> user = userRepository.getUserById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException("No existe un usuario con ID " + userId);
        }
        return user.get();
    }

    private List<Post> postsCreatedByFollowedSellers(List<Post> posts, User user) {
        return posts.stream()
                .filter(post -> user.follows(getPostUser(post)))
                .toList();
    }

    private User getPostUser(Post post) {
        return getUserIfExists(post.getUserId());
    }

    private List<Post> postsCreatedRecently(List<Post> posts) {
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        return posts.stream()
                .filter(post -> post.getDate().isAfter(twoWeeksAgo) || post.getDate().isEqual(twoWeeksAgo))
                .toList();
    }

    private List<RecentPostDto> mapToRecentPostDto(List<Post> posts, int userId) {
        return posts.stream()
                .map(PostMapper::mapPostToRecentPostDto)
                .toList();
    }

    public List<PostDto> getAllPosts() {
        List<PostDto> postDtos = new ArrayList<>();
        postRepository.findAll().stream()
                .forEach(p -> {
                    PostDto post = PostMapper.mapToPostDto(p);
                    postDtos.add(post);
                });

        return postDtos;
    }

    public PromoPostsDto getUserPromoCount(int userId) {
        User user = getUserIfExists(userId);
        List<Post> posts = postRepository.findAll();
        List<Post> userPostsWithPromo = filterUserPostsWithPromo(userId, posts);
        return PostMapper.mapToPromoPostsDto(userPostsWithPromo, user);
    }

    private List<Post> filterUserPostsWithPromo(int userId, List<Post> posts) {
        return posts.stream()
                .filter(post -> post.getUserId() == userId && post.isHasPromo())
                .toList();
    }

    private Post mapToPost(PostDto newPost, int id) {
        if (newPost == null) {
            throw new BadRequestException("Formato incorrecto");
        }
        validatePostDto(newPost);

        Post post = new Post();
        post.setId(id);
        if (userRepository.getUserById(newPost.getUserId()).isEmpty()) {
            throw new BadRequestException("Usuario inexistente");
        }
        post.setUserId(newPost.getUserId());
        post.setDate(newPost.getDate());
        post.setProduct(ProductMapper.mapToProduct(newPost.getProduct()));

        if (newPost.getPrice() > 0) {
            post.getProduct().setPrice(newPost.getProduct().getPrice());
        } else {
            throw new BadRequestException("Formato incorrecto");
        }

        post.setCategory(newPost.getCategory());
        if (categoryRepository.getCategoryById(newPost.getCategory()).isEmpty()) {
            throw new BadRequestException("Categoria inexistente");
        }
        post.setHasPromo(newPost.isHasPromo());
        post.setDiscount(newPost.getDiscount());

        return post;
    }

    private void validatePostDto(PostDto newPost) {
        if (newPost.getUserId() <= 0) {
            throw new BadRequestException("Formato incorrecto");
        }
        if (newPost.getDate() == null) {
            throw new BadRequestException("Formato incorrecto");
        }
        if (newPost.getProduct() == null) {
            throw new BadRequestException("Formato incorrecto");
        }
        if (newPost.getCategory() <= 0) {
            throw new BadRequestException("Formato incorrecto");
        }
    }
}
