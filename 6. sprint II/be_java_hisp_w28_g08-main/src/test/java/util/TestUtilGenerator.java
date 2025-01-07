package util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mercadolibre.sprint1.dto.ProductDto;
import com.mercadolibre.sprint1.dto.request.CreatePromoPostDto;
import com.mercadolibre.sprint1.dto.response.FollowersCountDto;
import com.mercadolibre.sprint1.entity.Post;
import com.mercadolibre.sprint1.entity.Product;
import com.mercadolibre.sprint1.entity.User;
import com.mercadolibre.sprint1.entity.UserFollower;

public class TestUtilGenerator {

    public static List<User> generateUsers() {
        return new ArrayList<>(
                List.of(
                        new User(1, "Camilo", false),
                        new User(2, "Cristhian", true),
                        new User(3, "Daniel", false),
                        new User(4, "Andrés", true),
                        new User(5, "María", true),
                        new User(6, "Javier", false),
                        new User(7, "Alejandra", false)));
    }

    public static List<Post> generatePosts() {
        LocalDate today = LocalDate.now();
        LocalDate lastWeek = today.minusWeeks(1);
        LocalDate twoWeeksAgo = today.minusWeeks(2);

        return new ArrayList<>(
                List.of(
                        new Post(1, lastWeek.plusDays(1), 2,
                                new Product(1, "Smartphone", "Electronics", "Samsung", "Black", ""), 1, 529.0, false,
                                0),

                        new Post(2, twoWeeksAgo.plusDays(1), 2,
                                new Product(2, "Laptop", "Electronics", "Samsung", "Black", ""), 2, 899.0, true,
                                20.0),

                        new Post(3, today.minusWeeks(3), 2,
                                new Product(3, "TV", "Electronics", "Samsung", "Silver", ""), 3, 1199.0, true,
                                150.0),
                        new Post(4, today.minusMonths(1), 4,
                                new Product(4, "Shoes", "Clothes", "Adidas", "Black", ""), 5, 229.0, false,
                                0),
                        new Post(5, today.minusMonths(2), 4,
                                new Product(5, "T-Shirt", "Clothes", "Adidas", "Green", ""), 5, 59.0, true,
                                5.0),
                        new Post(6, today.minusMonths(3), 4,
                                new Product(6, "Jean", "Clothes", "Levi's", "Dark", ""), 5, 199.0, false,
                                0)));
    }

    public static List<UserFollower> generateFollowers() {
        return new ArrayList<>(
                List.of(
                        new UserFollower(2, 1),
                        new UserFollower(5, 1),
                        new UserFollower(4, 3),
                        new UserFollower(5, 3),
                        new UserFollower(4, 2)));
    }

    public static FollowersCountDto expectedResponseFollowerCount() {
        return new FollowersCountDto(
                1,
                "Camilo",
                0);
    }

    public static Post CreatePromoPost() {
        return new Post(0, LocalDate.parse("2024-12-20"), 4,
                new Product(5, "TShirt", "Clothes", "Adidas", "Green", ""), 5, 59.0, true,
                5.0);
    }

    public static CreatePromoPostDto createPostPromoDto() {
        return new CreatePromoPostDto(4, LocalDate.parse("2024-12-20"),
                new ProductDto(5, "TShirt", "Clothes", "Adidas", "Green", ""), 5, 59.0, true,
                5.0);
    }

    public static User generateSeller() {
        return generateUsers().get(1);
    }

    public static User generateUser() {
        return generateUsers().get(0);
    }

    public static User generateUserWithoutFolloweds() {
        return generateUsers().get(6);
    }

    public static User generateSellerWithoutPosts() {
        return generateUsers().get(4);
    }

    public static Optional<UserFollower> generateUserFollower() {
        return Optional.of(generateFollowers().get(0));
    }

    public static Post generateNoPromoPost() {
        return generatePosts().getFirst();
    }
}
