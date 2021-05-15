package com.eauction.www.auction.service;

import com.eauction.www.auction.FakeDB;
import com.eauction.www.auction.models.Auction;
import com.eauction.www.auction.security.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {

    @Autowired
    RequestContext requestContext;

    @Autowired
    FakeDB fakeDB;

    public List<Auction> getAuctions() {
        return fakeDB.getAuctions();
    }

    public List<Auction> getAuctions(String username) {
        return fakeDB.getAuctionViaUsername(username);
    }

    public Auction getAuctions(String userName, String auctionId) {
         Optional<Auction> auctionOptional =
                 getAuctions().stream().filter(auction -> auction.getAuctionId().equals(auctionId) && auction.getUserName().equals(userName)).findFirst();
         return auctionOptional.isPresent()?auctionOptional.get() : null;
    }


    public Auction createAuction(Auction auction) {
        auction.setCreatedBy(requestContext.getUsername());
        if(!requestContext.isAdmin()){
            auction.setUserName(requestContext.getUsername());
        }
        Auction a = fakeDB.createAuction(auction);
        if (null != a) {
            return a;
        } else {
            throw new RuntimeException("Unable to create Exception");
        }

    }


}

