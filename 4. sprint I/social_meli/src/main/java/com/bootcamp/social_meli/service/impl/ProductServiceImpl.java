package com.bootcamp.social_meli.service.impl;

import com.bootcamp.social_meli.dto.response.*;
import com.bootcamp.social_meli.exception.BadRequestException;
import com.bootcamp.social_meli.exception.NotFoundException;
import com.bootcamp.social_meli.model.Post;
import com.bootcamp.social_meli.model.Product;
import com.bootcamp.social_meli.model.User;
import com.bootcamp.social_meli.repository.IPostRepository;
import com.bootcamp.social_meli.repository.IProductRepository;
import com.bootcamp.social_meli.repository.IUserRepository;
import com.bootcamp.social_meli.dto.response.AmountOfPromosDTO;
import com.bootcamp.social_meli.service.IProductService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {
    private final IUserRepository userRepository;
    private final IPostRepository postRepository ;
    private final IProductRepository productRepository ;

    public ProductServiceImpl(IUserRepository userRepository, IPostRepository postRepository, IProductRepository productRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.productRepository = productRepository;
    }
    @Override
    public PostsFromFollowsDTO getAllPostFollowsLastTwoWeeksUnordered(Long userId) {
        List<User> followedList = userRepository.findFollowsByUserId(userId);
        if (followedList == null) throw new NotFoundException("The user with id: " + userId + " does not follow anyone");

        List<PostNoDiscountDTO> postsNoDiscountFromFollowsDTOSList = new ArrayList<>();

        for (User user : followedList) {
            List<PostNoDiscountDTO> postNoDiscountDTOList;

            List<Post> lastTwoWeeksPosts = postRepository.findByUserIdFilteredByLastTwoWeeks(user.getId());

            postNoDiscountDTOList = lastTwoWeeksPosts.stream().map(post -> new PostNoDiscountDTO(post.getCreatorUser().getId(), post.getId(), post.getCreateDate(), new ProductDTO(
                    post.getProduct().getId(),
                    post.getProduct().getName(),
                    post.getProduct().getType(),
                    post.getProduct().getBrand(),
                    post.getProduct().getColor(),
                    post.getProduct().getNotes()
            ), post.getCategory(), post.getPrice())).toList();

            postsNoDiscountFromFollowsDTOSList.addAll(postNoDiscountDTOList);
        }

        PostsFromFollowsDTO postsFromFollowsDTO = new PostsFromFollowsDTO(userId, postsNoDiscountFromFollowsDTOSList);

        return postsFromFollowsDTO;
    }
    @Override
    public PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Long userId, String order) {
        PostsFromFollowsDTO postsFromFollowsDTOSList = getAllPostFollowsLastTwoWeeksUnordered(userId);
        List<PostNoDiscountDTO> posts = postsFromFollowsDTOSList.getPosts();

        if (order != null && !StringUtils.isBlank(order)) {
            Comparator<PostNoDiscountDTO> comparator = Comparator.comparing(PostNoDiscountDTO::getCreateDate);

            posts = postsFromFollowsDTOSList.getPosts().stream()
                    .sorted("date_desc".equals(order) ? comparator.reversed() : comparator)
                    .toList();
        }

        return new PostsFromFollowsDTO(userId, posts);
    }

    @Override
    public MostProductsResponseDTO getMostProducts() {
        List<Post> posts = postRepository.findAll();
        Map<Long, Integer> productPostCounts = new HashMap<>();

        for (Post post : posts) {
            long productId = post.getProduct().getId();
            productPostCounts.put(productId, productPostCounts.getOrDefault(productId, 0) + 1);
        }

        List<ProductWithPostCountDTO> productList = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : productPostCounts.entrySet()) {
            long productId = entry.getKey();
            Integer postCount = entry.getValue();

            Optional<Product> productOpt = productRepository.findById(productId);
            if (productOpt.isPresent()) {
                Product product = productOpt.get();
                productList.add(new ProductWithPostCountDTO(
                        product.getId(),
                        product.getName(),
                        product.getType(),
                        product.getBrand(),
                        product.getColor(),
                        product.getNotes(),
                        postCount
                ));
            }
        }

        productList.sort((p1, p2) -> Long.compare(p2.getProducts_count(), p1.getProducts_count()));

        return new MostProductsResponseDTO(productList);
    }

    @Override
    public MostProductsResponseDTO getMostProducts(String rank) {
        int rankInt;

        try {
            rankInt = Integer.parseInt(rank);
        } catch (NumberFormatException e) {
            throw new BadRequestException("El rank debe ser un valor numerico.");
        }

        List<Post> posts = postRepository.findAll();
        Map<Long, Integer> productPostCounts = new HashMap<>();

        for (Post post : posts) {
            long productId = post.getProduct().getId();
            productPostCounts.put(productId, productPostCounts.getOrDefault(productId, 0) + 1);
        }

        List<ProductWithPostCountDTO> productList = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : productPostCounts.entrySet()) {
            long productId = entry.getKey();
            Integer postCount = entry.getValue();

            Optional<Product> productOpt = productRepository.findById(productId);
            if (productOpt.isPresent()) {
                Product product = productOpt.get();
                productList.add(new ProductWithPostCountDTO(
                        product.getId(),
                        product.getName(),
                        product.getType(),
                        product.getBrand(),
                        product.getColor(),
                        product.getNotes(),
                        postCount
                ));
            }
        }

        productList.sort((p1, p2) -> Long.compare(p2.getProducts_count(), p1.getProducts_count()));

        List<ProductWithPostCountDTO> limitedProductList = productList.stream()
                .limit(rankInt)
                .collect(Collectors.toList());

        return new MostProductsResponseDTO(limitedProductList);
    }

    @Override
    public AmountOfPromosDTO getAmountOfPromosByUser(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        if (user.isEmpty()){
            throw new NotFoundException("Usuario no encontrado");
        }
        List<Post> amountOfPromos = postRepository.findAmountOfPromosByUserId(user.get());
        AmountOfPromosDTO amountOfPromosDTO = new AmountOfPromosDTO(amountOfPromos.size());
        amountOfPromosDTO.setUser_id(user.get().getId());
        amountOfPromosDTO.setUser_name(user.get().getUsername());

        return amountOfPromosDTO;
    }
}
