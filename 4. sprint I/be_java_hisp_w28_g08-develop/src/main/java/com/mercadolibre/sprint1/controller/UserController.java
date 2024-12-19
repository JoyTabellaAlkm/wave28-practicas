package com.mercadolibre.sprint1.controller;

import com.mercadolibre.sprint1.service.IUserFollowerService;
import com.mercadolibre.sprint1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
	private IUserService userService;

	@Autowired
	private IUserFollowerService userFollowerService;

	/**
	 * US0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
	 * @param userId (int) Número que identifica al usuario actual
	 * @param userIdToFollow (int) Número que identifica al usuario a seguir
	 * @return Status Code 200 (todo OK) - bodyless or dto / Status Code 400 (Bad Request) - bodyless or dto
	 */
	@PostMapping("/{userId}/follow/{userIdToFollow}")
	public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
		userService.followUser(userId,userIdToFollow);
		return ResponseEntity.ok(null);
	}

	/**
	 * US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
	 * @param userId (int) Número que identifica a cada usuario
	 * @return FollowersCountDto
	 */
	@GetMapping("/{userId}/followers/count")
	public ResponseEntity<?> followersCountById(@PathVariable int userId){
		return ResponseEntity.ok(userFollowerService.followersCount(userId));
	}

	/**
	 * US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
	 * US 0008: Ordenamiento alfabético ascendente y descendente
	 * @param userId (int) Número que identifica a cada usuario
	 * @param order name_asc: Alfabético ascendente. / name_desc: Alfabético descendente.
	 * @return FollowersListByUserDto
	 */
	@GetMapping("/{userId}/followers/list")
	public ResponseEntity<?> findAllFollowersByUser(@PathVariable int userId, @RequestParam(required = false) String order) {
		return ResponseEntity.ok(userService.findAllFollowersByUser(userId, order));
	}

	/**
	 * US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
	 * US 0008: Ordenamiento alfabético ascendente y descendente
	 * @param userid (int) Número que identifica a cada usuario
	 * @param order name_asc: Alfabético ascendente. / name_desc: Alfabético descendente.
	 * @return FollowedListByUserDto
	 */
	@GetMapping("/{userid}/followed/list")
	public ResponseEntity<?> findUsersFollowedByUser(@PathVariable int userid, @RequestParam(required = false) String order) {
		return ResponseEntity.ok(userService.findUsersFollowedByUser(userid,order));
	}

	/**
	 * US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
	 * @param userId (int) Número que identifica al usuario actual
	 * @param sellerId (int) Número que identifica al usuario a dejar de seguir
	 * @return UnfollowResponseDto
	 */
	@PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
	public ResponseEntity<?> unfollow(@PathVariable("userId") int userId, @PathVariable("userIdToUnfollow") int sellerId){
		return new ResponseEntity<>(userFollowerService.unfollow(userId,sellerId), HttpStatus.OK);
	}

	/**
	 * US0013: Obtener un listado de vendedores, con el valor promedio de descuento que tienen en sus publicaciones.
	 * @return Status Code 200 (Consulta satisfactoria)
	 * Status Code 204 (No se encontraron vendedores)
	 * Status Code 400 (Ocurrió algún error)
	 */
	@GetMapping("/average-promos")
	public ResponseEntity<?> findUserPromoAverage(){

		return ResponseEntity.ok(userService.findUserPromoAverage());
	}

	/**
	 * US0014: Obtener el usuario con más seguidores y sus publicaciones (si tiene activas)
	 * @return Status code 200: Caso de éxito (Si hay publicaciones)
	 * Status code 204 No Content
	 */
	@GetMapping("/most-followed/posts")
	public ResponseEntity<?> userMostFollowed(){
		return ResponseEntity.ok(userService.findMostFollowedUser());
	}
}
