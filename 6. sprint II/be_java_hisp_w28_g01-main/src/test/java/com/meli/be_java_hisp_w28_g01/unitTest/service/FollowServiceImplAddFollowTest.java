package com.meli.be_java_hisp_w28_g01.unitTest.service;

import com.meli.be_java_hisp_w28_g01.dto.response.FollowDto;
import com.meli.be_java_hisp_w28_g01.exception.FollowAlreadyExistsException;
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
@DisplayName("Test unitarios para Follow Service - Add Follow")
class FollowServiceImplAddFollowTest {

    @Mock
    private BuyerServiceImpl buyerService;

    @Mock
    private SellerServiceImpl sellerService;

    @Mock
    private FollowRepositoryImpl followRepository;


    @InjectMocks
    private FollowServiceImpl followService;

    @Test
    @DisplayName("Se crea exitosamente un follow al enviar seller y buyer válidos")
    void addFollow_ShouldCreateFollow_WhenBuyerAndSellerAreValid() {
        Buyer buyer = new Buyer();
        buyer.setId(1);
        when(buyerService.findById(1)).thenReturn(Optional.of(buyer));

        Seller seller = new Seller();
        seller.setId(2);
        when(sellerService.findById(2)).thenReturn(Optional.of(seller));

        when(followRepository.getAll()).thenReturn(new ArrayList<>());

        // Crear un nuevo Follow y simular que se agrega correctamente al repositorio
        Follow follow = new Follow(buyer, seller);
        when(followRepository.addFollow(any(Follow.class))).thenReturn(follow);

        FollowDto result = followService.addFollow(1, 2);

        assertNotNull(result);
        assertEquals(1, result.getBuyer().getId());
        assertEquals(2, result.getSeller().getId());
    }

    @Test
    @DisplayName("Retorna exception Not Found cuando se envía un seller inexistente")
    void addFollow_ShouldThrowNotFoundException_WhenSellerDontExist() {

       Buyer buyer = new Buyer();
       buyer.setId(1);
       when(buyerService.findById(1)).thenReturn(Optional.of(buyer));
       when(sellerService.findById(2)).thenReturn(Optional.empty());

       assertThrows(NotFoundException.class, () -> followService.addFollow(1, 2));
   }
   @Test
   @DisplayName("Retorna exception Not Found cuando se envía un buyer inexistente")
    void addFollow_ShouldThrowNotFoundException_WhenBuyerDontExist() {

       Seller seller = new Seller();
       seller.setId(2);
       when(buyerService.findById(1)).thenReturn(Optional.empty());
       when(sellerService.findById(2)).thenReturn(Optional.of(seller));

       assertThrows(NotFoundException.class, () -> followService.addFollow(1, 2));
   }


    @Test
    @DisplayName("Retorna exception FollowAlreadyExistsException cuando el buyer ya sigue al seller")
    void addFollow_ShouldThrowFollowAlreadyExistsException_WhenFollowExists() {
        Buyer buyer = new Buyer();
        buyer.setId(1);

        Seller seller = new Seller();
        seller.setId(2);

        when(buyerService.findById(1)).thenReturn(Optional.of(buyer));
        when(sellerService.findById(2)).thenReturn(Optional.of(seller));

        Follow existingFollow = new Follow(buyer, seller);
        List<Follow> existingFollows = new ArrayList<>();
        existingFollows.add(existingFollow);

        when(followRepository.getAll()).thenReturn(existingFollows);

        assertThrows(FollowAlreadyExistsException.class, () -> followService.addFollow(1, 2));
    }
}
