package com.bootcamp.socialmeli.factory;

import com.bootcamp.socialmeli.entity.Goal;
import com.bootcamp.socialmeli.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserFactory {
    public static User createJohnDoe() {
        return new User(
                1,
                "John Doe",
                new ArrayList<>(List.of(3)),
                new ArrayList<>(List.of(3, 4)),
                new Goal(4, "Reach 10 followers", 10, LocalDate.now().plusMonths(2))
        );
    }

    public static User createJaneSmith() {
        return new User(
                2,
                "Jane Smith",
                new ArrayList<>(List.of(1, 4)),
                new ArrayList<>(List.of(3)),
                new Goal(2, "Achieve 5 followers", 5, LocalDate.now().plusMonths(1))
        );
    }

    public static User createMichaelJohnson() {
        return new User(
                3,
                "Michael Johnson",
                new ArrayList<>(List.of(1, 2)),
                new ArrayList<>(List.of(1)),
                new Goal(3, "Get 100 followers", 100, LocalDate.now().plusMonths(6))
        );
    }

    public static User createAmmyBlanton() {
        return new User(
                8,
                "Ammy Blanton",
                new ArrayList<>(List.of(6, 7)),
                new ArrayList<>(List.of(4)),
                new Goal(3, "Get 100 followers", 100, LocalDate.now().plusMonths(6))
        );
    }

    public static User createUserWithIdThatFollows(int userId, List<Integer> following) {
        return new User(
                userId,
                "Mike",
                following,
                new ArrayList<>(List.of()),
                new Goal(3, "Get 100 followers", 100, LocalDate.now().plusMonths(6))
        );
    }

    public static User createSellerWithIdFollowedBy(int userId, int followerId) {
        return new User(
                userId,
                "Mike",
                new ArrayList<>(List.of()),
                List.of(followerId),
                new Goal(3, "Get 100 followers", 100, LocalDate.now().plusMonths(6))
        );
    }

    public static User createUserAlice() {
        return new User(
                1,
                "Alice",
                new ArrayList<>(List.of(2, 3, 4, 5)),
                new ArrayList<>(List.of(6)),
                new Goal(1, "Reach 50 followers", 50, LocalDate.now().plusMonths(3))
        );
    }

    public static User createUserBob() {
        return new User(
                2,
                "Bob",
                new ArrayList<>(List.of(6)),
                new ArrayList<>(List.of(3)),
                new Goal()
        );
    }

    public static User createUserCharlie() {
        return new User(
                3,
                "Charlie",
                new ArrayList<>(List.of()),
                new ArrayList<>(List.of(1, 2)),
                new Goal(2, "Reach 10 followers", 20, LocalDate.now().plusMonths(1))
        );
    }

    public static User createUserFrank() {
        return new User(
                6,
                "Frank",
                new ArrayList<>(List.of(1)),
                new ArrayList<>(),
                new Goal(1,
                        "Grow to 15 Followers",
                        15,
                        LocalDate.of(2025, 5, 20))
        );
    }

    public static User createUserJack() {
        return new User(
                11,
                "Jack",
                new ArrayList<>(),
                new ArrayList<>(),
                new Goal()
        );
    }
    
    public static final int nonExistingUserId = 99;
}