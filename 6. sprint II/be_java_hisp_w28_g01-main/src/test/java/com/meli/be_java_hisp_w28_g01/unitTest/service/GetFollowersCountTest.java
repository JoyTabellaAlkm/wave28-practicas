package com.meli.be_java_hisp_w28_g01.unitTest.service;

import com.meli.be_java_hisp_w28_g01.dto.response.FollowersDto;
import com.meli.be_java_hisp_w28_g01.exception.NotFoundException;
import com.meli.be_java_hisp_w28_g01.model.Buyer;
import com.meli.be_java_hisp_w28_g01.model.Follow;
import com.meli.be_java_hisp_w28_g01.model.Seller;
import com.meli.be_java_hisp_w28_g01.repository.impl.FollowRepositoryImpl;
import com.meli.be_java_hisp_w28_g01.service.impl.BuyerServiceImpl;
import com.meli.be_java_hisp_w28_g01.service.impl.FollowServiceImpl;
import com.meli.be_java_hisp_w28_g01.service.impl.SellerServiceImpl;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test unitarios para Follow Service - Get Followers Count ")
class GetFollowersCountTest {

    @Mock
    SellerServiceImpl sellerService;
    @Mock
    BuyerServiceImpl buyerService;
    @Mock
    FollowRepositoryImpl followRepository;
    @InjectMocks
    FollowServiceImpl followService;

    private List<Follow> follows;

    @BeforeEach
    void setUp(){
        Buyer buyer = new Buyer();
        buyer.setId(1);
        buyer.setName("Pedro");
        Buyer buyer2 = new Buyer();
        buyer.setId(2);
        buyer.setName("Martin");
        Buyer buyer3 = new Buyer();
        buyer.setId(3);
        buyer.setName("Sofia");
        Seller seller = new Seller();
        seller.setId(1);
        seller.setName("Lucia");
        follows = List.of(
                new Follow(
                        buyer,
                        seller
                ),
                new Follow(
                        buyer2,
                        seller
                ),
                new Follow(
                        buyer3,
                        seller
                )
        );
    }

    @Test
    @DisplayName("Obtengo la cantidad de seguidores al enviar un id de seller válido")
    void getFollowersCount_ShouldReturnFollowersCount_WhenSellerIdExists() {
        //ARRANGE
        Seller seller = new Seller();
        seller.setId(1);
        FollowersDto expectedFollowersDto = new FollowersDto();
        FollowersDto actualFollowersDto;
        int expected = 3;
        expectedFollowersDto.setFollowersCount(expected);
        //ACT
        when(sellerService.findById(seller.getId())).thenReturn(Optional.of(seller));
        when(followService.getAll()).thenReturn(follows);
        actualFollowersDto = followService.getFollowersCount(seller.getId());
        //ASSERT
        assertEquals(expectedFollowersDto.getFollowersCount(), actualFollowersDto.getFollowersCount(), "La cantidad de followers debería ser igual");
    }

    @Test
    @DisplayName("Retorno NotFoundException al enviar el id de un seller inexistente")
    void getFollowersCount_ShouldReturnNotFoundException_WhenSellerDoesntExists(){
        //ARRANGE
        int idToFind = 1;
        //ACT
        when(sellerService.findById(idToFind)).thenReturn(Optional.empty());
        //ASSERT
        assertThrows(NotFoundException.class, () -> followService.getFollowersCount(idToFind));
        verify(sellerService, atLeastOnce()).findById(idToFind);
    }

}