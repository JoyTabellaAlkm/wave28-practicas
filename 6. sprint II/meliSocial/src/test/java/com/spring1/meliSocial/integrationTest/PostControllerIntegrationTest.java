package com.spring1.meliSocial.integrationTest;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring1.meliSocial.dto.ExceptionDto;
import com.spring1.meliSocial.dto.response.PostIndexDto;
import com.spring1.meliSocial.dto.request.ProductPromoDto;
import com.spring1.meliSocial.dto.request.RequestPostDto;
import com.spring1.meliSocial.dto.response.PostPromoDto;
import com.spring1.meliSocial.dto.response.ProductDto;
import com.spring1.meliSocial.dto.response.ResponsePostDto;
import com.spring1.meliSocial.model.Post;
import com.spring1.meliSocial.model.Product;
import com.spring1.meliSocial.model.User;
import com.spring1.meliSocial.repository.impl.PostRepository;
import com.spring1.meliSocial.repository.impl.ProductRepository;
import com.spring1.meliSocial.repository.impl.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.spring1.meliSocial.dto.response.ResponseDto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PostControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    static ObjectMapper mapper;

    private static final ProductDto product1 = new ProductDto(17, "product1", "Ropa", "Marca", "Color", "");
    private static final RequestPostDto post1 = new RequestPostDto(1, LocalDate.now(), product1, 2, 100.0);

    private static final ProductPromoDto postPromo1 = new ProductPromoDto(1, LocalDate.now(), product1, 2, 100.0, true, 0.10);

    String testDesc;

    @BeforeAll
    static void setup() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public void generateUserWith2FollowedWithPosts(int userId, String username) {
        int idFirstPost = 1000;
        int idSecondPost = 1001;
        int idFirstProduct = 80;
        int idSecondProduct = 81;
        int sellerId = 2000;

        Product productFirstPost = new Product(
                idFirstProduct,
                "Mouse",
                "Tecnología",
                "Logitech",
                "Negro",
                "Mouse hergonómico altamente recomendado!.");
        Product productSecondPost = new Product(
                idSecondProduct,
                "Gorro",
                "Ropa",
                "DC",
                "Negro",
                "Gorro negro skater");

        User seller = new User(sellerId, "Jose Juarez", true, new ArrayList<>(List.of(userId)), new ArrayList<>(), new ArrayList<>(List.of(idFirstPost, idSecondPost)), new HashSet<>());
        Post post1 = new Post(idFirstPost, seller.getId(), LocalDate.now(),
                productFirstPost,
                55,
                15.99,
                true,
                0.5);

        Post post2 = new Post(idSecondPost, seller.getId(), LocalDate.now().minusDays(1),
                productSecondPost,
                2,
                20.99,
                true,
                0.3);

        User user = new User(userId, username, false, new ArrayList<>(), new ArrayList<>(List.of(seller.getId())), new ArrayList<>(), new HashSet<>());

        productRepository.addProduct(productFirstPost);
        productRepository.addProduct(productSecondPost);
        postRepository.saveNewPost(post1);
        postRepository.saveNewPost(post2);
        userRepository.getUsers().add(user);
    }

    private static Stream<Arguments> provideInvalidProducts() {
        return Stream.of(
                Arguments.of(
                        "POST /products/post Invalid Product Id",
                        "El id del producto debe ser mayor a cero",
                        new ProductDto(0, "ValidName", "Ropa", "Marca", "Color", "")
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Name Blank",
                        "El campo product_name no puede estar vacío",
                        new ProductDto(10, "", "Ropa", "Marca", "Color", "")
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Name too long",
                        "La longitud de product_name no puede superar los 40 caracteres",
                        new ProductDto(10, "a".repeat(41), "Ropa", "Marca", "Color", "")
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Name invalid characters",
                        "El campo product_name no puede poseer caracteres especiales",
                        new ProductDto(10, "Invalid@Name", "Ropa", "Marca", "Color", "")
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Type too long",
                        "La longitud de type no puede superar los 15 caracteres",
                        new ProductDto(10, "product1", "a".repeat(16), "Marca", "Color", "")
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Type invalid characters",
                        "El campo type no puede poseer caracteres especiales",
                        new ProductDto(10, "product1", "Ropa,", "Marca", "Color", "")
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Brand too long",
                        "La longitud de brand no puede superar los 25 caracteres",
                        new ProductDto(10, "product1", "Ropa", "a".repeat(26), "Color", "")
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Brand invalid characters",
                        "El campo brand no puede poseer caracteres especiales",
                        new ProductDto(10, "product1", "Ropa", "Marca,", "Color", "")
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Color too long",
                        "La longitud de color no puede superar los 15 caracteres",
                        new ProductDto(10, "product1", "Ropa", "Marca", "a".repeat(16), "")
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Color invalid characters",
                        "El campo color no puede poseer caracteres especiales",
                        new ProductDto(10, "product1", "Ropa", "Marca", "Color,", "")
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Notes too long",
                        "La longitud de notes no puede superar los 80 caracteres",
                        new ProductDto(10, "product1", "Ropa", "Marca", "Color", "a".repeat(81))
                ),
                Arguments.of(
                        "POST /products/post Invalid Product Notes invalid characters",
                        "El campo notes no puede poseer caracteres especiales",
                        new ProductDto(10, "product1", "Ropa", "Marca", "Color", "a,")
                )
        );
    }

    private static Stream<Arguments> provideInvalidPosts() {
        return Stream.of(
                Arguments.of(
                        "POST /products/post UserId less than zero or null",
                        "El id del usuario debe ser mayor a cero",
                        new RequestPostDto(0, LocalDate.now(), null, 2, 100.0)
                ),
                Arguments.of(
                        "POST /products/post Blank Date",
                        "La fecha no puede estar vacía",
                        new RequestPostDto(1, null, null, 2, 100.0)
                ),
                Arguments.of(
                        "POST /products/post Category less than zero or null",
                        "El category debe ser mayor a cero",
                        new RequestPostDto(1, LocalDate.now(), null, 0, 100.0)
                ),
                Arguments.of(
                        "POST /products/post Price less than 0.01 or null",
                        "El precio mínimo por producto es de 0.01",
                        new RequestPostDto(1, LocalDate.now(), null, 2, 0.0)
                ),
                Arguments.of(
                        "POST /products/post Price more than 10000000",
                        "El precio máximo por producto es de 10.000.000",
                        new RequestPostDto(1, LocalDate.now(), null, 2, 10000001)
                )
        );
    }

    private static Stream<Arguments> provideInvalidPromoPosts() {
        return Stream.of(
                Arguments.of(
                        "POST /products/promo-post UserId less than zero or null",
                        "El id del usuario debe ser mayor a cero",
                        new ProductPromoDto(0, LocalDate.now(), null, 2, 100.0, true, 0.10)
                ),
                Arguments.of(
                        "POST /products/promo-post Blank Date",
                        "La fecha no puede estar vacía",
                        new ProductPromoDto(1, null, null, 2, 100.0, true, 0.10)
                ),
                Arguments.of(
                        "POST /products/promo-post Category less than zero or null",
                        "El category debe ser mayor a cero",
                        new ProductPromoDto(1, LocalDate.now(), null, 0, 100.0, true, 0.10)
                ),
                Arguments.of(
                        "POST /products/promo-post Price less than 0.01 or null",
                        "El precio mínimo por producto es de 0.01",
                        new ProductPromoDto(1, LocalDate.now(), null, 2, 0.0, true, 0.10)
                ),
                Arguments.of(
                        "POST /products/promo-post Price more than 10000000",
                        "El precio máximo por producto es de 10.000.000",
                        new ProductPromoDto(1, LocalDate.now(), null, 2, 10000001, true, 0.10)
                ),
                Arguments.of(
                        "POST /products/promo-post HasPromo false",
                        "El valor del campo has_promo debe ser verdadero para admitir la promo",
                        new ProductPromoDto(1, LocalDate.now(), null, 2, 100.0, false, 0.10)
                ),
                Arguments.of(
                        "POST /products/promo-post Discount more than 100%",
                        "El descuento máximo no puede superar el 100%",
                        new ProductPromoDto(1, LocalDate.now(), null, 2, 100.0, true, 1.5)
                ),
                Arguments.of(
                        "POST /products/promo-post Discount is 0%",
                        "El descuento mínimo no puede ser cero",
                        new ProductPromoDto(1, LocalDate.now(), null, 2, 100.0, true, 0)
                )
        );
    }

    @Test
    @DisplayName("POST /products/post OK")
    public void testAddNewPost_Ok() throws Exception {
        ResponseDto responseDTO = new ResponseDto("Publicación creada");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(responseDTO));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(post1)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @ParameterizedTest(name = "{index} - {0}")
    @DisplayName("POST /products/post Invalid Posts Field Validation")
    @MethodSource("provideInvalidPosts")
    public void testAddNewPost_InvalidPostField(String _testDesc, String expectedMessage, RequestPostDto invalidPost) throws Exception {
        testDesc = _testDesc;
        ExceptionDto exceptionDto = new ExceptionDto(expectedMessage);
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDto));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        invalidPost.setProduct(product1);

        mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(invalidPost)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @ParameterizedTest(name = "{index} - {0}")
    @DisplayName("POST /products/post Invalid Product Field Validation")
    @MethodSource("provideInvalidProducts")
    public void testAddNewPost_InvalidProductField(String _testDesc, String expectedMessage, ProductDto invalidProduct) throws Exception {
        testDesc = _testDesc;
        ExceptionDto exceptionDto = new ExceptionDto(expectedMessage);
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDto));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        RequestPostDto invalidPost = new RequestPostDto(1, LocalDate.now(), invalidProduct, 2, 100.0);

        mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(invalidPost)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener posts de un usuario que no existe")
    public void testGetPostsByUser_UserNotExists() throws Exception {
        int userId = 300;
        String messageExpected = "No se encontró el usuario.";

        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(new ExceptionDto(messageExpected)));

        this.mockMvc
                .perform(get("/products/followed/{userId}/list", userId))
                .andExpectAll(
                        expectedStatus, expectedContentType, expectedBody
                ).andDo(print());
    }

    @Test
    @DisplayName("Obtener posts de un usuario que existe pero no sigue a nadie")
    public void testGetPostsByUser_UserWithZeroFollowed() throws Exception {
        int userId = 1;
        PostIndexDto expectedJsonContent = new PostIndexDto(userId, new ArrayList<>());

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(expectedJsonContent));

        this.mockMvc
                .perform(get("/products/followed/{userId}/list", userId))
                .andExpectAll(
                        expectedStatus, expectedContentType, expectedBody
                ).andDo(print());
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    @DisplayName("Obtener posts de un usuario con seguidos de manera ascendente")
    public void testGetPostsByUser_UserWithFollowedByAscOrder() throws Exception {
        int userId = 10;
        String userName = "John Doe";
        int lastId = postRepository.lastId();
        generateUserWith2FollowedWithPosts(userId, userName);

        ResponsePostDto post1 = new ResponsePostDto(
                lastId + 1,
                2000,
                LocalDate.now(),
                new ProductDto(80,
                        "Mouse",
                        "Tecnología",
                        "Logitech",
                        "Negro",
                        "Mouse hergonómico altamente recomendado!."),
                55,
                15.99,
                true,
                0.5);

        ResponsePostDto post2 = new ResponsePostDto(
                lastId + 2,
                2000,
                LocalDate.now().minusDays(1),
                new ProductDto(81,
                        "Gorro",
                        "Ropa",
                        "DC",
                        "Negro",
                        "Gorro negro skater"),
                2,
                20.99,
                true,
                0.3);

        PostIndexDto expectedJsonContent = new PostIndexDto(userId, new ArrayList<>(List.of(post1, post2)));

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(expectedJsonContent));

        this.mockMvc
                .perform(get("/products/followed/{userId}/list", userId)
                        .param("order", "date_asc"))
                .andExpectAll(
                        expectedStatus, expectedContentType, expectedBody
                ).andDo(print());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @DisplayName("Obtener posts de un usuario con seguidos de manera descendente")
    public void testGetPostsByUser_UserWithFollowedByDescOrder() throws Exception {
        int userId = 10;
        String userName = "John Doe";
        int lastId = postRepository.lastId();
        generateUserWith2FollowedWithPosts(userId, userName);

        ResponsePostDto post1 = new ResponsePostDto(
                lastId + 1,
                2000,
                LocalDate.now(),
                new ProductDto(80,
                        "Mouse",
                        "Tecnología",
                        "Logitech",
                        "Negro",
                        "Mouse hergonómico altamente recomendado!."),
                55,
                15.99,
                true,
                0.5);

        ResponsePostDto post2 = new ResponsePostDto(
                lastId + 2,
                2000,
                LocalDate.now().minusDays(1),
                new ProductDto(81,
                        "Gorro",
                        "Ropa",
                        "DC",
                        "Negro",
                        "Gorro negro skater"),
                2,
                20.99,
                true,
                0.3);

        PostIndexDto expectedJsonContent = new PostIndexDto(userId, new ArrayList<>(List.of(post2, post1)));

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(expectedJsonContent));

        this.mockMvc
                .perform(get("/products/followed/{userId}/list", userId)
                        .param("order", "date_desc"))
                .andExpectAll(
                        expectedStatus, expectedContentType, expectedBody
                )
                .andDo(print());
    }

    @DisplayName("POST /products/post Product already exists")
    public void testAddNewPost_Product_Conflict() throws Exception {
        int invalidProductId = 1;
        ExceptionDto exceptionDTO = new ExceptionDto("El producto con el id " + invalidProductId + " ya existe");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isConflict();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        ProductDto productPromo = new ProductDto(invalidProductId, "product1", "Ropa", "Marca", "Color", "");
        RequestPostDto invalidPost = new RequestPostDto(1, LocalDate.now(), productPromo, 2, 100.0);

        mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(invalidPost)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Query param 'order' inválido")
    public void  testGetPostsByUser_InvalidQueryParam() throws Exception {
        int userId = 9;
        String messageExpected = "Parámetros inválidos.";

        ResultMatcher expectedStatus = status().isBadRequest();
        ResultMatcher expectedContentType = content().contentType("application/json");
        ResultMatcher expectedBody = content().json(mapper.writeValueAsString(new ExceptionDto(messageExpected)));

        this.mockMvc
                .perform(get("/products/followed/{userId}/list", userId)
                        .param("order", "date_desccc"))
                .andExpectAll(
                        expectedStatus, expectedContentType, expectedBody
                )
                .andDo(print());
    }

    @Test
    @DisplayName("POST /products/post User Not Found")
    public void testAddNewPost_User_Not_Found() throws Exception {
        int invalidUserId = 120;
        ExceptionDto exceptionDTO = new ExceptionDto("El usuario con id: " + invalidUserId + " no existe");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        RequestPostDto postUserNotFound = new RequestPostDto(invalidUserId, LocalDate.now(), product1, 2, 100.0);

        mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(postUserNotFound)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("POST /products/promo-post OK")
    public void testPost_Ok() throws Exception {
        ResponseDto responseDTO = new ResponseDto("Publicación con promoción creada");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(responseDTO));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(post("/products/promo-post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(postPromo1)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @ParameterizedTest(name = "{index} - {0}")
    @DisplayName("POST /products/promo-post Invalid Posts Field Validation")
    @MethodSource("provideInvalidPromoPosts")
    public void testPost_InvalidPostField(String _testDesc, String expectedMessage, ProductPromoDto invalidPost) throws Exception {
        testDesc = _testDesc;
        ExceptionDto exceptionDto = new ExceptionDto(expectedMessage);
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDto));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        invalidPost.setProduct(product1);

        mockMvc.perform(post("/products/promo-post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(invalidPost)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @ParameterizedTest(name = "{index} - {0}")
    @DisplayName("POST /products/promo-post Invalid Product Field Validation")
    @MethodSource("provideInvalidProducts")
    public void testPost_InvalidProductField(String _testDesc, String expectedMessage, ProductDto invalidProduct) throws Exception {
        testDesc = _testDesc;
        ExceptionDto exceptionDto = new ExceptionDto(expectedMessage);
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDto));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        ProductPromoDto invalidPost = new ProductPromoDto(1, LocalDate.now(), invalidProduct, 2, 100.0, true, 0.10);

        mockMvc.perform(post("/products/promo-post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(invalidPost)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("POST /products/promo-post User Not Found")
    public void testPost_User_Not_Found() throws Exception {
        int invalidUserId = 120;
        ExceptionDto exceptionDTO = new ExceptionDto("El id del vendedor no existe");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        ProductPromoDto postPromoUserNotFound = new ProductPromoDto(invalidUserId, LocalDate.now(), product1, 2, 100.0, true, 0.10);

        mockMvc.perform(post("/products/promo-post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(postPromoUserNotFound)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("POST /products/promo-post Product already exists")
    public void testPost_Product_Conflict() throws Exception {
        int invalidProductId = 1;
        ExceptionDto exceptionDTO = new ExceptionDto("El id del producto ya existe en una publicación");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        ProductDto productPromo = new ProductDto(invalidProductId, "product1", "Ropa", "Marca", "Color", "");
        ProductPromoDto postPromoUserIsNotSeller = new ProductPromoDto(1, LocalDate.now(), productPromo, 2, 100.0, true, 0.10);

        mockMvc.perform(post("/products/promo-post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(postPromoUserIsNotSeller)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("POST /products/promo-post User Is Not Seller")
    public void testPost_User_Is_Not_Seller() throws Exception {
        int invalidUserId = 2;
        ExceptionDto exceptionDTO = new ExceptionDto("El id que ingresó es de un usuario comprador");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        ProductPromoDto postPromoUserIsNotSeller = new ProductPromoDto(invalidUserId, LocalDate.now(), product1, 2, 100.0, true, 0.10);

        mockMvc.perform(post("/products/promo-post")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(postPromoUserIsNotSeller)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("POST /products/promo-post Invalid Json")
    public void testPost_testCreateInvalidJson() throws Exception {
        ExceptionDto exceptionDTO = new ExceptionDto("Formato invalido en la request.");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(post("/products/promo-post")
                        .contentType("application/json")
                        .content("\"dsa\""))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("POST /products/promo-post Invalid Date Format")
    public void testPost_testCreateInvalidDateFormat() throws Exception {
        ExceptionDto exceptionDTO = new ExceptionDto("Ingrese un formato válido de fecha como dd-MM-YYYY");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(exceptionDTO));
        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(post("/products/promo-post")
                        .contentType("application/json")
                        .content("{\"userId\":1,\"date\":\"02-01\",\"product\":{\"type\":\"Ropa\",\"brand\":\"Marca\",\"color\":\"Color\",\"notes\":\"\",\"id\":17,\"name\":\"product1\"},\"category\":2,\"price\":100.0,\"hasPromo\":true,\"discount\":0.1}"))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }


    @Test
    @DisplayName("Obtener cantidad de productos en promo de un vendedor")
    public void testGetPromoPostCount() throws Exception {
        int userId = 1;
        PostPromoDto esperado = new PostPromoDto(
                userId,
                "Agustina Lopez",
                11);

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(esperado));

        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", String.valueOf(userId)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener NotFound de la cantidad de productos en promo de un vendedor que no existe")
    public void testGetPromoPostCount_WithInvalidUser() throws Exception {
        int userId = 99;

        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", String.valueOf(userId)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener BadRequest de la cantidad de productos en promo de un usuario que no es vendedor")
    public void testGetPromoPostCount_WithNonSellerUser() throws Exception {
        int userId = 2;

        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", String.valueOf(userId)))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Actualizar correctamente el descuento de una promo")
    public void testUpdatePromoDiscount() throws Exception{
        int postPromo = 1;
        double discount = 0.8;
        ResponseDto resultado = new ResponseDto("La promoción se actualizó correctamente");

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        String jsonEsperado = mapper.writeValueAsString(resultado);

        // Realizar la solicitud PATCH
        mockMvc.perform(patch("/products/update-promo/{id}/{discount}", postPromo, discount))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(content().json(jsonEsperado))
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener NotFound al querer actualizar un post que no existe")
    public void testUpdatePromoDiscount_WithInvalidId() throws Exception{
        int postPromo = 99;
        double discount = 0.8;
        ResponseDto resultado = new ResponseDto("La publicación que quiere modificar no existe");

        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        String jsonEsperado = mapper.writeValueAsString(resultado);

        mockMvc.perform(patch("/products/update-promo/{id}/{discount}", postPromo, discount))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(content().json(jsonEsperado))
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener BadRequest al querer actualizar con valor >1 un post")
    public void testUpdatePromoDiscount_WithDiscountGreaterThanOne() throws Exception{
        int postPromo = 1;
        double discount = 1.01;
        ResponseDto resultado = new ResponseDto("El descuento no puede superar el 100%");

        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        String jsonEsperado = mapper.writeValueAsString(resultado);

        mockMvc.perform(patch("/products/update-promo/{id}/{discount}", postPromo, discount))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(content().json(jsonEsperado))
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener BadRequest al querer actualizar con valor <1 un post")
    public void testUpdatePromoDiscount_WithDiscountLessThanOrEqualZero() throws Exception{
        int postPromo = 1;
        double discount = 0;
        ResponseDto resultado = new ResponseDto("El descuento no puede ser menor o igual a 0");

        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        String jsonEsperado = mapper.writeValueAsString(resultado);


        mockMvc.perform(patch("/products/update-promo/{id}/{discount}", postPromo, discount))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(content().json(jsonEsperado))
                .andDo(print());
    }

    @Test
    @DisplayName("No existen posts para mostrar")
    public void testGetAll_NoPostsExists() throws Exception {
        postRepository.emptyPosts();

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json("[]");

        mockMvc.perform(get("/products/all"))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Devolución de todos los posts existentes")
    public void testGetAll_ObtainAllPosts() throws Exception {
        int expectedSize = postRepository.getPosts().size();
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");


        MvcResult result = mockMvc.perform(get("/products/all"))
                .andExpectAll(statusEsperado, contentTypeEsperado)
                .andDo(print())
                .andReturn();

        List<ResponsePostDto> allPosts = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<ResponsePostDto>>() {});

        Assertions.assertEquals(expectedSize, allPosts.size());
    }

    @Test
    @DisplayName("Obtener mejores descuentos de categoria que no existe")
    public void testGetBestProductsOnPromo_UserNotExists() throws Exception {
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json("[]");

        mockMvc.perform(get("/products/best/promo-post")
                        .param("category", String.valueOf(3000)))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener mejores descuentos globales de todas las categorias, sin especificar categoria")
    public void testGetBestProductsOnPromo_GetBestTenGlobalDiscounts() throws Exception {
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");


        MvcResult result = mockMvc.perform(get("/products/best/promo-post"))
                .andExpectAll(statusEsperado, contentTypeEsperado)
                .andDo(print())
                .andReturn();

        List<ResponsePostDto> bestPromos = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<ResponsePostDto>>() {});

        Assertions.assertEquals(10, bestPromos.size());
    }

    @Test
    @DisplayName("Obtener mejores descuentos de categoria 55")
    public void testGetBestProductsOnPromo_GetBestDiscountsForSpecificCategory() throws Exception {
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");


        MvcResult result = mockMvc.perform(get("/products/best/promo-post"))
                .andExpectAll(statusEsperado, contentTypeEsperado).
                andExpect(jsonPath("$[0].category").value(55))
                .andDo(print())
                .andReturn();

        List<ResponsePostDto> bestPromos = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<ResponsePostDto>>() {});

        Assertions.assertEquals(10, bestPromos.size());
    }

    @Test
    @DisplayName("No existen descuentos generados de momento")
    public void testGetBestProductsOnPromo_NoDiscountExistsYet() throws Exception {
        postRepository.emptyPosts();

        ExceptionDto expectedJsonContent = new ExceptionDto("No hay productos en promo");
        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(mapper.writeValueAsString(expectedJsonContent));

        mockMvc.perform(get("/products/best/promo-post"))
                .andExpectAll(statusEsperado, contentTypeEsperado, bodyEsperado)
                .andDo(print());
    }
}
