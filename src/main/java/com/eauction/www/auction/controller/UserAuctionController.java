package com.eauction.www.auction.controller;

import com.eauction.www.auction.security.RequestContext;
import com.eauction.www.auction.service.AuctionService;
import com.eauction.www.auction.models.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserAuctionController {


    @Autowired
    public AuctionService auctionService;

    @Autowired
    public RequestContext requestContext;




    @GetMapping(value = "/auctions/{auctionId}")
    public Auction getAuctions(@PathVariable String auctionId)
    {
        return auctionService.getAuctions(requestContext.getUsername(),auctionId);
    }


}
