package com.bootcamp.social_meli.controller;

import com.bootcamp.social_meli.dto.response.MostFollowersResponseDTO;
import com.bootcamp.social_meli.dto.response.MostProductsResponseDTO;
import com.bootcamp.social_meli.dto.response.MostPostsUsersResponseDTO;
import com.bootcamp.social_meli.dto.response.UserDetailsDTO;
import com.bootcamp.social_meli.service.IProductService;
import com.bootcamp.social_meli.service.IPostService;
import com.bootcamp.social_meli.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metrics")
@Tag(name = "Métricas", description = "Operaciones relacionadas con métricas de usuarios y productos.")
public class MetricRestController {

    private final IUserService userService;
    private final IPostService postService;
    private final IProductService productService;

    @Autowired
    public MetricRestController(IUserService userService, IPostService postService, IProductService productService) {
        this.userService = userService;
        this.postService = postService;
        this.productService = productService;
    }

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
    @GetMapping("/top/most_followers")
    public ResponseEntity<MostFollowersResponseDTO> getMostFollowersUsers(@RequestParam(required = false) Integer rank) {
        if (rank != null) {
            return ResponseEntity.ok(userService.mostFollowers(rank));
        } else {
            return ResponseEntity.ok(userService.mostFollowers());
        }
    }

    @Operation(summary = "Obtener detalles de un usuario", description = "Devuelve las métricas de un usuario específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalles del usuario encontrados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserDetailsDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetro userId inválido\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Usuario no encontrado\"}"))
            })
    })
    @GetMapping("/{userId}/details")
    public ResponseEntity<UserDetailsDTO> getUserDetails(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.metricsUserDetails(userId));
    }

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
    @GetMapping("/top/most_products")
    public ResponseEntity<MostProductsResponseDTO> getMostProductsPosted(@RequestParam(required = false) String rank) {
        if (rank != null) {
            return ResponseEntity.ok(productService.getMostProducts(rank));
        } else {
            return ResponseEntity.ok(productService.getMostProducts());
        }
    }

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
    @GetMapping("/top/most_posts")
    public ResponseEntity<MostPostsUsersResponseDTO> getMostsPostsUsers(@RequestParam(required = false) Integer rank) {
        if (rank != null) {
            return ResponseEntity.ok(postService.mostPostsUsers(rank));
        } else {
            return ResponseEntity.ok(postService.mostPostsUsers());
        }
    }
}