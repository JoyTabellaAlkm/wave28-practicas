package com.bootcamp.social_meli.controller.swagger;

import com.bootcamp.social_meli.dto.response.SimpleMessageResponseDTO;
import com.bootcamp.social_meli.dto.request.UserDTO;
import com.bootcamp.social_meli.dto.request.CreateUserRequestDTO;
import com.bootcamp.social_meli.dto.response.FollowedListResponseDTO;
import com.bootcamp.social_meli.dto.response.FollowerCountResponse;
import com.bootcamp.social_meli.dto.response.FollowersListResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public interface IUserRestController {
    @Operation(summary = "Obtener todos los usuarios", description = "Permite obtener un listado de todos los usuarios en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuarios obtenidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserDTO.class))
            })
    })
    ResponseEntity<List<UserDTO>> findAll();

    @Operation(summary = "Seguir a un usuario", description = "Permite a un usuario seguir a otro.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario seguido exitosamente", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = SimpleMessageResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetros inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontró el usuario\"}"))
            })
    })
    ResponseEntity<SimpleMessageResponseDTO> followUser(
            @Parameter(description = "ID del usuario que sigue") @PathVariable @Min(value = 1,
            message = "userId debe ser mayor que o igual a 1") Long userId,
            @Parameter(description = "ID del usuario a seguir") @PathVariable Long userToFollowId);

    @Operation(summary = "Contar seguidores", description = "Devuelve la cantidad de seguidores de un usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cantidad de seguidores devuelta", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = FollowerCountResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetros inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontró el usuario\"}"))
            })
    })
    ResponseEntity<FollowerCountResponse> getFollowersCount(
            @Parameter(description = "ID del usuario para contar los seguidores") @PathVariable @Min(value = 1,
            message = "userId debe ser mayor que o igual a 1") Long userId);

    @Operation(summary = "Obtener lista de seguidores", description = "Devuelve la lista de seguidores de un usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de seguidores encontrada", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = FollowersListResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetros inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontró el usuario\"}"))
            })
    })
    ResponseEntity<FollowersListResponseDTO> findFollowerList(
            @Parameter(description = "ID del usuario para obtener la lista de seguidores") @PathVariable  @Min(value = 1,
            message = "userId debe ser mayor que o igual a 1") Long userId,
            @Parameter(description = "Orden de la lista (opcional)") @RequestParam(required = false) String order);

    @Operation(summary = "Obtener lista de usuarios seguidos", description = "Devuelve la lista de usuarios que sigue un usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios seguidos encontrada", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = FollowedListResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetros inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontró el usuario\"}"))
            })
    })
    ResponseEntity<FollowedListResponseDTO> findFollowedList(
            @Parameter(description = "ID del usuario para obtener la lista de usuarios seguidos") @PathVariable  @Min(value = 1,
            message = "userId debe ser mayor que o igual a 1") Long userId,
            @Parameter(description = "Orden de la lista (opcional)") @RequestParam(required = false) String order);

    @Operation(summary = "Dejar de seguir a un usuario", description = "Permite a un usuario dejar de seguir a otro.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario dejado de seguir exitosamente", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = SimpleMessageResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetros inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontró el usuario\"}"))
            })
    })
    ResponseEntity<SimpleMessageResponseDTO> unfollowUser(
            @Parameter(description = "ID del usuario que deja de seguir") @PathVariable @Min(value = 1,
            message = "userId debe ser mayor que o igual a 1") Long userId,
            @Parameter(description = "ID del usuario a dejar de seguir") @PathVariable Long userToUnfollowId);

    @Operation(summary = "Crear usuario", description = "Crea un nuevo usuario en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Datos inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Error al crear el usuario", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Error al crear el usuario\"}"))
            })
    })
    ResponseEntity<UserDTO> createUser(@RequestBody @Valid CreateUserRequestDTO user);
}
