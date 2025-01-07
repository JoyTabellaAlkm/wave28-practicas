package com.bootcamp.social_meli.controller;

import com.bootcamp.social_meli.dto.PostDTO;
import com.bootcamp.social_meli.dto.PromoPostDTO;
import com.bootcamp.social_meli.dto.response.AmountOfPromosDTO;
import com.bootcamp.social_meli.dto.response.PostsFromFollowsDTO;
import com.bootcamp.social_meli.dto.response.PostsWithProductDTO;
import com.bootcamp.social_meli.dto.response.UserPostResponse;
import com.bootcamp.social_meli.service.IPostService;
import com.bootcamp.social_meli.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Gestión de Productos", description = "Operaciones relacionadas con los productos.")
public class ProductRestController {

    private final IPostService postService;
    private final IProductService productService;
    private final IProductService userService;

    @Autowired
    public ProductRestController(IPostService postService, IProductService productService, IProductService userService) {
        this.postService = postService;
        this.productService = productService;
        this.userService = userService;
    }

    @Operation(summary = "Obtener publicaciones de usuarios seguidos en las últimas dos semanas",
            description = "Devuelve todas las publicaciones de los usuarios que se siguen en un intervalo de dos semanas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de publicaciones de usuarios seguidos encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = PostsFromFollowsDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro userId inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Usuario no encontrado\"}"))
            })
    })
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsFromFollowsDTO> getAllPostsFollowsLastTwoWeeks(
            @Parameter(description = "ID del usuario actual") @PathVariable Long userId,
            @RequestParam(defaultValue = "date_asc") String order) {
        return new ResponseEntity<>(productService.getAllPostsFollowsLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    @Operation(summary = "Publicar un producto",
            description = "Permite a un usuario crear una nueva publicación de producto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto publicado exitosamente", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserPostResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Datos del producto inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Error al publicar el producto", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Producto no encontrado\"}"))
            })
    })
    @PostMapping("/post")
    public ResponseEntity<UserPostResponse> postProduct(@Valid @RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.createPost(postDTO));
    }

    @Operation(summary = "Crear publicación promocional",
            description = "Permite a un usuario crear una nueva publicación de producto con promoción.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publicación promocional creada exitosamente", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserPostResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Datos de la promoción inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Error al crear la publicación promocional", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Error en la creación de la promoción\"}"))
            })
    })
    @PostMapping("/promo-post")
    public ResponseEntity<UserPostResponse> createPromoPost(@Valid @RequestBody PromoPostDTO promoPostDTO) {
        return ResponseEntity.ok(postService.createPromoPost(promoPostDTO));
    }

    @Operation(summary = "Contar promociones por usuario",
            description = "Devuelve la cantidad total de publicaciones promocionales asociadas a un usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cantidad de promociones devuelta", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = AmountOfPromosDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos proporcionados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro user_id inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Usuario no encontrado\"}"))
            })
    })
    @GetMapping("/promo-post/count")
    public ResponseEntity<AmountOfPromosDTO> getAmountOfPromosByUser(
            @Parameter(description = "ID del usuario para contar promociones") @RequestParam Long user_id) {
        return ResponseEntity.ok(userService.getAmountOfPromosByUser(user_id));
    }

    @Operation(summary = "Buscar publicaciones por producto",
            description = "Devuelve las publicaciones que contienen el producto especificado por nombre.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de publicaciones con el producto encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = PostsWithProductDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos proporcionados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro name inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "No se encontró el producto asociado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Producto no encontrado\"}"))
            })
    })
    @GetMapping("/posts/search")
    public ResponseEntity<PostsWithProductDTO> getPostsWithProduct(
            @Parameter(description = "Nombre del producto a buscar") @RequestParam String name) {
        return ResponseEntity.ok(postService.getPostsWithProduct(name));
    }

    @Operation(summary = "Obtener publicaciones por rango de precio",
            description = "Devuelve una lista de publicaciones cuyos precios se encuentran dentro del rango especificado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de publicaciones con el producto encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = PostsWithProductDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos proporcionados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema =
                    @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Rango de precio inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "No se encontró el producto asociado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema =
                    @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Productos no encontrados\"}"))
            })
    })
    @GetMapping("/posts/prices")
    public ResponseEntity<List<PostDTO>> getPostsByPriceRange(
            @Parameter(description = "Minimo precio a buscar") @RequestParam String min,
            @Parameter(description = "Maximo precio a buscar") @RequestParam String max) {
        return ResponseEntity.ok(postService.getPostsByPriceRange(min, max));
    }
}
