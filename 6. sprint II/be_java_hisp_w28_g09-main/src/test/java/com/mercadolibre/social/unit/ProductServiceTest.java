package com.mercadolibre.social.unit;

import com.mercadolibre.social.dto.response.PostDetailsDTO;
import com.mercadolibre.social.entity.Post;
import com.mercadolibre.social.entity.Product;
import com.mercadolibre.social.repository.impl.PostRepository;
import com.mercadolibre.social.repository.impl.ProductRepository;
import com.mercadolibre.social.service.impl.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private ProductService productService;


    @Test
    @DisplayName("UT-BONUS: Verificar que se devuelven posts filtrados por query correctamente")
    void givenQuery_whenSearch_thenReturnFilteredPosts() {
        // ARRANGE
        String query = "product";
        String rangePrice = "";

        List<Product> products = List.of(
                new Product(1, "productName", "type", "brand", "color", "notes"),
                new Product(2, "anotherProduct", "type", "brand", "color", "notes")
        );
        when(productRepository.findProductsByQuery(query)).thenReturn(products);

        List<Post> posts = List.of(
                new Post(1, 1, LocalDate.now(), 1, 1, 10.0, false, 0.0),
                new Post(2, 1, LocalDate.now().minusDays(1), 2, 1, 20.0, false, 0.0)
        );
        when(postRepository.findByProductId(1)).thenReturn(posts);
        when(postRepository.findByProductId(2)).thenReturn(List.of());

        // ACT
        List<PostDetailsDTO> result = productService.search(query, rangePrice);

        // ASSERT
        assertEquals(2, result.size());
        assertEquals(1, result.getFirst().getUserId());
        assertEquals(10.0, result.getFirst().getPrice());
    }

    @Test
    @DisplayName("UT-BONUS: Verificar que se filtran correctamente los posts por rango de precio")
    void givenValidRangePrice_whenSearch_thenReturnFilteredPosts() {
        // ARRANGE
        String query = "product";
        String rangePrice = "10-20";

        List<Product> products = List.of(
                new Product(1, "productName", "type", "brand", "color", "notes")
        );
        when(productRepository.findProductsByQuery(query)).thenReturn(products);

        List<Post> posts = List.of(
                new Post(1, 1, LocalDate.now(), 1, 1, 10.0, false, 0.0),
                new Post(2, 1, LocalDate.now().minusDays(1), 2, 1, 30.0, false, 0.0)
        );
        when(postRepository.findByProductId(1)).thenReturn(posts);

        // ACT
        List<PostDetailsDTO> result = productService.search(query, rangePrice);

        // ASSERT
        assertEquals(1, result.size());
        assertEquals(10.0, result.getFirst().getPrice());
    }

}