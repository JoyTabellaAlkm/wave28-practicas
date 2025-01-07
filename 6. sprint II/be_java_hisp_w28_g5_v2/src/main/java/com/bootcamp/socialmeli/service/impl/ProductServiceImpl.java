package com.bootcamp.socialmeli.service.impl;

import com.bootcamp.socialmeli.dto.PostDto;
import com.bootcamp.socialmeli.dto.PostPromoDto;
import com.bootcamp.socialmeli.dto.PromoProductsCountDto;
import com.bootcamp.socialmeli.dto.request.PostPromoRequestDto;
import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.dto.response.GetFollowedProductsDto;
import com.bootcamp.socialmeli.dto.response.PostResponseDto;
import com.bootcamp.socialmeli.exception.BadRequestException;
import com.bootcamp.socialmeli.exception.IdProductConflictException;
import com.bootcamp.socialmeli.exception.NotFoundException;
import com.bootcamp.socialmeli.exception.OrderInvalidException;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.PostRepository;
import com.bootcamp.socialmeli.repository.ProductRepository;
import com.bootcamp.socialmeli.repository.UserRepository;
import com.bootcamp.socialmeli.service.ProductService;
import com.bootcamp.socialmeli.util.mapper.DateMapper;
import com.bootcamp.socialmeli.util.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    final private String ORD_DATE_ASC = "date_asc";
    final private String ORD_DATE_DESC = "date_desc";

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public GetFollowedProductsDto followedProducts(Long userId, Optional<String> type_order) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User", userId));
        List<PostResponseDto> posts;
        Comparator<PostResponseDto> comparator =
                Comparator.comparing((PostResponseDto p) -> DateMapper.toLocalDate(p.getDate())).reversed();

        if (type_order.isPresent() && type_order.get().equals(ORD_DATE_ASC)) {
            comparator = Comparator.comparing((PostResponseDto p) -> DateMapper.toLocalDate(p.getDate()));
        } else if (type_order.isPresent() && !type_order.get().equals(ORD_DATE_DESC)) {
            throw new OrderInvalidException("Invalid Sort order");
        }

        posts = user.getFollowed().stream()
                .flatMap(followed -> followed.getPosts().stream()
                        .filter(p -> p.getDate().isAfter(LocalDate.now().minusDays(14)))
                        .map(p -> PostMapper.toPostResponseDto(p, followed.getId())))
                .sorted(comparator)
                .toList();
        return new GetFollowedProductsDto(userId, posts);
    }

    @Override
    public PostDto createPost(PostCreationDto postDto) {
        User user = userRepository.findById(postDto.getUser_id())
                .orElseThrow(() -> new NotFoundException("User", postDto.getUser_id()));
        Post newPost = PostMapper.toPost(postDto);

        checkProductExistenceAndSave(user, newPost);

        return PostMapper.toPostDto(newPost);
    }

    @Override
    public PostPromoDto createPostWithDiscount(PostPromoRequestDto postPromoDto) {
        User user = userRepository.findById(postPromoDto.getUserId())
                .orElseThrow(() -> new NotFoundException("User", postPromoDto.getUserId()));
        Post newPost = PostMapper.toPost(postPromoDto);

        checkProductExistenceAndSave(user, newPost);

        return PostMapper.toPostPromoDto(newPost);
    }

    private void checkProductExistenceAndSave(User user, Post newPost) {
        Optional<Product> existingProduct = productRepository.findById(newPost.getProduct().getId());
        if (existingProduct.isPresent()) {
            boolean userHasPostForProduct = user.getPosts().stream()
                    .anyMatch(post -> post.getProduct().getId()
                            .equals(newPost.getProduct().getId()));
            if (userHasPostForProduct) {
                throw new IdProductConflictException(newPost.getProduct().getId());
            } else {
                Product product = newPost.getProduct();
                if (!product.getName().equalsIgnoreCase(existingProduct.get().getName()) ||
                        !product.getType().equalsIgnoreCase(existingProduct.get().getType()) ||
                        !product.getBrand().equalsIgnoreCase(existingProduct.get().getBrand()) ||
                        !product.getColor().equalsIgnoreCase(existingProduct.get().getColor()) ||
                        !product.getNotes().equalsIgnoreCase(existingProduct.get().getNotes())) {
                    throw new BadRequestException("Inconsistent data on existing new product.");
                }
                newPost.setProduct(existingProduct.get());
            }
        } else {
            productRepository.saveProduct(newPost.getProduct());
        }
        postRepository.save(newPost);
        user.getPosts().add(newPost);
    }
    @Override
    public PromoProductsCountDto getPromoProductCount(Long id ){
        User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("User", id));

        Integer promoProductsCount = user.getPosts().stream().filter(Post::isHasPromo).toList().size();
        return new PromoProductsCountDto(user.getId(), user.getName(), promoProductsCount);

    }

}
