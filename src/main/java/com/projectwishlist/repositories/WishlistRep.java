package com.projectwishlist.repositories;

import com.projectwishlist.models.Wishlist;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WishlistRep {
    private final DatabaseRep databaseRep;
    private final String rowsString;
    private final String table;
    private final ArrayList<String> rows = new ArrayList<String>();


    public WishlistRep() {
        this.databaseRep = new DatabaseRep();
        this.table = "wishlist";
        this.rowsString = rowsToString();

    }

    public String rowsToString(){
        rows.add("wishlist_id");
        rows.add("wishlist_name");
        rows.add("wishlist_link");
        rows.add("user_id");
        return databaseRep.commaSeperateRows(rows);
    }



    public Wishlist getWishListFromDB(int wishlistId) {
        ResultSet resultSet = databaseRep.getDataFromDbWhereId(table, rows.get(0), wishlistId);

        String wishlistName = null;
        String wishlistLink = null;
        String userId = null;

        try {
            while(resultSet.next()) {
                wishlistName = resultSet.getString(rows.get(0));
                wishlistLink = resultSet.getString(rows.get(1));
                userId = resultSet.getString(rows.get(2));
            }
            if (wishlistName != null) {
                return new Wishlist(wishlistId, wishlistName, wishlistLink, userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getData() {
        ResultSet rs = databaseRep.getResultSet("SELECT * FROM projectwishlist.wishlist");
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

        ResultSet rs = databaseRep.getResultSet(sql);
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
