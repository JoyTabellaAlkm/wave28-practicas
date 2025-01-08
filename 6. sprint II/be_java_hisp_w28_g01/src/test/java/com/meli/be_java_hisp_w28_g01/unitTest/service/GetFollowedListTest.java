package com.meli.be_java_hisp_w28_g01.unitTest.service;

import com.meli.be_java_hisp_w28_g01.dto.response.FollowedSellersDto;
import com.meli.be_java_hisp_w28_g01.exception.IlegalArgumentException;
import com.meli.be_java_hisp_w28_g01.model.Buyer;
import com.meli.be_java_hisp_w28_g01.model.Follow;
import com.meli.be_java_hisp_w28_g01.model.Seller;
import com.meli.be_java_hisp_w28_g01.repository.IFollowRepository;
import com.meli.be_java_hisp_w28_g01.service.IBuyerService;
import com.meli.be_java_hisp_w28_g01.service.impl.FollowServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests unitarios para obtener lista de seguidores de un seller")
public class GetFollowedListTest {

    @Mock
    private IFollowRepository followRepository;

    @Mock
    private IBuyerService buyerService;

    @InjectMocks
    private FollowServiceImpl followService;

    private Buyer buyer;
    private List<Follow> follows;

    @BeforeEach
    void setUp() {
        buyer = new Buyer();
        buyer.setId(1);
        buyer.setName("Aladdin");

        Seller seller1 = new Seller();
        seller1.setId(1);
        seller1.setName("Abu");

        Seller seller2 = new Seller();
        seller2.setId(2);
        seller2.setName("Jasmine");

        Seller seller3 = new Seller();
        seller3.setId(3);
        seller3.setName("Mateo");

        Follow follow1 = new Follow(buyer, seller1);
        Follow follow2 = new Follow(buyer, seller2);
        Follow follow3 = new Follow(buyer, seller3);

        follows = Arrays.asList(follow1, follow2, follow3);
        lenient().when(buyerService.findById(1)).thenReturn(Optional.of(buyer));
        lenient().when(followRepository.getAll()).thenReturn(follows);
    }

    @ParameterizedTest
    @ValueSource(strings = {"name_asc","name_desc"})
    @DisplayName("Acepta 'name_asc' y 'name_desc' como parámetros válidos de ordenamiento")
    void whenOrderByNameAscOrDesc_ValidatesOrderTypeSuccessfully(String order) {
        assertDoesNotThrow(() -> followService.getFollowedOrderedSeller(1, order));
    }


    @Test
    @DisplayName("Obtengo excepcion al ingresar un tipo de ordenamiento inexistente")
    void whenOrderByInvalidType_ThrowsIllegalArgumentException() {
        IlegalArgumentException exception = assertThrows(IlegalArgumentException.class,
                () -> followService.getFollowedOrderedSeller(1, "invalid_order"));
        assertEquals("Ese tipo de ordenamiento no existe.", exception.getMessage());
    }

    @Test
    @DisplayName("Obtengo la lista por nombre ordenada ascendentemente")
    void whenSortedByNameAsc_ReturnsCorrectlyOrderedList() {

        FollowedSellersDto result = followService.getFollowedOrderedSeller(1, "name_asc");

        assertNotNull(result);
        assertEquals(3, result.getFollowed().size());
        assertEquals("Abu", result.getFollowed().get(0).getName());
        assertEquals("Jasmine", result.getFollowed().get(1).getName());
        assertEquals("Mateo", result.getFollowed().get(2).getName());

        verify(buyerService).findById(1);
        verify(followRepository).getAll();
    }

    @Test
    @DisplayName("Obtengo la lista por nombre ordenada descendentemente")
    void whenSortedByNameDesc_ReturnsCorrectlyOrderedList() {

        FollowedSellersDto result = followService.getFollowedOrderedSeller(1, "name_desc");

        assertNotNull(result);
        assertEquals(3, result.getFollowed().size());
        assertEquals("Mateo", result.getFollowed().get(0).getName());
        assertEquals("Jasmine", result.getFollowed().get(1).getName());
        assertEquals("Abu", result.getFollowed().get(2).getName());

        verify(buyerService).findById(1);
        verify(followRepository).getAll();
    }

}

