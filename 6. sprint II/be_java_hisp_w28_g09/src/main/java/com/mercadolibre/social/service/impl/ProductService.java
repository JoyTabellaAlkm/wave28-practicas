package com.mercadolibre.social.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.social.dto.ProductSearchDto;
import com.mercadolibre.social.dto.response.PostDetailsDTO;
import com.mercadolibre.social.dto.response.ProductCountPromoPostDto;
import com.mercadolibre.social.dto.response.ProductResponseDTO;
import com.mercadolibre.social.entity.Post;
import com.mercadolibre.social.entity.Product;
import com.mercadolibre.social.exception.BadRequestException;
import com.mercadolibre.social.repository.IPostRepository;
import com.mercadolibre.social.repository.IProductRepository;
import com.mercadolibre.social.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final IPostRepository postRepository;

    public ProductService(IProductRepository productRepository, IPostRepository postRepository) {
        this.productRepository = productRepository;
        this.postRepository = postRepository;
    }


    @Override
    public List<PostDetailsDTO> search(String query, String rangePrice) {
        List<PostDetailsDTO> postFilteredByQuery = new ArrayList<>();
        // Se busca los productos que contenga la query en el nombre, notes, ...
        List<Product> products = productRepository.findProductsByQuery(query);
        // Se recorren los productos encontrados para buscar los post relacionados
        products.forEach(product -> {
                    // se busca los post relacionados al producto
                    List<Post> posts = postRepository.findByProductId(product.getId());
                    // Se recorren los post encontrados para agregarlos a la lista de postFilteredByQuery
                    posts.forEach(post ->
                                postFilteredByQuery.add(
                                        new PostDetailsDTO(
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
                                        )
                                )
                            );

                }

        );
        if (!rangePrice.isEmpty()){
            try {
                String[] range = rangePrice.split("-");
                double minPrice = Double.parseDouble(range[0]);
                double maxPrice = Double.parseDouble(range[1]);
                return postFilteredByQuery.stream()
                        .filter(post -> post.getPrice() >= minPrice && post.getPrice() <= maxPrice).toList();
            } catch (Exception e){
                throw new BadRequestException("No se puede aplicar el filtro de precio");
            }
        }
        return postFilteredByQuery;
    }
}
