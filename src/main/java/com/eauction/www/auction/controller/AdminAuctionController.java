package com.eauction.www.auction.controller;


import com.eauction.www.auction.dto.UserEntity;
import com.eauction.www.auction.models.Auction;
import com.eauction.www.auction.models.UserRegistration;
import com.eauction.www.auction.repo.UserRepository;
import com.eauction.www.auction.service.AuctionService;
import com.eauction.www.auction.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminAuctionController {

    @Autowired
    public AuctionService auctionService;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping(value = "/auctions")
    public List<Auction> getAuctions()
    {
        return auctionService.getAuctions();
    }


    @PostMapping(value = "/registration")
    public String registration(@RequestBody UserRegistration userRegistration)
    {
       UserEntity userEntity = userRepository.save(Utility.convertToUserEntity(userRegistration,passwordEncoder,userRegistration.isAdmin()));
        if (userEntity != null) {
            return userEntity.getUsername();
        } else {
            throw new RuntimeException("Unable To Register");
        }
    }


}
