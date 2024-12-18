package com.mercadolibre.socialmeli_g3.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.socialmeli_g3.entity.Post;

import com.mercadolibre.socialmeli_g3.repository.filters.FilterFactory;
import com.mercadolibre.socialmeli_g3.repository.filters.IProductFilter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements IPostRepository{
    private List<Post> postsList;
    private static Integer POSTS_COUNTER;
    private final FilterFactory filterFactory;

    public PostRepositoryImpl() throws IOException {
        filterFactory = new FilterFactory();
        postsList=new ArrayList<>();
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Post> posts ;

        file= ResourceUtils.getFile("classpath:postDB.json");
        posts= objectMapper.readValue(file,new TypeReference<List<Post>>(){});

        postsList = posts;
        POSTS_COUNTER = postsList.size() + 200;
    }

    @Override
    public List<Post> findAllPosts() {
        return postsList;
    }

    @Override
    public List<Post> findProductByIdUser(int userId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return postsList.stream()
                .filter(post -> post.getUserId() == userId)
                .filter(post -> {
                    LocalDate postDate = LocalDate.parse(post.getDate(), formatter);
                    LocalDate currentDate = LocalDate.now();
                    long daysBetween = ChronoUnit.DAYS.between(postDate, currentDate);
                    return daysBetween <= 14; // Filtrar posts más antiguos que 14 días
                })
                .sorted((post1, post2) -> LocalDate.parse(post2.getDate(), formatter).compareTo(LocalDate.parse(post1.getDate(), formatter)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> findProductByIdUserOrderedByDate(int userId, String order) {
        if(order.equalsIgnoreCase("date_asc")) {
            return findProductByIdUser(userId);
        }
        return postsList.stream().filter( post ->  post.getUserId() == userId).sorted(Comparator.comparing(Post::getDate)).toList();
    }

    @Override
    public int findProductsPromoCount(int userId) {
        List<Post> listProm = postsList.stream().filter(x -> x.getUserId() == userId).toList();
        int count = 0;
        for(Post prom: listProm){
            if(prom.isHasPromo()){
                count++;
            }
        }
        return count;
    }

    @Override
    public List<Post> findAllPostsOnPromoByUser(int userId) {
        return postsList.stream()
                .filter(p -> p.getUserId() == userId && p.isHasPromo())
                .toList();
    }

    @Override
    public List<Post> findPostsByProductAttributes(Map<String, String> filterParams) {
        IProductFilter productFilter;
        List<Post> posts = new ArrayList<>(postsList);

        for(Map.Entry<String, String> criteria: filterParams.entrySet()) {
            productFilter = filterFactory.getFilter(criteria.getKey());
            posts = productFilter.filter(criteria.getValue(), posts);
        }

        return posts;
    }

    @Override
    public List<Post> findProductByPrice(double minPrice, double maxPrice) {
        return postsList.stream()
                .filter(post -> post.getPrice() >= minPrice && post.getPrice() <= maxPrice)
                .sorted((post1, post2) -> Double.compare(post1.getPrice(), post2.getPrice()))//ordena de precio mayor a menor
                .toList();
    }

    @Override
    public List<Post> findPostbyCategory(int category) {
        return postsList.stream().filter( p-> p.getCategory()== category).toList();
    }

    @Override
    public Post findPostById(Integer postId) {
        return postsList.stream().filter(x -> x.getPostId() == postId).findFirst().orElse(null);
    }


    @Override
    public void createPost(Post post) {
        POSTS_COUNTER++;
        post.setPostId(POSTS_COUNTER);
        postsList.add(post);
    }

    @Override
    public void updatePost(Post post) {
        Post postToUpdate = postsList.stream().filter(x -> x.getPostId() == post.getPostId()).findFirst().orElse(null);
        if (postToUpdate != null) {
            // updateo solo estos campos, pero aca deberian ser todos los campos.
            postToUpdate.setHasPromo(post.isHasPromo());
            postToUpdate.setDiscount(post.getDiscount());
        }
    }

}