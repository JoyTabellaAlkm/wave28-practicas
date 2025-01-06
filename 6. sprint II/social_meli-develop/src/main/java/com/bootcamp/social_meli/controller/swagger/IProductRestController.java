package com.bootcamp.social_meli.controller.swagger;

import com.bootcamp.social_meli.dto.request.PostDTO;
import com.bootcamp.social_meli.dto.request.PromoPostDTO;
import com.bootcamp.social_meli.dto.response.AmountOfPromosResponseDTO;
import com.bootcamp.social_meli.dto.response.PostsFromFollowsResponseDTO;
import com.bootcamp.social_meli.dto.response.PostsWithProductResponseDTO;
import com.bootcamp.social_meli.dto.response.UserPostResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProductRestController {
    @Operation(summary = "Obtener publicaciones de usuarios seguidos en las últimas dos semanas",
            description = "Devuelve todas las publicaciones de los usuarios que se siguen en un intervalo de dos semanas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de publicaciones de usuarios seguidos encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = PostsFromFollowsResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro userId inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Usuario no encontrado\"}"))
            })
    })
    ResponseEntity<PostsFromFollowsResponseDTO> getAllPostsFollowsLastTwoWeeks(
            @Parameter(description = "ID del usuario actual") @PathVariable @Min(value = 1,
            message = "userId debe ser mayor que o igual a 1") Long userId,
            @RequestParam(defaultValue = "date_asc") String order);

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
    ResponseEntity<UserPostResponse> postProduct(@Valid @RequestBody PostDTO postDTO) ;

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
    ResponseEntity<UserPostResponse> createPromoPost(@Valid @RequestBody PromoPostDTO promoPostDTO);

    @Operation(summary = "Contar promociones por usuario",
            description = "Devuelve la cantidad total de publicaciones promocionales asociadas a un usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cantidad de promociones devuelta", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = AmountOfPromosResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos proporcionados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro user_id inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Usuario no encontrado\"}"))
            })
    })
    ResponseEntity<AmountOfPromosResponseDTO> getAmountOfPromosByUser(
            @Parameter(description = "ID del usuario para contar promociones") @RequestParam Long user_id);

    @Operation(summary = "Buscar publicaciones por producto",
            description = "Devuelve las publicaciones que contienen el producto especificado por nombre.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de publicaciones con el producto encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = PostsWithProductResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos proporcionados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro name inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "No se encontró el producto asociado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Producto no encontrado\"}"))
            })
    })
    ResponseEntity<PostsWithProductResponseDTO> getPostsWithProduct(
            @Parameter(description = "Nombre del producto a buscar") @RequestParam String name);

    @Operation(summary = "Obtener publicaciones por rango de precio",
            description = "Devuelve una lista de publicaciones cuyos precios se encuentran dentro del rango especificado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de publicaciones con el producto encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = PostsWithProductResponseDTO.class))
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
    ResponseEntity<List<PostDTO>> getPostsByPriceRange(
            @Parameter(description = "Minimo precio a buscar") @RequestParam String min,
            @Parameter(description = "Maximo precio a buscar") @RequestParam String max);
}

