package com.mercadolibre.socialmeli_g3.repository;

import com.mercadolibre.socialmeli_g3.entity.Post;

import java.util.List;
import java.util.Map;

public interface IPostRepository {

   List<Post> findAllPosts();
   List<Post> findProductByIdUser(int userId);
   List<Post> findProductByIdUserOrderedByDate(int userId, String order);
   int findProductsPromoCount(int userId);
   void createPost(Post post);
   List<Post> findAllPostsOnPromoByUser(int userId);
   List<Post> findPostsByProductAttributes(Map<String, String> filterCriteria);
   Post findPostById(Integer postId);
   void updatePost(Post post);
   List<Post> findPostbyCategory(int category);
   List<Post> findProductByPrice(double minPrice,double maxPrice);
}
