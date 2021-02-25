package com.eauction.www.auction.util;

import com.eauction.www.auction.models.Auction;
import com.eauction.www.auction.models.Item;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Utility {

    public static List<Auction> getAuctions()
    {

        return createSampleAuctions();

    }

    private static List<Auction> createSampleAuctions() {

        List<Auction> auctions = new ArrayList<>();
        int maxItems = generateRandomRangeInteger(1,5);
        for(int a=0;a<maxItems;a++)
        {
            auctions.add(createSampleAuction());
        }
        return auctions;

    }


    public static Auction createSampleAuction()
    {
        String auctionId = generateUniqueAuctionId();
        Long startT = getModifiedTimestamp(System.currentTimeMillis(),generateRandomRangeInteger(0,5));
        Long stopT = getModifiedTimestamp(System.currentTimeMillis(),generateRandomRangeInteger(5,9));


        Auction auction = new Auction();
        auction.setAuctionId(auctionId);
        auction.setAuctionDescription("Any Sample Auction Description.AuctionId:"+auctionId);
        auction.setAuctionName("Old is Gold:"+auctionId);
        auction.setItems(getSampleItems(auctionId));
        auction.setStartTimestamp(startT);
        auction.setStopTimestamp(stopT);


        return auction;
    }

    private static Item getSampleItem(String auctionId) {

        String itemId = generateUniqueItemId();
        Item item = new Item();
        item.setItemId(itemId);
        item.setItemName("Glass");
        item.setItemDescription("Any Sample Item Description. ItemId:"+itemId);
        item.setItemCount(1);
        item.setItemStartPrice(generateRandomRangeDouble(34,124));
        item.setAuctionId(auctionId);

        return item;
    }


    private static List<Item> getSampleItems(String auctionId)
    {
        List<Item> items = new ArrayList<>();
        int maxItems = generateRandomRangeInteger(1,5);
        for(int a=0;a<maxItems;a++)
        {
            items.add(getSampleItem(auctionId));
        }
        return items;
    }

    public static String generateUniqueAuctionId()
    {
        UUID uuid = UUID.randomUUID();
        String auctionId = uuid.toString().replace("-","");
        return auctionId;
    }

    public static String generateUniqueItemId()
    {
        UUID uuid = UUID.randomUUID();
        String itemId = uuid.toString().replace("-","");
        return itemId;
    }


    public static Integer generateRandomRangeInteger(Integer minimum , Integer maximum)
    {
        return generateRandomRangeDouble(minimum,maximum).intValue();
    }

    public static Double generateRandomRangeDouble(Integer minimum , Integer maximum)
    {
       Double random =  (Math.random() * (maximum - minimum + 1) + minimum);
       return Precision.round(random,2);
    }


    public static Long getModifiedTimestamp(Long timestamp , Integer day)
    {
        return timestamp +  Long.valueOf(day * 24 * 60 * 60 * 1000);
    }


}
