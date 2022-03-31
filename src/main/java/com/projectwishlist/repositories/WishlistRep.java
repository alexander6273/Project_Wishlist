package com.projectwishlist.repositories;

import com.projectwishlist.models.Wishlist;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WishlistRep {
    private final DatabaseRep dbRep;

    public WishlistRep() {
        this.dbRep = new DatabaseRep();
    }

    public Wishlist getWishListFromDB(int wishlistID) {
        String sql = "SELECT * FROM projectwishlist.wishlist" +
                " WHERE wishlist_id = " + "'" + wishlistID + "'";
        ResultSet rs = dbRep.getResultSet(sql);

        String wishlistName = null;
        String wishlistLink = null;
        String userId = null;

        try {
            while(rs.next()) {
                wishlistName = rs.getString("wishlist_name");
                wishlistLink = rs.getString("wishlist_link");
                userId = rs.getString("user_id");
            }
            if (wishlistName != null) {
                return new Wishlist(wishlistID, wishlistName, wishlistLink, userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getData() {
        ResultSet rs = dbRep.getResultSet("SELECT * FROM projectwishlist.wishlist");

        try {
            while(rs.next()) {
                String col1 = rs.getString("wishlist_id");
                String col2 = rs.getString("wishlist_name");
                String col3 = rs.getString("wishlist_link");
                String col4 = rs.getString("user_id");
                System.out.println(col1 + ", " + col2 + ", " + col3 + ", " + col4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "t";
    }

    public ArrayList<Wishlist> getAllWishlistsFromUser() {
        ArrayList<Wishlist> listOfWishlists = new ArrayList<>();
        String sql = "SELECT * FROM projectwishlist.wishlist \n" +
                "WHERE user_id = 1 ";

        ResultSet rs = dbRep.getResultSet(sql);


        int wishlistId = 0;
        String wishlistName = null;
        String wishlistLink = null;
        String userId = null;

        try {
            while(rs.next()) {
                wishlistId = rs.getInt("wishlist_id");
                wishlistName = rs.getString("wishlist_name");
                wishlistLink = rs.getString("wishlist_link");
                userId = rs.getString("user_id");
                System.out.println(wishlistName);

                if (wishlistName != null) {
                    Wishlist wishlist = new Wishlist(wishlistId, wishlistName, wishlistLink, userId);
                    listOfWishlists.add(wishlist);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(listOfWishlists);
        return listOfWishlists;
    }


}
