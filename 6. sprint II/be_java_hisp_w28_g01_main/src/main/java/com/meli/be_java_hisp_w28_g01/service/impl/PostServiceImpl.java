package com.meli.be_java_hisp_w28_g01.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w28_g01.dto.request.PostDto;
import com.meli.be_java_hisp_w28_g01.dto.request.PromoPostDto;
import com.meli.be_java_hisp_w28_g01.dto.response.*;
import com.meli.be_java_hisp_w28_g01.dto.request.ProductDto;
import com.meli.be_java_hisp_w28_g01.dto.response.PostByUserDto;
import com.meli.be_java_hisp_w28_g01.dto.response.ResponsePostDto;
import com.meli.be_java_hisp_w28_g01.dto.response.SellerDto;
import com.meli.be_java_hisp_w28_g01.exception.IsEmptyException;
import com.meli.be_java_hisp_w28_g01.exception.NotFoundException;
import com.meli.be_java_hisp_w28_g01.model.Post;
import com.meli.be_java_hisp_w28_g01.model.Product;
import com.meli.be_java_hisp_w28_g01.model.PromoPost;
import com.meli.be_java_hisp_w28_g01.model.Seller;
import com.meli.be_java_hisp_w28_g01.repository.IPostRepository;
import com.meli.be_java_hisp_w28_g01.service.IFollowService;
import com.meli.be_java_hisp_w28_g01.service.IPostService;
import com.meli.be_java_hisp_w28_g01.service.IProductService;
import com.meli.be_java_hisp_w28_g01.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    IPostRepository repository;
    @Autowired
    IProductService productService;
    @Autowired
    ISellerService sellerService;
    @Autowired
    IFollowService followService;


    @Override
    public List<ResponsePostDto> getAll() {
        return repository.getAll()
                .stream()
                .map(s -> {
                    ResponsePostDto dto = toResponsePostDto(s);
                    return dto;
                })
                .toList();
    }
    @Override
    public List<ResponsePostDto> getByProductType(String type){
        List<ResponsePostDto> listPostByProductType = getAll().stream()
                .filter(post -> post.getProduct().getType().equalsIgnoreCase(type))
                .toList();
        if(listPostByProductType.isEmpty()){
            throw new IsEmptyException("productos de tipo "+type);
        }
        return listPostByProductType;
    }

    @Override
    public ResponsePostDto getByid(int id) {
        ResponsePostDto PostById = getAll().stream()
                .filter(post -> post.getPostId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(id, "post"));

        return PostById;   }

    @Override
    public String add(PostDto postDto) {
        Product p = productService.findById(postDto.getProductDto().getId()).orElse(null);
        if (p == null){
            p = productService.add(postDto.getProductDto());
        }
        Seller seller = sellerService.findById(postDto.getUserId()).orElse(null);
        if (seller == null){
            throw new NotFoundException(postDto.getUserId(), "Seller");
        }
        LocalDate formatedDate = LocalDate.of(postDto.getDate().getYear(),postDto.getDate().getMonth(), postDto.getDate().getDayOfMonth());
        Post post = new Post(
                repository.getAll().size()+1,
                seller,
                formatedDate,
                p,
                postDto.getCategory(),
                postDto.getPrice()
        );
        repository.add(post);
        return "Se creó la publicación correctamente con el id: " + post.getId();
    }

    @Override
    public PostByUserDto getPostsByUser(int userId) {
        List<Integer> sellerIds = followService.getFollowedSeller(userId).getFollowed().stream()
                .map(SellerDto::getId)
                .toList();

        List<Post> filteredPosts = filterSellerPost(sellerIds);

        return convertToDto(filteredPosts, userId);
    }


    @Override
    public PromoPostCountDto getPromoPostCount(int userId) {
        Optional<Seller> foundSeller = sellerService.findById(userId);
        if (foundSeller.isEmpty()){
            throw new NotFoundException(userId,"vendedor");
        }
        int promoPostCount = (int) repository.getAll()
                .stream()
                .filter(p->p.getSeller().getId() == userId && p.getClass() == PromoPost.class)
                .count();
        PromoPostCountDto promoPostCountDto = new PromoPostCountDto(userId,foundSeller.get().getName(),promoPostCount);
        return promoPostCountDto;
    }

    private List<Post> filterSellerPost(List<Integer> sellerIds) {
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        return repository.getAll().stream()
                .filter( p -> sellerIds.contains(p.getSeller().getId()))
                .filter(post -> post.getDate() != null && post.getDate().isAfter(twoWeeksAgo))
                .sorted(Comparator.comparing(Post::getDate).reversed())
                .toList();
    }

    private PostByUserDto convertToDto(List<Post> filteredPosts, int userId) {
        List<ResponsePostDto> convertedPosts = filteredPosts.stream()
                .map(this::toResponsePostDto)
                .toList();

        return new PostByUserDto(userId, convertedPosts);
    }

    private ResponsePostDto toResponsePostDto(Post post) {
        ProductDto productDto = new ProductDto(
                post.getProduct().getId(),
                post.getProduct().getName(),
                post.getProduct().getType(),
                post.getProduct().getBrand(),
                post.getProduct().getColor(),
                post.getProduct().getNotes()
        );

        return new ResponsePostDto(
                post.getSeller().getId(),
                post.getId(),
                post.getDate(),
                productDto,
                post.getCategory(),
                post.getPrice()
        );
    }

    @Override
    public String addPromoPost(PromoPostDto promoPostDto) {

        Product p = productService.findById(promoPostDto.getProductDto().getId()).orElse(null);
        if (p == null){
            p = productService.add(promoPostDto.getProductDto());
        }

        Seller seller = sellerService.findById(promoPostDto.getUserId())
                .orElseThrow(() -> new NotFoundException(promoPostDto.getUserId(), "Seller"));

        LocalDate formatedDate = LocalDate.of(promoPostDto.getDate().getYear(),promoPostDto.getDate().getMonth(), promoPostDto.getDate().getDayOfMonth());
        PromoPost promoPost = new PromoPost(
                repository.getAll().size()+1,
                seller,
                formatedDate,
                p,
                promoPostDto.getCategory(),
                promoPostDto.getPrice()*promoPostDto.getDiscount(),
                promoPostDto.getHasPromo(),
                promoPostDto.getDiscount()
        );
        repository.add(promoPost);
        return "Se creó la publicación correctamente con el id: " + promoPost.getId();
    }


    @Override
    public PostByUserDto getPostByUserOrderedByDate(int userId, String order) {
        if (order.isEmpty()){
            throw new IllegalArgumentException("Se debe ingresar un tipo de ordenamiento");
        }
        List<ResponsePostDto> responsePostDtosList= new ArrayList<>();
        if (order.equals("date_asc")){
            responsePostDtosList = getPostsByUser(userId).getPosts().stream().sorted(Comparator.comparing(ResponsePostDto::getDate)).toList();
        }else
        if (order.equals("date_desc")){
            responsePostDtosList = getPostsByUser(userId).getPosts().stream().sorted(Comparator.comparing(ResponsePostDto::getDate).reversed()).toList();
        }
        else{
            throw new IllegalArgumentException("Se ingresó un tipo de ordenamiento incorrecto");
        }
        PostByUserDto postByUserDto = new PostByUserDto(userId,responsePostDtosList);
        return postByUserDto;
    }
}
