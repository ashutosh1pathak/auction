package com.eauction.www.auction.service;

import com.eauction.www.auction.FakeDB;
import com.eauction.www.auction.models.Bid;
import com.eauction.www.auction.models.RequestUserBid;
import com.eauction.www.auction.models.ResponseUserBid;
import com.eauction.www.auction.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BiddingService {

    @Autowired
    FakeDB fakeDB;

    public synchronized ResponseUserBid applyBid(RequestUserBid requestUserBid , String username){
        validateBid(requestUserBid);
        Bid bid = new Bid(Utility.generateUniqueBidId());
        bid.setBid(requestUserBid.getBid());
        bid.setAuctionId(requestUserBid.getAuctionId());
        bid.setItemId(requestUserBid.getItemId());
        bid.setBidTime(System.currentTimeMillis());
        bid.setUsername(username);

        return fakeDB.addBid(bid);


    }

    private boolean validateBid(RequestUserBid requestUserBid) {

        return true;
        //TODO: bidder must not be the owner of the Auction

        //TODO: an Admin cant bid.

        //TODO: validate current bid should be less than the bid applied by the user.


        //TODO: later introduce minimum increment for a valid bid.
        // Minimum increment should be decided by auction-owner per auction.
        // But there has to be a minimum and maximum limit set by Admin


    }

    public  List<Bid> getBids(String auctionId, String username) {

       return fakeDB.getBids(auctionId,username);
    }
}
