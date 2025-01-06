package com.bootcamp.social_meli.controller.swagger;

import com.bootcamp.social_meli.dto.response.MostFollowersResponseDTO;
import com.bootcamp.social_meli.dto.response.MostPostsUsersResponseDTO;
import com.bootcamp.social_meli.dto.response.MostProductsResponseDTO;
import com.bootcamp.social_meli.dto.response.UserDetailsResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
public interface IMetricRestController {

    @Operation(summary = "Obtener los usuarios con más seguidores", description = "Devuelve una lista de los usuarios más seguidos en la plataforma.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de usuarios con más seguidores", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = MostFollowersResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro rank inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "No se encontró ningún usuario", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontraron usuarios\"}"))
            })
    })
    ResponseEntity<MostFollowersResponseDTO> getMostFollowersUsers(@RequestParam(required = false) Integer rank);

    @Operation(summary = "Obtener detalles de un usuario", description = "Devuelve las métricas de un usuario específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalles del usuario encontrados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserDetailsResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro userId inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Usuario no encontrado\"}"))
            })
    })
    ResponseEntity<UserDetailsResponseDTO> getUserDetails(@PathVariable @Min(value = 1,
            message = "userId debe ser mayor que o igual a 1") Long userId);

    @Operation(summary = "Obtener los productos más publicados", description = "Devuelve una lista de los productos más publicados por los usuarios.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de productos más publicados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = MostProductsResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro rank inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "No se encontraron productos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontraron productos\"}"))
            })
    })
    ResponseEntity<MostProductsResponseDTO> getMostProductsPosted(@RequestParam(required = false) String rank);

    @Operation(summary = "Obtener los usuarios con más publicaciones", description = "Devuelve una lista de los usuarios que han realizado más publicaciones.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de usuarios con más publicaciones", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = MostPostsUsersResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro rank inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "No se encontraron usuarios", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontraron usuarios\"}"))
            })
    })
    ResponseEntity<MostPostsUsersResponseDTO> getMostsPostsUsers(@RequestParam(required = false) Integer rank);
}