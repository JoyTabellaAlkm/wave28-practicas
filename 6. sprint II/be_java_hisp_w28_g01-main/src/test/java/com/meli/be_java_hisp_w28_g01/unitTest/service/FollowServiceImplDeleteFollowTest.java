package com.meli.be_java_hisp_w28_g01.unitTest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w28_g01.dto.response.FollowDto;
import com.meli.be_java_hisp_w28_g01.exception.FollowNotFoundException;
import com.meli.be_java_hisp_w28_g01.exception.NotFoundException;
import com.meli.be_java_hisp_w28_g01.model.Buyer;
import com.meli.be_java_hisp_w28_g01.model.Follow;
import com.meli.be_java_hisp_w28_g01.model.Seller;
import com.meli.be_java_hisp_w28_g01.repository.impl.FollowRepositoryImpl;
import com.meli.be_java_hisp_w28_g01.service.impl.BuyerServiceImpl;
import com.meli.be_java_hisp_w28_g01.service.impl.FollowServiceImpl;
import com.meli.be_java_hisp_w28_g01.service.impl.SellerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test unitarios para Follow Service - Delete Follow")
public class FollowServiceImplDeleteFollowTest {
    @Mock
    private BuyerServiceImpl buyerService;

    @Mock
    private SellerServiceImpl sellerService;

    @Mock
    private FollowRepositoryImpl followRepository;

    @InjectMocks
    private FollowServiceImpl followService;

    @Test
    @DisplayName("Se borra un follow exitosamente al enviar Id de buyer y de seller válidos")
    void deleteFollow_ShouldDeleteFollow_WhenBuyerIdAndSellerIdAreValid() {
        // Arrange
        Buyer buyer = new Buyer();
        buyer.setId(1);
        when(buyerService.findById(1)).thenReturn(Optional.of(buyer));

        Seller seller = new Seller();
        seller.setId(2);
        when(sellerService.findById(2)).thenReturn(Optional.of(seller));

        Follow existingFollow = new Follow(buyer, seller);
        List<Follow> existingFollows = new ArrayList<>();
        existingFollows.add(existingFollow);
        when(followRepository.getAll()).thenReturn(existingFollows);

        // Act
        FollowDto deletedFollow = followService.deleteFollow(1, 2);

        // Assert
        verify(followRepository, times(1)).deleteFollow(1, 2);
    }

    @Test
    @DisplayName("Retorna Not Found Exception al enviar un id de seller inexistente")
    void deleteFollow_ShouldThrowNotFoundException_WhenSellerDontExist() {
        // Arrange
        Buyer buyer = new Buyer();
        buyer.setId(1);
        when(buyerService.findById(1)).thenReturn(Optional.of(buyer));

        when(sellerService.findById(2)).thenReturn(Optional.empty());

        // Act - Assert
        assertThrows(NotFoundException.class, () -> followService.deleteFollow(1, 2));
    }

    @Test
    @DisplayName("Retorna Not Found Exception al enviar un id de buyer inexistente")
    void deleteFollow_ShouldThrowNotFoundException_WhenBuyerDontExist() {
        // Arrange
        when(buyerService.findById(1)).thenReturn(Optional.empty());

        Seller seller = new Seller();
        seller.setId(2);
        when(sellerService.findById(2)).thenReturn(Optional.of(seller));

        // Act - Assert
        assertThrows(NotFoundException.class, () -> followService.deleteFollow(1, 2));
    }

    @Test
    @DisplayName("Retorna FollowNotFoundException al enviar datos de un follow inexistente")
    void deleteFollow_ShouldThrowNotFoundException_WhenFollowDontExist() {
        // Arrange
        Buyer buyer = new Buyer();
        buyer.setId(1);
        when(buyerService.findById(1)).thenReturn(Optional.of(buyer));

        Seller seller = new Seller();
        seller.setId(2);
        when(sellerService.findById(2)).thenReturn(Optional.of(seller));

        when(followRepository.getAll()).thenReturn(new ArrayList<>());

        // Act - Assert
        assertThrows(FollowNotFoundException.class, () -> followService.deleteFollow(1, 2));
    }

}
