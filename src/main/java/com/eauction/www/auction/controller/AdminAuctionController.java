package com.eauction.www.auction.controller;


import com.eauction.www.auction.models.Auction;
import com.eauction.www.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminAuctionController {

    @Autowired
    public AuctionService auctionService;

    @GetMapping(value = "/auctions")
    public List<Auction> getAuctions()
    {
        return auctionService.getAuctions();
    }


}
