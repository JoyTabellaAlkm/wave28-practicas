package com.bootcamp.social_meli.controller;

import com.bootcamp.social_meli.dto.UserDTO;
import com.bootcamp.social_meli.dto.response.FollowedListDTO;
import com.bootcamp.social_meli.dto.response.FollowersListDTO;
import com.bootcamp.social_meli.dto.response.FollowerCountResponse;
import com.bootcamp.social_meli.dto.SimpleMessageDTO;
import com.bootcamp.social_meli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Gestión de Usuarios", description = "Operaciones relacionadas con los usuarios.")
public class UserRestController {

    private final IUserService userService;

    @Autowired
    public UserRestController(IUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Obtener todos los usuarios", description = "Permite obtener un listado de todos los usuarios en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuarios obtenidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserDTO.class))
            })
    })
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @Operation(summary = "Seguir a un usuario", description = "Permite a un usuario seguir a otro.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario seguido exitosamente", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = SimpleMessageDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetros inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontró el usuario\"}"))
            })
    })
    @PostMapping("{userId}/follow/{userToFollowId}")
    public ResponseEntity<SimpleMessageDTO> followUser(
            @Parameter(description = "ID del usuario que sigue") @PathVariable Long userId,
            @Parameter(description = "ID del usuario a seguir") @PathVariable Long userToFollowId) {
        return ResponseEntity.ok(new SimpleMessageDTO(userService.followUser(userId, userToFollowId)));
    }

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
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountResponse> getFollowersCount(
            @Parameter(description = "ID del usuario para contar los seguidores") @PathVariable Long userId) {
        return ResponseEntity.ok(userService.getFollowerCount(userId));
    }

    @Operation(summary = "Obtener lista de seguidores", description = "Devuelve la lista de seguidores de un usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de seguidores encontrada", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = FollowersListDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetros inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontró el usuario\"}"))
            })
    })
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> findFollowerList(
            @Parameter(description = "ID del usuario para obtener la lista de seguidores") @PathVariable String userId,
            @Parameter(description = "Orden de la lista (opcional)") @RequestParam(required = false) String order) {
        return order != null && !order.isEmpty() ?
                ResponseEntity.ok(userService.findFollowersList(userId, order)) :
                ResponseEntity.ok(userService.findFollowersList(userId));
    }

    @Operation(summary = "Obtener lista de usuarios seguidos", description = "Devuelve la lista de usuarios que sigue un usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios seguidos encontrada", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = FollowedListDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetros inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontró el usuario\"}"))
            })
    })
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> findFollowedList(
            @Parameter(description = "ID del usuario para obtener la lista de usuarios seguidos") @PathVariable String userId,
            @Parameter(description = "Orden de la lista (opcional)") @RequestParam(required = false) String order) {
        return order != null && !order.isEmpty() ?
                ResponseEntity.ok(userService.findFollowedList(userId, order)) :
                ResponseEntity.ok(userService.findFollowedList(userId));
    }

    @Operation(summary = "Dejar de seguir a un usuario", description = "Permite a un usuario dejar de seguir a otro.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario dejado de seguir exitosamente", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = SimpleMessageDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"Parámetros inválidos\"}"))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = {
                    @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(example = "{\"error\":\"No se encontró el usuario\"}"))
            })
    })
    @PostMapping("{userId}/unfollow/{userToUnfollowId}")
    public ResponseEntity<SimpleMessageDTO> unfollowUser(
            @Parameter(description = "ID del usuario que deja de seguir") @PathVariable Long userId,
            @Parameter(description = "ID del usuario a dejar de seguir") @PathVariable Long userToUnfollowId) {
        return ResponseEntity.ok(new SimpleMessageDTO(userService.unfollowUser(userId, userToUnfollowId)));
    }

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
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}