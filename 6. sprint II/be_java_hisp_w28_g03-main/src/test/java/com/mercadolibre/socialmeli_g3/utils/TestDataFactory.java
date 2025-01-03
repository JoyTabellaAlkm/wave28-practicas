package com.mercadolibre.socialmeli_g3.utils;

import com.mercadolibre.socialmeli_g3.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.socialmeli_g3.dto.response.*;
import com.mercadolibre.socialmeli_g3.dto.PromoProductPostDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FollowDTO;
import com.mercadolibre.socialmeli_g3.dto.ProductDTO;
import com.mercadolibre.socialmeli_g3.dto.ProductPostDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FollowersListDTO;
import com.mercadolibre.socialmeli_g3.dto.response.PostDTO;
import com.mercadolibre.socialmeli_g3.dto.response.UserDTO;
import com.mercadolibre.socialmeli_g3.dto.response.*;
import com.mercadolibre.socialmeli_g3.entity.Post;
import com.mercadolibre.socialmeli_g3.entity.Product;
import com.mercadolibre.socialmeli_g3.entity.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataFactory {
    private final static User user2 = new User(2, "usuario1", null, null, null);
    private final static User user3 = new User(3, "usuario2", null, null, null);
    private final static User user6 = new User(6, "usuario 6", null, null, null);
    private final static User user4 = new User(4, "vendedor2", null, null,null);
    private final static User user5 = new User(5, "vendedor3", null, null,null);
    private final static User user1 = new User(1, "vendedor1", new ArrayList<>(List.of(user6, user2, user3)), new ArrayList<>(List.of(user2, user4, user5)), null);
    private final static UserDTO user2DTO = new UserDTO(2, "usuario1");
    private final static UserDTO user3DTO = new UserDTO(3, "usuario2");
    private final static UserDTO user6DTO = new UserDTO(6, "usuario 6");
    private final static FollowDTO followDTO = new FollowDTO(1, 6);
    private final static Product product1001 = new Product(
            1002,
            "Silla Gamer",
            "Gamer",
            "Racer",
            "Red & Black",
            "Special Edition"
    );
    private final static Product product1003 = new Product(
            1003,
            "Silla Gamer",
            "Gamer",
            "Racer",
            "Red & Black",
            "Special Edition"
    );
    private final static Product product1004 = new Product(
            1004,
            "Silla Gamer",
            "Gamer",
            "Racer",
            "Red & Black",
            "Special Edition"
    );
    private final static FindProductsPromoResponseDTO promoPost = new FindProductsPromoResponseDTO(1, "vendedor1", 3);
    private final static  Post post = new Post (
            1001,
            1000,
            null,
            product1001,
            100,
            1500.50,
            true,
            0.40
    );

    private final static PostDTO postDTOCategory= new PostDTO(
          202,
            1,
            "21-11-2024",
            new ProductDTO(102,
                    "Teclado Mecánico",
                            "Teclado",
                            "Logitech",
                            "Black",
                            "RGB Backlit"),
            58,
            250.00,
            true,
            0.30


    );
    private final static Post post2 = new Post (
            1002,
            1000,
            null,
            product1003,
            100,
            1500.50,
            true,
            0.40
    );
    private final static Post post3 = new Post (
            1003,
            1000,
            null,
            product1004,
            100,
            1500.50,
            true,
            0.40
    );
    private final static  Post post4 = new Post (
            201,
            1,
            "03-01-2025",
            new Product(
                    101,
                    "Silla Gamer",
                    "Gamer",
                    "Racer",
                    "Red & Black",
                    "Special Edition"
            ),
            100,
            1500.50,
            true,
            0.40
    );
    private final static Post post5 = new Post (
            202,
            1,
            "21-11-2024",
            new Product(
                    102,
                    "Teclado Mecánico",
                    "Teclado",
                    "Logitech",
                    "Black",
                    "RGB Backlit"
            ),
            58,
            250.0,
            true,
            0.30
    );
    private final static Post post6 = new Post (
            203,
            1,
            "03-08-2023",
            new Product(
                    103,
                    "Mouse Gamer",
                    "Gamer",
                    "Razer",
                    "Green",
                    "Wireless"
            ),
            60,
            120.00,
            true,
            0.25
    );
    private final static Post post7 = new Post (
            204,
            2,
            "12-09-2024",
            new Product(
                    104,
                    "Monitor Gamer",
                    "Gamer",
                    "AOC",
                    "Black",
                    "Curved"
            ),
            60,
            240.0,
            true,
            0.75
    );
    private final static ProductResponseDTO productResponseDTO = new ProductResponseDTO(
            101,
            "Silla Gamer",
            "Gamer",
            "Racer",
            "Red & Black",
            "Special Edition"
    );
    private final static ProductResponseDTO product2ResponseDTO = new ProductResponseDTO(
            102,
            "Teclado Mecánico",
            "Teclado",
            "Logitech",
            "Black",
            "RGB Backlit"
    );
    private final static ProductResponseDTO product3ResponseDTO = new ProductResponseDTO(
            103,
            "Mouse Gamer",
            "Gamer",
            "Razer",
            "Green",
            "Wireless"
    );


    private final static PostResponseDto postResponseDTO = new PostResponseDto(
            201,
            1,
            "03-01-2025",
            productResponseDTO,
            100,
            1500.5

    );
    private final static PostResponseDto post2ResponseDTO = new PostResponseDto(
            202,
            1,
            "21-11-2024",
            product2ResponseDTO,
            58,
            250.0
    );

    private final static PostResponseDto post3ResponseDTO = new PostResponseDto(
            203,
            1,
            "03-08-2023",
            product3ResponseDTO,
            60,
            120.0
    );
    private final static PostDTO postDTO =new PostDTO(
            201,
            1,
            "03-01-2025",
            new ProductDTO(
                 101,
                 "Silla Gamer",
                 "Gamer",
                 "Racer",
                 "Red & Black",
                 "Special Edition"
            ),
            100,
            1500.50,
            true,
            0.40
    );

    private final static ProductByIdUserResponseDTO productByIdUserResponseDTO =  new ProductByIdUserResponseDTO( 1,new ArrayList<>(List.of(postResponseDTO)));
    private final static ProductByIdUserResponseDTO productByIdUserResponseDTOByOrderDesc =  new ProductByIdUserResponseDTO( 1,new ArrayList<>(List.of(post3ResponseDTO,postResponseDTO,post2ResponseDTO)));

    public static ProductByIdUserResponseDTO getProductByIdUserResponseDTO(){return productByIdUserResponseDTO;}
    public static ProductByIdUserResponseDTO getproductByIdUserResponseDTOByOrderDesc(){return productByIdUserResponseDTOByOrderDesc;}

    public static Post getPost() {return post;}

    private final static ProductPostDTO post200 = new ProductPostDTO(
            3, "29-04-2021",
            new ProductDTO(104, "Monitor Gamer", "Gamer", "AOC", "Black", "Curved"),
            100, 1500.50);

    private final static ProductPostDTO post400 = new ProductPostDTO(
            2, "29-04-2021",
            new ProductDTO(104, "Monitor Gamer", "Gamer", "AOC", "Black", "Curved"),
            100, 1500.50);

    private final static ProductPostDTO post404 = new ProductPostDTO(
            3, "29-04-2021",
            new ProductDTO(999,"Fake Product", "Fake Category", "Fake Brand", "Fake Color", "Fake Model"),
            100, 1500.50);

    private final static PromoProductPostDTO promoPost200 = new PromoProductPostDTO(
            3, "29-04-2021",
            new ProductDTO(101, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
            100, 1500.50, true, 0.25);

    private final static UserDTO user4DTO = new UserDTO(4, "vendedor2");
    private final static UserDTO user5DTO = new UserDTO(5, "vendedor3");
    private final static UserDTO user1DTO = new UserDTO(1, "vendedor1");
    private final static PromoProductPostDTO promoPost400 = new PromoProductPostDTO(
            2, "29-04-2021",
            new ProductDTO(101, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
            100, 1500.50, true, 33.33);

    private final static PromoProductPostDTO promoPost404 = new PromoProductPostDTO(
            3, "29-04-2021",
            new ProductDTO(999,"Fake Product", "Fake Category", "Fake Brand", "Fake Color", "Fake Model"),
            100, 1500.50, true, 33.33);

    private final static PostDTO makePromo200 = new PostDTO(
            204,2, "12-09-2024",
            new ProductDTO(104, "Monitor Gamer", "Gamer", "AOC", "Black", "Curved"),
            60,240.00, false, 0.00);

    private final static PostDTO makePromo400 = new PostDTO(
            201,1, "1-12-2024",
            new ProductDTO(101, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
            100, 1500.50, true, 0.40);


    public static ProductPostDTO getPost200() { return post200; }
    public static ProductPostDTO getPost400() { return post400; }
    public static ProductPostDTO getPost404() { return post404; }
    public static PromoProductPostDTO getPromoPost200() { return promoPost200; }
    public static PromoProductPostDTO getPromoPost400() { return promoPost400; }
    public static PromoProductPostDTO getPromoPost404() { return promoPost404; }
    public static PostDTO getMakePromo200() { return makePromo200; }
    public static PostDTO getMakePromo400() { return makePromo400; }

    public static Post getPost7() {return post7;}
    public static Post getPost6() {return post6;}
    public static Post getPost5() {return post5;}
    public static Post getPost4() {return post4;}
    public static Post getPost3() {return post3;}
    public static Post getPost2() {return post2;}


    public static List<PostDTO> getListPostDTO() {
        return new ArrayList<>(List.of(postDTO));
    }

    public static List<Post> getListPost() {return new ArrayList<>(List.of(post,post2,post3));}

    public static List<User> getVendedor1FollowersAsc() {
        return new ArrayList<>(List.of(user6, user2, user3));
    }

    public static List<User> getVendedor1FollowersDesc() {
        return new ArrayList<>(List.of(user3, user2, user6));
    }


    public static User getVendedor1() {
        return user1;
    }

    public static FindProductsPromoResponseDTO getProductsPromo() {
        return promoPost;
    }

    public static FollowersListDTO getVendedor1FollowersDTOAsc() {
        FollowersListDTO user1Followers = new FollowersListDTO();
        List<UserDTO> users = new ArrayList<>(List.of(user6DTO, user2DTO, user3DTO));
        user1Followers.setUserId(1);
        user1Followers.setUserName("vendedor1");
        user1Followers.setFollowers(users);

        return user1Followers;
    }

    public static FollowersListDTO getVendedor1FollowersListDTO() {
        FollowersListDTO user1Followers = new FollowersListDTO();
        List<UserDTO> users = new ArrayList<>(List.of(user2DTO, user3DTO, user6DTO));
        user1Followers.setUserId(1);
        user1Followers.setUserName("vendedor1");
        user1Followers.setFollowers(users);

        return user1Followers;
    }

    public static FollowersListDTO getVendedor1FollowersDTODesc() {
        FollowersListDTO user1Followers = new FollowersListDTO();
        List<UserDTO> users = new ArrayList<>(List.of(user3DTO, user2DTO, user6DTO));
        user1Followers.setUserId(1);
        user1Followers.setUserName("vendedor1");
        user1Followers.setFollowers(users);

        return user1Followers;
    }

    public static FollowDTO getVendedor1FollowDTOUser6() {
        return followDTO;
    }

    public static String getDate(Integer subtractDays) {
        //Obtiene la fecha
        LocalDate dateTimeNow = LocalDate.now();
        //Validamos los dias que se quieran restar
        if (subtractDays != null && subtractDays > 0) {
            dateTimeNow = dateTimeNow.minusDays(subtractDays);
        }
        //Retornamos con el formato adecuado
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dateTimeNow.format(formateador);
    }

    public static FollowersCountDTO getFollowersCountDTO() {
        FollowersCountDTO user1Followers = new FollowersCountDTO();
        user1Followers.setUserId(user1.getUserId());
        user1Followers.setUserName(user1.getUserName());
        user1Followers.setFollowersCount(user1.getFollowers().size());

        return user1Followers;
    }

    public static FollowedListDTO getVendedor1FollowedDTOAsc() {
        FollowedListDTO user1Followed = new FollowedListDTO();
        List<UserDTO> users = new ArrayList<>(List.of( user2DTO,user4DTO, user5DTO));
        user1Followed.setUserId(1);
        user1Followed.setUserName("vendedor1");
        user1Followed.setFollowed(users);


        return user1Followed;
    }

    public static FollowedListDTO getVendedor1FollowedDTODesc() {

        FollowedListDTO user1Followed = new FollowedListDTO();
        List<UserDTO> users = new ArrayList<>(List.of(user1DTO));
        user1Followed.setUserId(2);
        user1Followed.setUserName("usuario1");
        user1Followed.setFollowed(users);

        return user1Followed;
    }

    public static List<PostDTO> getListCategory(){
        List<PostDTO> postDTOS= new ArrayList<>(List.of(postDTOCategory));
        return  postDTOS;
    }

}
