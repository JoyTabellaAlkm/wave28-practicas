package com.bootcamp.socialmeli.unit.service;

import com.bootcamp.socialmeli.dto.request.GoalDto;
import com.bootcamp.socialmeli.dto.response.*;
import com.bootcamp.socialmeli.entity.Goal;
import com.bootcamp.socialmeli.entity.GoalStatus;
import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.exception.BadRequestException;
import com.bootcamp.socialmeli.exception.NotFoundException;
import com.bootcamp.socialmeli.factory.GoalFactory;
import com.bootcamp.socialmeli.factory.UserFactory;
import com.bootcamp.socialmeli.repository.IGoalRepository;
import com.bootcamp.socialmeli.repository.IUserRepository;
import com.bootcamp.socialmeli.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private IUserRepository userRepository;

    @Mock
    private IGoalRepository goalRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void givenExistingUsers_whenAddingFollower_thenReturnsCorrectly() {
        User michaelJohnson = UserFactory.createMichaelJohnson();
        User johnDoe = UserFactory.createJohnDoe();
        User janeSmith = UserFactory.createJaneSmith();
        UserFollowedDto expectedUserFollowedDto = new UserFollowedDto(
                johnDoe.getId(),
                johnDoe.getName(),
                List.of(
                        new UserIdentificationDto(michaelJohnson.getId(), michaelJohnson.getName()),
                        new UserIdentificationDto(janeSmith.getId(), janeSmith.getName())
                )
        );

        when(userRepository.getUserById(johnDoe.getId()))
                .thenReturn(Optional.of(johnDoe));
        when(userRepository.getUserById(janeSmith.getId()))
                .thenReturn(Optional.of(janeSmith));
        when(userRepository.getUsersByIds(johnDoe.getFollowing()))
                .thenReturn(List.of(michaelJohnson, janeSmith));

        UserFollowedDto userFollowedDto = userService.addFollower(johnDoe.getId(), janeSmith.getId());

        verify(userRepository, times(1))
                .getUserById(johnDoe.getId());
        verify(userRepository, times(1))
                .getUserById(janeSmith.getId());
        verify(userRepository, times(1))
                .getUsersByIds(johnDoe.getFollowing());
        assertEquals(expectedUserFollowedDto, userFollowedDto);
    }

    @Test
    public void givenNoExistingUser_whenAddingFollower_thenReturnsNotFoundException() {
        User johnDoe = UserFactory.createJohnDoe();
        int nonExistingUserId = UserFactory.nonExistingUserId;

        when(userRepository.getUserById(johnDoe.getId()))
                .thenReturn(Optional.of(johnDoe));
        when(userRepository.getUserById(nonExistingUserId))
                .thenReturn(Optional.empty());


        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> userService.addFollower(johnDoe.getId(), nonExistingUserId)
        );
        assertEquals("No existe usuario con ese id", exception.getMessage());

        verify(userRepository, times(1))
                .getUserById(johnDoe.getId());
        verify(userRepository, times(1))
                .getUserById(nonExistingUserId);
    }

    @Test
    public void givenExistingUser_whenAddingSameFollower_thenReturnsBadRequestException() {
        User johnDoe = UserFactory.createJohnDoe();

        BadRequestException exception = assertThrows(
                BadRequestException.class,
                () -> userService.addFollower(johnDoe.getId(), johnDoe.getId())
        );
        assertEquals("No se puede seguir a si mismo", exception.getMessage());
    }

    @Test
    public void givenExistingUser_whenAddingAlreadyFollowingFollower_thenReturnsBadRequestException() {
        User michaelJohnson = UserFactory.createMichaelJohnson();
        User johnDoe = UserFactory.createJohnDoe();

        when(userRepository.getUserById(johnDoe.getId()))
                .thenReturn(Optional.of(johnDoe));
        when(userRepository.getUserById(michaelJohnson.getId()))
                .thenReturn(Optional.of(michaelJohnson));

        BadRequestException exception = assertThrows(
                BadRequestException.class,
                () -> userService.addFollower(johnDoe.getId(), michaelJohnson.getId())
        );
        assertEquals("Ya sigue al usuario", exception.getMessage());

        verify(userRepository, times(1))
                .getUserById(michaelJohnson.getId());
    }

    @Test
    public void givenExistingUsers_whenRemovingFollower_thenReturnsCorrectly() {
        User michaelJohnson = UserFactory.createMichaelJohnson();
        User johnDoe = UserFactory.createJohnDoe();
        UserFollowedDto expectedUserFollowedDto = new UserFollowedDto(
                johnDoe.getId(),
                johnDoe.getName(),
                List.of()
        );

        when(userRepository.getUserById(johnDoe.getId()))
                .thenReturn(Optional.of(johnDoe));
        when(userRepository.getUserById(michaelJohnson.getId()))
                .thenReturn(Optional.of(michaelJohnson));
        when(userRepository.getUsersByIds(johnDoe.getFollowing()))
                .thenReturn(List.of());

        UserFollowedDto userFollowedDto = userService.removeFollower(johnDoe.getId(), michaelJohnson.getId());

        assertEquals(expectedUserFollowedDto, userFollowedDto);
        verify(userRepository, times(1))
                .getUserById(johnDoe.getId());
        verify(userRepository, times(1))
                .getUserById(michaelJohnson.getId());
        verify(userRepository, times(1))
                .getUsersByIds(johnDoe.getFollowing());
    }

    @Test
    public void givenNoExistingUser_whenRemovingFollower_thenReturnsNotFoundException() {
        User johnDoe = UserFactory.createJohnDoe();
        int nonExistingUserId = UserFactory.nonExistingUserId;

        when(userRepository.getUserById(johnDoe.getId()))
                .thenReturn(Optional.of(johnDoe));
        when(userRepository.getUserById(nonExistingUserId))
                .thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> userService.removeFollower(johnDoe.getId(), nonExistingUserId)
        );
        assertEquals("No existe usuario con ese id", exception.getMessage());

        verify(userRepository, times(1))
                .getUserById(johnDoe.getId());
        verify(userRepository, times(1))
                .getUserById(nonExistingUserId);
    }

    @Test
    public void givenExistingUser_whenGettingFollowerCount_thenReturnsCorrectly() {
        User johnDoe = UserFactory.createJohnDoe();
        UserFollowersCountResponseDto expectedUserFollowersCountResponseDto = new UserFollowersCountResponseDto(
                johnDoe.getId(),
                johnDoe.getName(),
                2
        );

        when(userRepository.getUserById(johnDoe.getId()))
                .thenReturn(Optional.of(johnDoe));

        UserFollowersCountResponseDto userFollowersCountResponseDto = userService.getAllUsersFollowersCount(johnDoe.getId());

        assertEquals(expectedUserFollowersCountResponseDto, userFollowersCountResponseDto);
        verify(userRepository, times(1))
                .getUserById(johnDoe.getId());
    }

    @Test
    public void givenNoExistingUser_whenGettingFollowerCount_thenReturnsNotFoundException() {
        int nonExistingUserId = UserFactory.nonExistingUserId;

        when(userRepository.getUserById(nonExistingUserId))
                .thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> userService.getAllUsersFollowersCount(nonExistingUserId)
        );
        assertEquals("No existe usuario con ese id", exception.getMessage());

        verify(userRepository, times(1))
                .getUserById(nonExistingUserId);
    }

    @Test
    public void givenExistingUser_whenGettingListAscSortedByName_thenReturnsCorrectly() {
        User michaelJohnson = UserFactory.createMichaelJohnson();
        User johnDoe = UserFactory.createJohnDoe();
        User janeSmith = UserFactory.createJaneSmith();

        verifyFollowingListSorting(michaelJohnson, List.of(janeSmith, johnDoe), "name_asc");
    }

    @Test
    public void givenExistingUser_whenGettingListDescSortedByName_thenReturnsCorrectly() {
        User michaelJohnson = UserFactory.createMichaelJohnson();
        User johnDoe = UserFactory.createJohnDoe();
        User janeSmith = UserFactory.createJaneSmith();

        verifyFollowingListSorting(michaelJohnson, List.of(johnDoe, janeSmith), "name_desc");
    }

    @Test
    public void givenExistingUser_whenGettingListWithInvalidOrder_thenReturnsBadRequestException() {
        User michaelJohnson = UserFactory.createMichaelJohnson();

        BadRequestException exception = assertThrows(
                BadRequestException.class,
                () -> userService.getFollowingList(michaelJohnson.getId(), "invalid_order")
        );
        assertEquals("Es requerido un tipo de ordenamiento valido.", exception.getMessage());
    }

    @Test
    public void givenNoExistingUser_whenGettingListAscSortedByName_thenReturnsNotFoundException() {
        int nonExistingUserId = UserFactory.nonExistingUserId;

        when(userRepository.getUserById(nonExistingUserId))
                .thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> userService.getFollowingList(nonExistingUserId, "name_asc")
        );
        assertEquals("No existe usuario con ese id", exception.getMessage());

        verify(userRepository, times(1))
                .getUserById(nonExistingUserId);
    }

    @Test
    public void givenExistingUser_whenGettingFollowingSellers_thenReturnsCorrectly() {
        User johnDoe = UserFactory.createJohnDoe();
        User sellerOne = UserFactory.createMichaelJohnson();
        User sellerTwo = UserFactory.createJaneSmith();

        List<User> followingSellers = List.of(sellerOne, sellerTwo);
        UserFollowingSellerResponseDto expectedResponse = new UserFollowingSellerResponseDto(
                johnDoe.getId(),
                johnDoe.getName(),
                List.of(
                        new UserIdentificationDto(sellerOne.getId(), sellerOne.getName()),
                        new UserIdentificationDto(sellerTwo.getId(), sellerTwo.getName())
                )
        );

        when(userRepository.getUserById(johnDoe.getId())).thenReturn(Optional.of(johnDoe));
        when(userRepository.getUsersByIds(johnDoe.getFollowers())).thenReturn(followingSellers);

        UserFollowingSellerResponseDto actualResponse = userService.getAllUsersFollowingSeller(johnDoe.getId(), "name_desc");

        assertEquals(expectedResponse, actualResponse);
        verify(userRepository, times(1)).getUserById(johnDoe.getId());
        verify(userRepository, times(1)).getUsersByIds(johnDoe.getFollowers());
    }

    @Test
    public void givenNoExistingUser_whenGettingFollowingSellers_thenReturnsNotFoundException() {
        int nonExistingUserId = UserFactory.nonExistingUserId;

        when(userRepository.getUserById(nonExistingUserId)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> userService.getAllUsersFollowingSeller(nonExistingUserId, "name_asc")
        );
        assertEquals("No existe usuario con ese id", exception.getMessage());

        verify(userRepository, times(1)).getUserById(nonExistingUserId);
    }

    @Test
    public void givenExistingUser_whenGettingFollowingSellersWithInvalidOrder_thenReturnsBadRequestException() {
        User johnDoe = UserFactory.createJohnDoe();

        BadRequestException exception = assertThrows(
                BadRequestException.class,
                () -> userService.getAllUsersFollowingSeller(johnDoe.getId(), "invalid_order")
        );
        assertEquals("Es requerido un tipo de ordenamiento valido.", exception.getMessage());
    }

    @Test
    public void givenValidGoal_whenAddingGoal_thenReturnsCorrectly() {
        User johnDoe = UserFactory.createJohnDoe();
        GoalDto goalDtoToAdd = GoalFactory.create100FollowersForNextMonthGoalDto();
        Goal expectedGoal = new Goal(4, "Follow 100 people", 100, LocalDate.now().plusDays(30));
        GoalResponseDto expectedGoalResponse = new GoalResponseDto(
                johnDoe.getId(),
                expectedGoal.getId(),
                expectedGoal.getName(),
                expectedGoal.getTargetFollowers(),
                johnDoe.followersCount(),
                expectedGoal.getDeadline(),
                expectedGoal.currentStatusFor(johnDoe)
        );

        when(userRepository.getUserById(johnDoe.getId())).thenReturn(Optional.of(johnDoe));
        when(goalRepository.findAll()).thenReturn(List.of());
        doNothing().when(goalRepository).addGoal(any(Goal.class));

        GoalResponseDto actualResponse = userService.addGoal(johnDoe.getId(), goalDtoToAdd);

        assertEquals(expectedGoalResponse, actualResponse);

        verify(userRepository, times(1)).getUserById(johnDoe.getId());
        verify(goalRepository, times(1)).addGoal(any(Goal.class));
    }

    @Test
    public void givenExistingGoal_whenAddingGoal_thenReturnsBadRequestException() {
        User johnDoe = UserFactory.createJohnDoe();
        GoalDto goalDtoToAdd = GoalFactory.create100FollowersForNextMonthGoalDto();

        when(goalRepository.findAll()).thenReturn(List.of(johnDoe.getGoal()));

        BadRequestException exception = assertThrows(
                BadRequestException.class,
                () -> userService.addGoal(johnDoe.getId(), goalDtoToAdd)
        );
        assertEquals("Un goal con ese id ya existe", exception.getMessage());

        verify(goalRepository, times(1)).findAll();
    }

    @Test
    public void givenInvalidDeadline_whenAddingGoal_thenReturnsBadRequestException() {
        User johnDoe = UserFactory.createJohnDoe();
        GoalDto goalDto = GoalFactory.createInvalidDeadlineGoalDto();

        when(goalRepository.findAll()).thenReturn(List.of());

        BadRequestException exception = assertThrows(
                BadRequestException.class,
                () -> userService.addGoal(johnDoe.getId(), goalDto)
        );
        assertEquals("La fecha debe ser mayor a la actual", exception.getMessage());
    }

    @Test
    public void givenExistingUserWithGoal_whenGettingGoal_thenReturnsCorrectly() {
        User johnDoe = UserFactory.createJohnDoe();
        Goal expectedGoal = johnDoe.getGoal();
        GoalResponseDto expectedGoalResponse = new GoalResponseDto(
                johnDoe.getId(),
                expectedGoal.getId(),
                expectedGoal.getName(),
                expectedGoal.getTargetFollowers(),
                johnDoe.followersCount(),
                expectedGoal.getDeadline(),
                expectedGoal.currentStatusFor(johnDoe)
        );

        when(userRepository.getUserById(johnDoe.getId())).thenReturn(Optional.of(johnDoe));

        GoalResponseDto actualResponse = userService.getGoal(johnDoe.getId());

        assertEquals(expectedGoalResponse, actualResponse);
        verify(userRepository, times(1)).getUserById(johnDoe.getId());
    }

    @Test
    public void givenExistingUserWithoutGoal_whenGettingGoal_thenReturnsNotFoundException() {
        User johnDoe = UserFactory.createJohnDoe();
        johnDoe.setGoal(null);

        when(userRepository.getUserById(johnDoe.getId())).thenReturn(Optional.of(johnDoe));

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> userService.getGoal(johnDoe.getId())
        );
        assertEquals("No existe goal con ese id", exception.getMessage());

        verify(userRepository, times(1)).getUserById(johnDoe.getId());
    }

    @Test
    public void givenNonExistingUser_whenGettingGoal_thenReturnsNotFoundException() {
        int nonExistingUserId = UserFactory.nonExistingUserId;

        when(userRepository.getUserById(nonExistingUserId)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> userService.getGoal(nonExistingUserId)
        );
        assertEquals("No existe usuario con ese id", exception.getMessage());

        verify(userRepository, times(1)).getUserById(nonExistingUserId);
    }

    @Test
    public void givenDeadlinePassedAndTargetNotMet_whenGettingCurrentStatus_returnsExpired() {
        User johnDoe = UserFactory.createJohnDoe();
        johnDoe.setFollowers(List.of(2, 3, 4, 5, 6));
        int userId = johnDoe.getId();

        Goal goal = GoalFactory.createDeadlinePassedGoal();
        johnDoe.setGoal(goal);

        GoalResponseDto expectedGoalResponse = new GoalResponseDto(
                johnDoe.getId(),
                goal.getId(),
                goal.getName(),
                goal.getTargetFollowers(),
                johnDoe.followersCount(),
                goal.getDeadline(),
                GoalStatus.EXPIRED.getDescription()
        );

        when(userRepository.getUserById(userId)).thenReturn(Optional.of(johnDoe));

        GoalResponseDto goalResponse = userService.getGoal(userId);

        assertEquals(expectedGoalResponse, goalResponse);
    }

    @Test
    public void givenDeadlineNotPassedAndTargetMet_whenGettingCurrentStatus_returnsCompleted() {
        User johnDoe = UserFactory.createJohnDoe();
        johnDoe.setFollowers(List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        int userId = johnDoe.getId();

        Goal goal = GoalFactory.createDeadlineNotPassedGoal();
        johnDoe.setGoal(goal);

        GoalResponseDto expectedGoalResponse = new GoalResponseDto(
                johnDoe.getId(),
                goal.getId(),
                goal.getName(),
                goal.getTargetFollowers(),
                johnDoe.followersCount(),
                goal.getDeadline(),
                GoalStatus.COMPLETED.getDescription()
        );

        when(userRepository.getUserById(userId)).thenReturn(Optional.of(johnDoe));

        GoalResponseDto goalResponse = userService.getGoal(userId);

        assertEquals(expectedGoalResponse, goalResponse);
    }

    @Test
    public void givenDeadlineNotPassedAndTargetNotMet_whenGettingCurrentStatus_returnsInProgress() {
        User johnDoe = UserFactory.createJohnDoe();
        johnDoe.setFollowers(List.of(2, 3, 4, 5, 6));
        int userId = johnDoe.getId();

        Goal goal = GoalFactory.createDeadlineNotPassedGoal();
        johnDoe.setGoal(goal);

        GoalResponseDto expectedGoalResponse = new GoalResponseDto(
                johnDoe.getId(),
                goal.getId(),
                goal.getName(),
                goal.getTargetFollowers(),
                johnDoe.followersCount(),
                goal.getDeadline(),
                GoalStatus.IN_PROGRESS.getDescription()
        );

        when(userRepository.getUserById(userId)).thenReturn(Optional.of(johnDoe));

        GoalResponseDto goalResponse = userService.getGoal(userId);

        assertEquals(expectedGoalResponse, goalResponse);
    }

    @Test
    public void givenDeadlinePassedAndTargetMet_whenGettingCurrentStatus_returnsFinished() {
        User johnDoe = UserFactory.createJohnDoe();
        johnDoe.setFollowers(List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        int userId = johnDoe.getId();

        Goal goal = GoalFactory.createDeadlinePassedGoal();
        johnDoe.setGoal(goal);

        GoalResponseDto expectedGoalResponse = new GoalResponseDto(
                johnDoe.getId(),
                goal.getId(),
                goal.getName(),
                goal.getTargetFollowers(),
                johnDoe.followersCount(),
                goal.getDeadline(),
                GoalStatus.FINISHED.getDescription()
        );

        when(userRepository.getUserById(userId)).thenReturn(Optional.of(johnDoe));

        GoalResponseDto goalResponse = userService.getGoal(userId);

        assertEquals(expectedGoalResponse, goalResponse);
    }

    private void verifyFollowingListSorting(User expectedUser, List<User> expectedFollowedUsers, String sortOrder) {
        UserFollowedDto expectedUserFollowedDto = new UserFollowedDto(
                expectedUser.getId(),
                expectedUser.getName(),
                expectedFollowedUsers.stream()
                        .map(user -> new UserIdentificationDto(user.getId(), user.getName()))
                        .toList()
        );

        when(userRepository.getUserById(expectedUser.getId()))
                .thenReturn(Optional.of(expectedUser));
        when(userRepository.getUsersByIds(expectedUser.getFollowing()))
                .thenReturn(expectedFollowedUsers);

        UserFollowedDto userFollowedDto = userService.getFollowingList(expectedUser.getId(), sortOrder);

        assertEquals(expectedUserFollowedDto, userFollowedDto);
        verify(userRepository, times(1)).getUserById(expectedUser.getId());
        verify(userRepository, times(1)).getUsersByIds(expectedUser.getFollowing());
    }
}
