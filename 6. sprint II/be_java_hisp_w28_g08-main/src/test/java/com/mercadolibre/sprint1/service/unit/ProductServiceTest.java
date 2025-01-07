package com.mercadolibre.sprint1.service.unit;

import static com.mercadolibre.sprint1.utils.CResourceUtils.MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.sprint1.dto.PostDto;
import com.mercadolibre.sprint1.dto.request.NewPostDto;
import com.mercadolibre.sprint1.dto.response.CountProductsPromoDto;
import com.mercadolibre.sprint1.dto.response.PostPromoListDto;
import com.mercadolibre.sprint1.dto.response.ProductsFollowedDtoResponse;
import com.mercadolibre.sprint1.entity.Post;
import com.mercadolibre.sprint1.entity.User;
import com.mercadolibre.sprint1.entity.UserFollower;
import com.mercadolibre.sprint1.exception.BadRequestException;
import com.mercadolibre.sprint1.exception.NotFoundException;
import com.mercadolibre.sprint1.repository.IRepository;
import com.mercadolibre.sprint1.repository.impl.PostRepositoryImpl;
import com.mercadolibre.sprint1.service.IUserService;
import com.mercadolibre.sprint1.service.impl.ProductServiceImpl;

import util.TestUtilGenerator;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    PostRepositoryImpl postRepository;

    @Mock
    IRepository<UserFollower> userFollowRepository;

    @Mock
    IUserService userService;

    @InjectMocks
    ProductServiceImpl productService;

    ObjectMapper om = new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Test
    @DisplayName("T-0005 - Devuelve un BadRequest si se envía un orden inválido")
    public void whenListProductsFollowedOrderInvalidShouldReturnError() {
        // Arrange
        int inputId = 1;
        String inputOrder = "invalid_order";
        String expectedMessage = "El orden enviado no es válido, debe ser date_asc o date_desc.";

        // Act
        BadRequestException expected = Assertions.assertThrows(BadRequestException.class,
                () -> productService.productsOfPeopleFollowed(inputId, inputOrder));

        // Assert
        Assertions.assertEquals(expectedMessage, expected.getMessage());
    }

    @Test
    @DisplayName("T-0006 - Devuelve publicaciones seguidas en las últimas dos semanas ordenadas ascendentemente")
    public void whenListProductsFollowedAscShouldReturnOrderedList() {
        // Arrange
        int inputId = 1;
        String inputOrder = "date_asc";
        ProductsFollowedDtoResponse expected = new ProductsFollowedDtoResponse(1, List.of(
                om.convertValue(TestUtilGenerator.generatePosts().get(1), PostDto.class),
                om.convertValue(TestUtilGenerator.generatePosts().getFirst(), PostDto.class)));

        when(userFollowRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(postRepository.findAll()).thenReturn(TestUtilGenerator.generatePosts());

        // Act
        ProductsFollowedDtoResponse response = productService.productsOfPeopleFollowed(inputId, inputOrder);

        // assert
        assertNotNull(response, "La respuesta no debe ser nula.");
        assertEquals(expected.getUserId(), response.getUserId(), "El userId de la respuesta no coincide.");
        assertEquals(expected.getPosts().size(), response.getPosts().size(),
                "El número de publicaciones devueltas no es correcto.");
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("T-0006 - Devuelve publicaciones seguidas en las últimas dos semanas ordenadas descendentemente")
    public void whenListProductsFollowedDescShouldReturnOrderedList() {
        // Arrange
        int inputId = 1;
        String inputOrder = "date_desc";
        ProductsFollowedDtoResponse expected = new ProductsFollowedDtoResponse(1, List.of(
                om.convertValue(TestUtilGenerator.generatePosts().getFirst(), PostDto.class),
                om.convertValue(TestUtilGenerator.generatePosts().get(1), PostDto.class)));

        when(userFollowRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(postRepository.findAll()).thenReturn(TestUtilGenerator.generatePosts());

        // Act
        ProductsFollowedDtoResponse response = productService.productsOfPeopleFollowed(inputId, inputOrder);

        // assert
        assertNotNull(response, "La respuesta no debe ser nula.");
        assertEquals(expected.getUserId(), response.getUserId(), "El userId de la respuesta no coincide.");
        assertEquals(expected.getPosts().size(), response.getPosts().size(),
                "El número de publicaciones devueltas no es correcto.");
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("T-0008 - Devuelve publicaciones seguidas en las últimas dos semanas ordenadas correctamente")
    public void whenUserSendedShouldListPostOfFollowedPeopleOfTheLastTwoWeeks() {
        // arrange
        int userId = 1;
        String order = "date_desc";

        // Mock de datos
        when(userFollowRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(postRepository.findAll()).thenReturn(TestUtilGenerator.generatePosts());

        ProductsFollowedDtoResponse expected = new ProductsFollowedDtoResponse(1, List.of(
                MAPPER.convertValue(TestUtilGenerator.generatePosts().getFirst(), PostDto.class),
                MAPPER.convertValue(TestUtilGenerator.generatePosts().get(1), PostDto.class)));

        // act
        ProductsFollowedDtoResponse response = productService.productsOfPeopleFollowed(userId, order);

        // assert
        assertNotNull(response, "La respuesta no debe ser nula.");
        assertEquals(expected.getUserId(), response.getUserId(), "El userId de la respuesta no coincide.");
        assertEquals(expected.getPosts().size(), response.getPosts().size(),
                "El número de publicaciones devueltas no es correcto.");
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("T-0010 - Guardado de post")
    public void whenPostCreatedShouldReturnPost() {
        // Arrange
        NewPostDto input = om.convertValue(TestUtilGenerator.generateNoPromoPost(), NewPostDto.class);
        Post inputModel = om.convertValue(input, Post.class);
        String expected = "todo OK";

        when(postRepository.save(inputModel)).thenReturn(inputModel);

        // Act & Assert
        assertEquals(expected, productService.newPost(input));
    }

    @Test
    @DisplayName("T-0010 - Error al guardar un post")
    public void whenBadPostCreatedShouldReturnError() {
        // Arrange
        NewPostDto input = om.convertValue(TestUtilGenerator.generateNoPromoPost(), NewPostDto.class);
        input.setUserId(null);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> productService.newPost(input));
    }

    @Test
    @DisplayName("T-0011 - Guardado de post con promo validos")
    public void whenPostValidShouldReturnConfirmationMessage() {
        // Arrange
        when(postRepository.save(TestUtilGenerator.CreatePromoPost())).thenReturn(TestUtilGenerator.CreatePromoPost());

        // act
        String outputPostPromoSave = productService.createPromoPost(TestUtilGenerator.createPostPromoDto());

        // assert
        verify(postRepository, atLeastOnce()).save(TestUtilGenerator.CreatePromoPost());
        assertEquals("Post guardado", outputPostPromoSave);
    }

    @Test
    @DisplayName("T-0012 - Cuándo se envía un id de un vendedor, se espera que se devuelva la cantidad de productos en promoción de dicho vendedor")
    public void whenSendsSellerIdShouldReturnsPromoProductsQuantity() {
        // arrange
        User user = TestUtilGenerator.generateSeller();
        int quantityProductsExpected = 2;
        when(userService.findUserById(user.getId())).thenReturn(user);
        when(postRepository.findAll()).thenReturn(TestUtilGenerator.generatePosts());

        // act
        CountProductsPromoDto res = productService.findPromoProductsBySeller(user.getId());

        // assert
        assertNotNull(res);
        assertEquals(quantityProductsExpected, res.getPromoProductsCount());
    }

    @Test
    @DisplayName("T-0012 - Cuándo se envía un id de un vendedor que no tiene posts, se espera que se devuelva 0 cómo la cantidad de productos en promoción de dicho vendedor")
    public void whenSendsSellerIdThatNotHavePostsShouldReturns0WhoPromoProductsQuantity() {
        // arrange
        User user = TestUtilGenerator.generateSellerWithoutPosts();
        int quantityProductsExpected = 0;
        when(userService.findUserById(user.getId())).thenReturn(user);
        when(postRepository.findAll()).thenReturn(TestUtilGenerator.generatePosts());

        // act
        CountProductsPromoDto res = productService.findPromoProductsBySeller(user.getId());

        // assert
        assertNotNull(res);
        assertEquals(quantityProductsExpected, res.getPromoProductsCount());
    }

    @Test
    @DisplayName("T-0013 - Cuando el usuario es vendedor debe retornar los productos en promoción")
    public void whenUserIsSellerShouldReturnPromoProducts() {
        // Arrange
        User user = TestUtilGenerator.generateSeller();
        int numberProducts = 2;
        when(userService.findUserById(user.getId())).thenReturn(user);
        when(postRepository.findAll()).thenReturn(TestUtilGenerator.generatePosts());

        // Act
        PostPromoListDto res = productService.listProductsPromo(user.getId());

        // Assert
        assertNotNull(res);
        assertEquals(numberProducts, user.getId());
        assertEquals("Cristhian", user.getName());
        assertEquals(2, res.getPosts().size());
        assertTrue(res.getPosts().get(0).isHasPromo());
    }

    @Test
    @DisplayName("T-0013 - Cuando el usuario no es vendedor debe arrojar una excepción NotFoundException")
    public void whenUserIsNotSellerShouldThrowNotFoundException() {
        // Arrange
        User user = TestUtilGenerator.generateUser();
        when(userService.findUserById(user.getId())).thenReturn(user);

        // Act
        Exception exception = assertThrows(NotFoundException.class, () -> {
            productService.listProductsPromo(user.getId());
        });

        // Assert
        assertEquals("El usuario no es un vendedor", exception.getMessage());
    }

}
