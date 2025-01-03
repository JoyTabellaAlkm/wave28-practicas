package com.mercadolibre.sprint1.service.impl;

import static com.mercadolibre.sprint1.utils.CResourceUtils.MAPPER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.sprint1.dto.request.CreatePromoPostDto;
import com.mercadolibre.sprint1.dto.request.NewPostDto;
import com.mercadolibre.sprint1.dto.PostDto;
import com.mercadolibre.sprint1.dto.util.PostPromoDto;
import com.mercadolibre.sprint1.dto.response.PostPromoListDto;
import com.mercadolibre.sprint1.dto.response.ProductsFollowedDtoResponse;
import com.mercadolibre.sprint1.dto.util.UserFollowerDto;
import com.mercadolibre.sprint1.dto.response.CountProductsPromoDto;
import com.mercadolibre.sprint1.entity.Post;
import com.mercadolibre.sprint1.entity.User;
import com.mercadolibre.sprint1.entity.UserFollower;
import com.mercadolibre.sprint1.exception.BadRequestException;
import com.mercadolibre.sprint1.exception.NotFoundException;
import com.mercadolibre.sprint1.repository.IRepository;
import com.mercadolibre.sprint1.service.IProductService;
import com.mercadolibre.sprint1.service.IUserService;
import com.mercadolibre.sprint1.utils.CResourceUtils;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IRepository<Post> postRepository;

    @Autowired
    private IRepository<UserFollower> userFollowerRepository;

    @Autowired
    private IUserService userService;

    @Override
    public ProductsFollowedDtoResponse productsOfPeopleFollowed(int id, String order) {
        CResourceUtils.MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Comparator<Post> orden = Comparator.comparing(Post::getDate);
        if (order != null && order.equalsIgnoreCase("date_desc")) {
            orden = Comparator.comparing(Post::getDate).reversed();
        } else if (order != null && !order.equalsIgnoreCase("date_asc")) {
            throw new BadRequestException("El orden enviado no es válido, debe ser date_asc o date_desc.");
        }

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaHaceDosSemanas = fechaActual.minusWeeks(2);
        List<Integer> idUsuarios = userFollowerRepository.findAll().stream()
                .filter(entry -> entry.getUserFollower() == id)
                .map(entry -> MAPPER.convertValue(entry, UserFollowerDto.class))
                .map(UserFollowerDto::getUserFollowed)
                .toList();

        List<Post> posts = new ArrayList<>();
        for (Integer usuarios : idUsuarios) {
            posts.addAll(filterPostsByUserIds(usuarios));
        }

        List<PostDto> postDto = posts.stream()
                .filter(entry -> (entry.getDate().isAfter(fechaHaceDosSemanas)
                        || entry.getDate().isEqual(fechaHaceDosSemanas)) &&
                        (entry.getDate().isBefore(fechaActual) || entry.getDate().isEqual(fechaActual)))
                .sorted(orden)
                .map(entry -> {
                    PostDto dto = MAPPER.convertValue(entry, PostDto.class);
                    dto.setId(entry.getId());
                    return dto;
                })
                .toList();

        return new ProductsFollowedDtoResponse(id, postDto);
    }

    private List<Post> filterPostsByUserIds(Integer userIds) {
        return postRepository.findAll().stream()
                .filter(post -> post.getUserId() == userIds)
                .collect(Collectors.toList());
    }

    @Override
    public String createPromoPost(CreatePromoPostDto postPromo) {
        CResourceUtils.MAPPER.registerModule(new JavaTimeModule());
        CResourceUtils.MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        if(!CResourceUtils.validateRequestBody(postPromo)) throw new BadRequestException("El objeto enviado no es correcto o está incompleto");
        try {
            postRepository.save(CResourceUtils.MAPPER.convertValue(postPromo, Post.class));
            return "Post guardado";
        } catch (Exception e) {
            throw new BadRequestException("El objeto enviado no es correcto");
        }
    }

    @Override
    public String newPost(NewPostDto newPostDto) {
        CResourceUtils.MAPPER.registerModule(new JavaTimeModule());
        CResourceUtils.MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        if(!CResourceUtils.validateRequestBody(newPostDto)) throw new BadRequestException("El objeto enviado no es correcto o está incompleto");
        try {
            postRepository.save(CResourceUtils.MAPPER.convertValue(newPostDto, Post.class));
        } catch (Exception e) {
            throw new BadRequestException("El objeto enviado no es correcto");
        }
        return "todo OK";
    }

    @Override
    public PostPromoListDto listProductsPromo(int userId) {
        User findSeller = userService.findUserById(userId);

        if (findSeller.isSeller()) {
            List<PostPromoDto> promoPosts = postRepository.findAll()
                    .stream()
                    .filter(u -> u.isHasPromo() && u.getUserId() == userId)
                    .map(postList -> {
                        PostPromoDto postPromoDto = MAPPER.convertValue(postList, PostPromoDto.class);
                        postPromoDto.setId(postList.getId());
                        return postPromoDto;
                    })
                    .collect(Collectors.toList());

            PostPromoListDto postPromoListDto = new PostPromoListDto();
            postPromoListDto.setUserId(userId);
            postPromoListDto.setName(findSeller.getName());
            postPromoListDto.setPosts(promoPosts);

            return postPromoListDto;
        }

        throw new NotFoundException("El usuario no es un vendedor");
    }

    @Override
    public CountProductsPromoDto findPromoProductsBySeller(int userId) {
        User user = userService.findUserById(userId);
        long promoProducts = postRepository.findAll()
                .stream()
                .filter(p -> p.getUserId() == userId && p.isHasPromo())
                .count();

        return new CountProductsPromoDto(user.getId(), user.getName(), promoProducts);
    }

}
