package com.meli.be_java_hisp_w28_g01.unitTest.service;
import com.meli.be_java_hisp_w28_g01.dto.response.FollowersListDto;
import com.meli.be_java_hisp_w28_g01.exception.IlegalArgumentException;
import com.meli.be_java_hisp_w28_g01.model.Buyer;
import com.meli.be_java_hisp_w28_g01.model.Follow;
import com.meli.be_java_hisp_w28_g01.model.Seller;
import com.meli.be_java_hisp_w28_g01.repository.IFollowRepository;
import com.meli.be_java_hisp_w28_g01.service.ISellerService;
import com.meli.be_java_hisp_w28_g01.service.impl.FollowersListService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests para obtener lista de seguidos de un buyer")
public class GetFollowerListTest {

    @Mock
    private IFollowRepository followRepository;

    @Mock
    private ISellerService sellerService;

    @InjectMocks
    private FollowersListService followersListService;

    private Seller seller;
    private List<Follow> follows;

    @BeforeEach
    void setUp() {
        seller = new Seller();
        seller.setId(1);
        seller.setName("Mateo");

        Buyer buyer1 = new Buyer();
        buyer1.setId(1);
        buyer1.setName("Aladdin");

        Buyer buyer2 = new Buyer();
        buyer2.setId(2);
        buyer2.setName("Bob Patiño");

        Buyer buyer3 = new Buyer();
        buyer3.setId(3);
        buyer3.setName("Carl Johnson");


        Follow follow1 = new Follow(buyer1, seller);
        Follow follow2 = new Follow(buyer2, seller);
        Follow follow3 = new Follow(buyer3, seller);

        follows = Arrays.asList(follow1, follow2, follow3);
        lenient().when(sellerService.getAll()).thenReturn(List.of(seller));
        lenient().when(followRepository.getAll()).thenReturn(follows);
    }


    @ParameterizedTest
    @ValueSource(strings = {"name_asc","name_desc"})
    @DisplayName("Acepta 'name_asc' y 'name_desc' como parámetros válidos de ordenamiento")
    void whenOrderByNameAscOrDesc_ValidatesOrderTypeSuccessfully(String order) {
        assertDoesNotThrow(() -> followersListService.orderUserByName(1, order));
    }

    @Test
    @DisplayName("Obtengo excepcion al ingresar un tipo de ordenamiento inexistente")
    void whenOrderByInvalidType_ThrowsIllegalArgumentException() {
        IlegalArgumentException exception = assertThrows(
                IlegalArgumentException.class,
                () -> followersListService.orderUserByName(1, "invalid_order")
        );
        assertEquals("Ese tipo de ordenamiento no existe.", exception.getMessage());

    }

    @Test
    @DisplayName("Obtengo la lista por nombre ordenada ascendentemente")
    void whenSortedByNameAsc_ReturnsCorrectlyOrderedList() {

        FollowersListDto result = followersListService.orderUserByName(1, "name_asc");

        assertNotNull(result);
        assertEquals(3, result.getFollowers().size());
        assertEquals("Aladdin", result.getFollowers().get(0).getName());
        assertEquals("Bob Patiño", result.getFollowers().get(1).getName());
        assertEquals("Carl Johnson", result.getFollowers().get(2).getName());

        verify(sellerService).getAll();
        verify(followRepository).getAll();
    }

    @Test
    @DisplayName("Obtengo la lista por nombre ordenada descendentemente")
    void whenSortedByNameDesc_ReturnsCorrectlyOrderedList() {

        FollowersListDto result = followersListService.orderUserByName(1, "name_desc");

        assertNotNull(result);
        assertEquals(3, result.getFollowers().size());
        assertEquals("Carl Johnson", result.getFollowers().get(0).getName());
        assertEquals("Bob Patiño", result.getFollowers().get(1).getName());
        assertEquals("Aladdin", result.getFollowers().get(2).getName());

        verify(sellerService).getAll();
        verify(followRepository).getAll();
    }


}
