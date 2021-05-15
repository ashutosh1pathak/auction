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

    /**
     * Get all auction till date.(have to be sorted in descending order w.r.t date)
     * Will gonna be very heavy operation and huge response.
     * Make it lazy load for items in auction
     * @return
     */
    @GetMapping(value = "/auctions")
    public List<Auction> getAuctions()
    {
        return auctionService.getAuctions();
    }












}
