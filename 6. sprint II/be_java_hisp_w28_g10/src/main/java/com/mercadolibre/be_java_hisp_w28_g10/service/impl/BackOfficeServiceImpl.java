package com.mercadolibre.be_java_hisp_w28_g10.service.impl;

import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponseCsvPostDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.user.UserWithCountDTO;
import com.mercadolibre.be_java_hisp_w28_g10.enums.ReportTypeEnum;
import com.mercadolibre.be_java_hisp_w28_g10.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w28_g10.model.FollowRelation;
import com.mercadolibre.be_java_hisp_w28_g10.model.Post;
import com.mercadolibre.be_java_hisp_w28_g10.model.User;
import com.mercadolibre.be_java_hisp_w28_g10.repository.IProductRepository;
import com.mercadolibre.be_java_hisp_w28_g10.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w28_g10.service.IBackOfficeService;
import com.mercadolibre.be_java_hisp_w28_g10.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link IBackOfficeService} for handling reporting operations.
 * This service provides functionality to retrieve and generate reports based on various criteria,
 * including user statistics and post details, formatted for CSV output.
 */
@Service
public class BackOfficeServiceImpl implements IBackOfficeService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private Utilities utilities;

    /**
     * {@inheritDoc}
     *
     * This method processes the request for a report based on the provided parameters.
     * It validates the inputs, retrieves the relevant data, and formats it into CSV format.
     *
     * @throws BadRequestException if the report name is invalid, or the order or top limit are out of bounds.
     */
    @Override
    public String getReport(String reportName, String order, int top) {

        List genericList = new ArrayList<>();
        String[] headers = new String[]{};

        try {
            ReportTypeEnum reportType = ReportTypeEnum.valueOf(reportName);
            if (!validateOrderByReportType(reportType, order) || top < 1) {
                throw new BadRequestException("Invalid report order or top");
            }

            switch (reportType) {
                case USERS_BY_FOLLOWERS:
                    genericList = getUsersReports(ReportTypeEnum.USERS_BY_FOLLOWERS, order, top);
                    headers = new String[]{"ID", "Name", "Followers Count"};
                    break;
                case USERS_BY_FOLLOWS:
                    genericList = getUsersReports(ReportTypeEnum.USERS_BY_FOLLOWS, order, top);
                    headers = new String[]{"ID", "Name", "Follows Count"};
                    break;
                case USERS_BY_POSTS:
                    genericList = getUsersByPostsReport(order, top);
                    headers = new String[]{"ID", "Name", "Posts Count"};
                    break;
                case POSTS_BY_PRICE:
                    genericList = getPostsByPrice(order, top);
                    break;
                case POSTS_BY_DISCOUNT:
                    genericList = getPostsByDiscount(order, top);
                    break;
                case POSTS_BY_DATE:
                    genericList = getPostsByDate(order, top);
                    break;
            }
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid report name");
        }

        return utilities.generateCsv(genericList, headers);
    }

    /**
     * Validates the order parameter based on the report type.
     *
     * @param reportType the type of the report to validate against.
     * @param order the order criteria provided.
     * @return true if the order is valid for the specified report type; false otherwise.
     */
    private boolean validateOrderByReportType(ReportTypeEnum reportType, String order) {
        if (reportType == ReportTypeEnum.USERS_BY_FOLLOWERS || reportType == ReportTypeEnum.USERS_BY_FOLLOWS
                || reportType == ReportTypeEnum.USERS_BY_POSTS) {
            if (order.equalsIgnoreCase("count_asc") || order.equalsIgnoreCase("count_desc")) {
                return true;
            }
        }
        if (reportType == ReportTypeEnum.POSTS_BY_PRICE && (
                order.equalsIgnoreCase("price_asc") || order.equalsIgnoreCase("price_desc")
        )) {
            return true;
        }
        if (reportType == ReportTypeEnum.POSTS_BY_DISCOUNT && (
                order.equalsIgnoreCase("discount_asc") || order.equalsIgnoreCase("discount_desc")
        )) {
            return true;
        }
        if (reportType == ReportTypeEnum.POSTS_BY_DATE && (
                order.equalsIgnoreCase("date_asc") || order.equalsIgnoreCase("date_desc")
        )) {
            return true;
        }

        return false;
    }

    /**
     * Retrieves the count of posts per user and sorts the results.
     *
     * @param order the order in which to sort the users.
     * @param top the maximum number of results to return.
     * @return a List of {@link UserWithCountDTO} containing user IDs, names, and post counts.
     */
    private List<UserWithCountDTO> getUsersByPostsReport(String order, int top){

        //I get the list of Posts and the list of Users
        List<User> users = userRepository.findAllUsers();
        List<Post> posts = productRepository.findAllPost();

        //Build a map using the UserIds and the amount of posts that it owns
        Map<Integer, Long> postCountByOwner = posts.stream().collect(Collectors.groupingBy(Post::getId, Collectors.counting()));

        //Build a list of elements considering that there are certain elements that dont own any posts
        List<UserWithCountDTO> userIdsWithPostCount = users.stream()
                .map(user -> new UserWithCountDTO(user.getId(), user.getName(), postCountByOwner.getOrDefault(user.getId(), 0L).intValue()))
                .toList();
        //Sort
        if(order.equalsIgnoreCase("count_asc")){
            userIdsWithPostCount = userIdsWithPostCount
                    .stream()
                    .sorted(Comparator.comparing(UserWithCountDTO::getCount))
                    .limit(top)
                    .toList();
        }else{
            userIdsWithPostCount = userIdsWithPostCount
                    .stream()
                    .sorted(Comparator.comparing(UserWithCountDTO::getCount).reversed())
                    .limit(top)
                    .toList();
        }
        return userIdsWithPostCount;
    }

    /**
     * Retrieves user reports based on followers or follows, sorted according to the specified criteria.
     *
     * @param reportType the type of report to generate.
     * @param order the order in which to sort the users.
     * @param top the maximum number of results to return.
     * @return a List of {@link UserWithCountDTO} containing user statistics.
     */
    private List<UserWithCountDTO> getUsersReports(ReportTypeEnum reportType, String order, int top) {
        List<User> users = userRepository.findAllUsers();

        // Getting usersByFollowers data
        List<UserWithCountDTO> userWithCountDTOList = users.stream().map(
                        user -> {
                            List<FollowRelation> userRelations;
                            if (reportType == ReportTypeEnum.USERS_BY_FOLLOWERS) {
                                userRelations = userRepository.getFollowRelationsByFollowedId(user.getId());
                            } else {
                                userRelations = userRepository.getFollowRelationsByFollowerId(user.getId());
                            }
                            return new UserWithCountDTO(user.getId(), user.getName(), userRelations.size());
                        })
                .toList();

        // Sorting
        if (order.equalsIgnoreCase("count_asc")) {
            userWithCountDTOList = userWithCountDTOList.stream()
                    .sorted(Comparator.comparing(UserWithCountDTO::getCount))
                    .limit(top).toList();
        } else {
            userWithCountDTOList = userWithCountDTOList.stream()
                    .sorted(Comparator.comparing(UserWithCountDTO::getCount).reversed())
                    .toList().stream().limit(top).toList();
        }

        return userWithCountDTOList;
    }

    /**
     * Retrieves posts sorted by price according to the specified order.
     *
     * @param order the order in which to sort the posts.
     * @param top the maximum number of results to return.
     * @return a List of {@link ResponseCsvPostDTO} representing the sorted posts.
     */
    private List<ResponseCsvPostDTO> getPostsByPrice(String order, int top) {
        List<Post> posts = productRepository.findAllPost();

        Comparator<Post> comparator = order.equalsIgnoreCase("price_asc") ?
                Comparator.comparing(Post::getPrice) :
                Comparator.comparing(Post::getPrice).reversed();

        List<Post> sortedPosts = posts.stream()
                .sorted(comparator)
                .limit(top)
                .toList();

        return mapPostsToResponseCsvPostDTO(sortedPosts);
    }

    /**
     * Retrieves posts sorted by date according to the specified order.
     *
     * @param order the order in which to sort the posts.
     * @param top the maximum number of results to return.
     * @return a List of {@link ResponseCsvPostDTO} representing the sorted posts.
     */
    private List<ResponseCsvPostDTO> getPostsByDate(String order, int top) {
        List<Post> posts = productRepository.findAllPost();

        Comparator<Post> comparator = order.equalsIgnoreCase("date_asc") ?
                Comparator.comparing(Post::getDate) :
                Comparator.comparing(Post::getDate).reversed();

        List<Post> sortedPosts = posts.stream()
                .sorted(comparator)
                .limit(top)
                .toList();

        return mapPostsToResponseCsvPostDTO(sortedPosts);
    }
    /**
     * Retrieves posts sorted by discount according to the specified order.
     *
     * @param order the order in which to sort the posts.
     * @param top the maximum number of results to return.
     * @return a List of {@link ResponseCsvPostDTO} representing the sorted posts.
     */
    private List<ResponseCsvPostDTO> getPostsByDiscount(String order, int top) {
        //Get a comparator of Discounts and this is sorted in ascendant
        Comparator<Post> comparator = order.equalsIgnoreCase("discount_asc") ?
                Comparator.comparing(Post::getDiscount) :
                Comparator.comparing(Post::getDiscount).reversed();
        //Get a List of the sorted Post and limit to top variable
        List<Post> sortedPosts = productRepository.findAllPost().stream()
                .sorted(comparator)
                .limit(top)
                .toList();
        //return a response of CSV file
        return mapPostsToResponseCsvPostDTO(sortedPosts);
    }

    /**
     * Maps a list of posts to a list of {@link ResponseCsvPostDTO}.
     *
     * @param posts the list of posts to map.
     * @return a List of {@link ResponseCsvPostDTO} representing the posts.
     */
    private List<ResponseCsvPostDTO> mapPostsToResponseCsvPostDTO(List<Post> posts) {
        return posts.stream().map(post ->
                new ResponseCsvPostDTO(
                        post.getId(),
                        post.getDate().toString(),
                        post.getCategory(),
                        post.getPrice(),
                        post.getProduct().getName(),
                        post.getProduct().getType(),
                        post.getProduct().getBrand(),
                        post.isHasPromo(),
                        post.getDiscount()
                )).toList();
    }


}
