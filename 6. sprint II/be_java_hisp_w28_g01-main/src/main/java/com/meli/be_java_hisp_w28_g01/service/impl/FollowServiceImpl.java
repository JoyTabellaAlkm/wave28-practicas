package com.meli.be_java_hisp_w28_g01.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w28_g01.dto.response.FollowDto;
import com.meli.be_java_hisp_w28_g01.dto.response.FollowedSellersDto;
import com.meli.be_java_hisp_w28_g01.dto.response.SellerDto;
import com.meli.be_java_hisp_w28_g01.exception.FollowNotFoundException;
import com.meli.be_java_hisp_w28_g01.exception.IlegalArgumentException;
import com.meli.be_java_hisp_w28_g01.model.Buyer;
import com.meli.be_java_hisp_w28_g01.dto.response.FollowersDto;
import com.meli.be_java_hisp_w28_g01.exception.FollowAlreadyExistsException;
import com.meli.be_java_hisp_w28_g01.exception.NotFoundException;
import com.meli.be_java_hisp_w28_g01.model.Follow;
import com.meli.be_java_hisp_w28_g01.model.Seller;
import com.meli.be_java_hisp_w28_g01.repository.IFollowRepository;
import com.meli.be_java_hisp_w28_g01.service.IBuyerService;
import com.meli.be_java_hisp_w28_g01.service.IFollowService;
import com.meli.be_java_hisp_w28_g01.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class FollowServiceImpl implements IFollowService {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    IFollowRepository followRepository;

    @Autowired
    IBuyerService buyerService;

    @Autowired
    ISellerService sellerService;

    @Override
    public FollowDto addFollow(int userId, int userIdToFollow) {
        List<Follow> followList = followRepository.getAll();

        boolean thereIsBuyer = buyerService.findById(userId).isPresent();
        boolean thereIsSeller = sellerService.findById(userIdToFollow).isPresent();
        if (!thereIsBuyer) throw new NotFoundException(userId, "Comprador");
        if (!thereIsSeller) throw new NotFoundException(userIdToFollow, "Vendedor");

        boolean alreadyExistFollow = followList.stream().anyMatch( f -> f.getBuyer().getId() == userId && f.getSeller().getId() == userIdToFollow);
        if(alreadyExistFollow){
            throw new FollowAlreadyExistsException(userId, userIdToFollow);
        }

        return mapper.convertValue(followRepository.addFollow(new Follow(buyerService.findById(userId).get(), sellerService.findById(userIdToFollow).get())), FollowDto.class);
    }

    @Override
    public List<Follow> getAll() {
        return followRepository.getAll();
    }

    @Override
    public FollowedSellersDto getFollowedSeller(int userId) {
        Optional<Buyer> foundBuyer = buyerService.findById(userId);
        if (foundBuyer.isEmpty()){
            throw new NotFoundException(userId, "usuario");
        }
        List<Follow> follows = followRepository.getAll().stream().filter(f->f.getBuyer().getId() == userId).toList();
        List<SellerDto> followedSellers = addFollowedSellers(follows);
        FollowedSellersDto followedSellersDto = new FollowedSellersDto(foundBuyer.get().getId(),foundBuyer.get().getName(),followedSellers);

        return followedSellersDto;
    }

    private List<SellerDto> addFollowedSellers(List<Follow> follows){
        List<SellerDto> followedSellers = new ArrayList<>();
        follows.stream()
                .forEach(f-> followedSellers.add(
                        new SellerDto(f.getSeller().getId(),f.getSeller().getName())
                        ));
        return followedSellers;
    }

    @Override
    public FollowersDto getFollowersCount(int userId) {
        List<Follow> followList = getAll();
        Optional<Seller> seller = sellerService.findById(userId);

        if (seller.isEmpty()) {
            throw new NotFoundException(userId, "vendedor");
        }

        followList = followList.stream().filter(f -> f.getSeller().getId() == userId).toList();
        return new FollowersDto(seller.get().getId(), seller.get().getName(), followList.size());
    }

    @Override
    public FollowedSellersDto getFollowedOrderedSeller(int userId, String order) {
        if (!"name_asc".equals(order) && !"name_desc".equals(order)) {
            throw new IlegalArgumentException("Ese tipo de ordenamiento no existe.");
        }

        Buyer buyer = buyerService.findById(userId)
                .orElseThrow(() -> new NotFoundException(userId, "Usuario"));

        List<Follow> buyerFollowsList = followRepository.getAll().stream()
                .filter(f -> f.getBuyer().getId() == userId)
                .toList();

        List<SellerDto> followedSellers = buyerFollowsList.stream()
                .map(Follow::getSeller)
                .map(s -> new SellerDto(s.getId(), s.getName()))
                .sorted("name_asc".equals(order)
                        ? Comparator.comparing(SellerDto::getName)
                        : Comparator.comparing(SellerDto::getName).reversed())
                .toList();

        return new FollowedSellersDto(buyer.getId(), buyer.getName(), followedSellers);
    }


    @Override
    public FollowDto deleteFollow(int userId, int userIdToUnfollow) {
        List<Follow> followList = getAll();

        Optional<Seller> seller = sellerService.findById(userIdToUnfollow);
        Optional<Buyer> buyer = buyerService.findById(userId);

        if (seller.isEmpty()) {
            throw new NotFoundException(userIdToUnfollow, "vendedor");
        }

        if (buyer.isEmpty()) {
            throw new NotFoundException(userId, "comprador");
        }

        followList = followList.stream().filter(f -> f.getSeller().getId() == userIdToUnfollow && f.getBuyer().getId() == userId).toList();
        if (followList.isEmpty()){
            throw new FollowNotFoundException(userId, userIdToUnfollow);
        }

        return mapper.convertValue(followRepository.deleteFollow(userId, userIdToUnfollow), FollowDto.class);
    }
}
