package com.eauction.www.auction.models;

import java.util.List;

public class ResponseAuction {

    List<Auction> auctions;
    Auction auction;

    public ResponseAuction(List<Auction> auctions) {
        this.auctions = auctions;
    }

    public ResponseAuction(Auction auction) {
        this.auction = auction;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
