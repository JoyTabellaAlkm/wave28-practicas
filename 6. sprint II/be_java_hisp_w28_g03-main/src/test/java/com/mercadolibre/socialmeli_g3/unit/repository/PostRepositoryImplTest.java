package com.mercadolibre.socialmeli_g3.unit.repository;


import com.mercadolibre.socialmeli_g3.entity.Post;
import com.mercadolibre.socialmeli_g3.entity.Product;
import com.mercadolibre.socialmeli_g3.exception.BadRequestException;
import com.mercadolibre.socialmeli_g3.repository.PostRepositoryImpl;
import com.mercadolibre.socialmeli_g3.utils.TestDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mercadolibre.socialmeli_g3.utils.TestDataFactory.getPost;
import static com.mercadolibre.socialmeli_g3.utils.TestDataFactory.getPost2;
import static com.mercadolibre.socialmeli_g3.utils.TestDataFactory.getPost3;
@SpringBootTest
public class PostRepositoryImplTest {

    @Autowired
    private PostRepositoryImpl repository;

    @Test
    @DisplayName("T-0008 - findProductByIdUser should return list empty when product  is before than from last 2 weeks")
    public void findProductByIdUser_should_return_list_empty_when_product_is_before_than_from_last_2_weeks(){
        //arrange
        List<Post> listExpect = new ArrayList<>();
        Post post = getPost();
        post.setUserId(1005);
        int param = post.getUserId();
        post.setDate(TestDataFactory.getDate(15));
        //act
        if(repository.findProductByIdUser(param).size() == 0){
            repository.createPost(post);
        }
        List<Post> listResult = repository.findProductByIdUser(param);
        //assert
        Assertions.assertEquals(listResult,listExpect);
    }

    @Test
    @DisplayName("T-0008 - findProductByIdUser with 3 is function that should return in this case 3 products list of product when product is from last 2 weeks")
    public void findProductByIdUser_with_3_products_should_return_list_product_when_product_from_last_2_weeks(){
        //arrange
        Post post = getPost();
        Post post2 = getPost2();
        Post post3 = getPost3();
        int param = post.getUserId();
        post.setDate(TestDataFactory.getDate(1));
        post2.setDate(TestDataFactory.getDate(2));
        post3.setDate(TestDataFactory.getDate(3));
        if(repository.findProductByIdUser(param).size() == 0){
            repository.createPost(post);
            repository.createPost(post2);
            repository.createPost(post3);
        }
        List<Post> listExpected = new ArrayList<>(Arrays.asList(post,post2,post3));

        //act
        List<Post> listResult = repository.findProductByIdUser(param);
        //assert
        Assertions.assertNotNull(listResult);
        Assertions.assertEquals(listResult,listExpected);
    }

    @Test
    @DisplayName("T-0008 - findProductByIdUser Order Last datefirst with 3 is function that should return in this case 3 products list of product when product is from last 2 weeks")
    public void findProductByIdUser_order_Last_date_first_with_3_products_should_return_list_product_when_product_from_last_2_weeks(){
        //arrange
        Post post = getPost();
        Post post2 = getPost2();
        Post post3 = getPost3();
        int param = post.getUserId();
        post.setDate(TestDataFactory.getDate(6));
        post2.setDate(TestDataFactory.getDate(3));
        post3.setDate(TestDataFactory.getDate(1));
        if(repository.findProductByIdUser(param).size() == 0){
            repository.createPost(post);
            repository.createPost(post2);
            repository.createPost(post3);
        }
        List<Post> listOrderedExpected = new ArrayList<>(Arrays.asList(post3,post2,post));

        //act
        List<Post> listResult = repository.findProductByIdUser(param);
        //assert
        Assertions.assertNotNull(listResult);
        Assertions.assertEquals(listResult,listOrderedExpected);
    }

    @Test
    @DisplayName("T-0005 Search products with invalid parameters throws BadRequestException (US-0009)")
    void test_findProductByIdUserOrderedByDate_invalidOrder_throwsException() {
        int idMock = 1;
        String invalidOrderMock = "invalid_order";

        Exception exception = Assertions.assertThrows(BadRequestException.class, () -> {
            repository.findProductByIdUserOrderedByDate(idMock, invalidOrderMock);
        });

        String expectedMessage = "Sort type is not valid";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("T-0005 - T-006 - Search products by user ID ordered by date ascending returns posts (US-0009)")
    void test_findProductByIdUserOrderedByDateASC_return_posts() {
        int idMock = 1;
        String orderMock = "date_asc";
        List<Post> postsWaited = Arrays.asList(
                new Post(210, 1, "29-12-2024", new Product(110, "Standing Desk", "Gamer", "Racer", "Red & Black", "Special Edition"), 100, 1500.5, false, 0.0),
                new Post(201, 1, "03-01-2025", new Product(101, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"), 100, 1500.5, true, 0.4)

        );

        List<Post> postsResponse = repository.findProductByIdUserOrderedByDate(idMock,orderMock);

        Assertions.assertNotNull(postsResponse);
        Assertions.assertEquals(postsWaited,postsResponse);
    }

    @Test
    @DisplayName("T-0005 - T-006 - Search products by user ID ordered by date descending returns posts (US-0009)")
    void test_findProductByIdUserOrderedByDateDESC_return_posts() {
        int idMock = 1;
        String orderMock = "date_desc";
        List<Post> postsWaited = Arrays.asList(
                new Post(201, 1, "03-01-2025", new Product(101, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"), 100, 1500.5, true, 0.4),
                new Post(210, 1, "29-12-2024", new Product(110, "Standing Desk", "Gamer", "Racer", "Red & Black", "Special Edition"), 100, 1500.5, false, 0.0)
        );

        List<Post> postsResponse = repository.findProductByIdUserOrderedByDate(idMock,orderMock);

        Assertions.assertNotNull(postsResponse);
        Assertions.assertEquals(postsWaited,postsResponse);
    }


}
