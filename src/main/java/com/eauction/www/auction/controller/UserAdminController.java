package com.eauction.www.auction.controller;

import com.eauction.www.auction.dto.UserEntity;
import com.eauction.www.auction.models.Auction;
import com.eauction.www.auction.models.UserRegistration;
import com.eauction.www.auction.repo.UserRepository;
import com.eauction.www.auction.security.RequestContext;
import com.eauction.www.auction.service.AuctionService;
import com.eauction.www.auction.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/useradmin")
public class UserAdminController {

    @Autowired
    RequestContext requestContext;
    @Autowired
    public AuctionService auctionService;

    public Auction createAuction(@RequestBody Auction auction){
        auction.setUserName(requestContext.getUsername());
        return auctionService.createAuction(auction);

    }

}
