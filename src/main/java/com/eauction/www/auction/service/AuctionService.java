package com.eauction.www.auction.service;

import com.eauction.www.auction.util.Utility;
import com.eauction.www.auction.models.Auction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    public List<Auction> getAuctions()
    {
        return Utility.getAuctions();
    }

    public List<Auction> getAuctions(String userId)
    {
        return Utility.getAuctions();
    }

    public Auction getAuctions(String userId , String auctionId)
    {
        return Utility.getAuctions().get(0);
    }


}
