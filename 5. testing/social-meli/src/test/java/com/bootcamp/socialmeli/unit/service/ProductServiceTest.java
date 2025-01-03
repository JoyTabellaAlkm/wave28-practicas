package com.bootcamp.socialmeli.unit.service;

import com.bootcamp.socialmeli.dto.response.ProductDto;
import com.bootcamp.socialmeli.entity.Product;
import com.bootcamp.socialmeli.factory.ProductFactory;
import com.bootcamp.socialmeli.mapper.ProductMapper;
import com.bootcamp.socialmeli.repository.IProductRepository;
import com.bootcamp.socialmeli.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    IProductRepository productRepository;

    @InjectMocks
    ProductService service;

    @Test
    public void givenTwoProductsInRepo_whenGettingAllProducts_thenReturnsAllProductsInRepository() {
        /* ARRANGE */
        int expectedListSize = 2;
        List<Product> productsInRepo = ProductFactory.getTwoGamerProducts();
        List<ProductDto> expectedResponse = productsInRepo.stream().map(ProductMapper::mapToProductDto).toList();
        when(productRepository.findAll()).thenReturn(productsInRepo);

        /* ACT */
        List<ProductDto> serviceResponse = service.getAllProducts();

        /* ASSERT */
        verify(productRepository, times(1)).findAll();
        assertThat(serviceResponse).isEqualTo(expectedResponse);
        assertThat(serviceResponse).hasSize(expectedListSize);
    }


    @Test
    public void givenAnEmptyProductRepo_whenGettingAllProducts_thenReturnsEmptyList() {
        /* ARRANGE */
        int expectedListSize = 0;
        List<Product> productsInRepo = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productsInRepo);

        /* ACT */
        List<ProductDto> serviceResponse = service.getAllProducts();

        /* ASSERT */
        verify(productRepository, times(1)).findAll();
        assertThat(serviceResponse).isEmpty();
        assertThat(serviceResponse).hasSize(expectedListSize);
    }
}
