package com.eauction.www.auction.controller;

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


    @GetMapping(value = "   ")
    public List<Auction> getAuctions(@PathVariable String userId)
    {
        return auctionService.getAuctions(userId);
    }


    @GetMapping(value = "/{userId}/auctions/{auctionId}")
    public Auction getAuctions(@PathVariable String userId , @PathVariable String auctionId)
    {
        return auctionService.getAuctions(userId,auctionId);
    }


}
