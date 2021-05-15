package com.eauction.www.auction;


import com.eauction.www.auction.models.Auction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FakeDB {


    List<Auction> auctions = new ArrayList<>();

    public Auction createAuction (Auction auction){

        boolean add = auctions.add(auction);
        return (add)? auction: null;
    }

    public List<Auction> getAuctions(){

        return auctions;
    }

    public Auction getAuctionViaId(String auctionId)
    {
         Optional<Auction> optAuction = getAuctions().stream().
                 filter(auction->auction.getAuctionId().equals(auctionId)).findFirst();
         return optAuction.isPresent()?optAuction.get():null;
    }

    public List<Auction> getAuctionViaUsername(String username)
    {
        return getAuctions().stream().
                filter(auction -> auction.getUserName().equals(username)).collect(Collectors.toList());
    }

    public List<Auction> getAuctionViaIdAndUserId(String auctionId,String userId)
    {
        return getAuctions().stream().
                filter(auction ->
                        (auction.getUserName().equals(userId) && auction.getAuctionId().equals(auctionId))).
                collect(Collectors.toList());
    }
}
