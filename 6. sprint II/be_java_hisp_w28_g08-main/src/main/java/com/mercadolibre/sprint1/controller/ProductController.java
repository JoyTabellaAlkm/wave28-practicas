package com.mercadolibre.sprint1.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mercadolibre.sprint1.dto.request.CreatePromoPostDto;
import com.mercadolibre.sprint1.dto.request.NewPostDto;
import com.mercadolibre.sprint1.dto.response.ProductsFollowedDtoResponse;
import com.mercadolibre.sprint1.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService service;

    /**
     * US 0005: Dar de alta una nueva publicación
     * @param newPostDto NewPostDto
     * @return Status Code 200 (todo OK) / Status Code 400 (Bad Request)
     */
    @PostMapping("/post")
    public ResponseEntity<?> newPost(@Valid @RequestBody NewPostDto newPostDto) {
        return ResponseEntity.ok(service.newPost(newPostDto));
    }

    /**
     * US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario
     * sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha,
     * publicaciones más recientes primero).
     * US 0009: Ordenamiento por fecha ascendente y descendente
     * @param userId (int) Número que identifica a cada usuario
     * @param order date_asc: Fecha ascendente (de más antigua a más nueva) /
     *              date_desc: Fecha descendente (de más nueva a más antigua)
     * @return ProductsFollowedDtoResponse
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ProductsFollowedDtoResponse> productsOfPeopleFollowed(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(service.productsOfPeopleFollowed(userId, order), HttpStatus.OK);
    }

    /**
     * US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
     * @param promoPost CreatePromoPostDto
     * @return Status Code 200 (OK) / Status Code 400 (Bad request)
     */
    @PostMapping("/promo-post")
    public ResponseEntity<?> createNewPostPromo(@Valid @RequestBody CreatePromoPostDto promoPost) {
        return ResponseEntity.status(HttpStatus.OK).body(service.createPromoPost(promoPost));
    }

    /**
     * US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
     * @param userId (int) Número que identifica a cada usuario
     * @return CountProductsPromoDto
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> findPromoProductsBySeller(@RequestParam("user_id") int userId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findPromoProductsBySeller(userId));
    }

    /**
     * US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
     * @param userId (int) Número que identifica a cada usuario
     * @return PostPromoListDto
     */
    @GetMapping("/promo-post/list")
    public ResponseEntity<?> allProductsPromo(@RequestParam("user_id") int userId){
        return ResponseEntity.status(HttpStatus.OK).body(service.listProductsPromo(userId));
    }
}
