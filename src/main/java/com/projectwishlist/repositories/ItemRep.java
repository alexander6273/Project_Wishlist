package com.projectwishlist.repositories;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemRep {

    private DatabaseRep databaseRep = null;
    private String table = "item";
    private ArrayList<String> rows = new ArrayList<>();
    private String rowsString = null;

    public ItemRep() {
        declareRowsArray();
        this.databaseRep = new DatabaseRep();
        this.rowsString = rowsToString();
    }

    public void declareRowsArray(){
        rows.add("item_id");
        rows.add("item_name");
        rows.add("item_price");
        rows.add("item_link");
    }
    public String rowsToString(){
        return databaseRep.commaSeperateRows(rows);
    }

    public void insertToDb(ArrayList<String> data) {
        String dataString = databaseRep.commaSeperateData(data);
        databaseRep.insertData(table, databaseRep.removeIdFromRow(rowsString), dataString);
    }

    public void deleteItem(int itemId){
        databaseRep.deleteData(table, rows.get(0), itemId);
    }
/*
    public ArrayList<String> getItemsFromWishlist(int wishlistId){
        ArrayList<String> items = new ArrayList<>();
        String sql = "SELECT * FROM projectwishlist." + table + " INNER JOIN wishlistitems ON item.item_id = wishlistitems.item_id WHERE wishlistitems.wishlist_id = " + wishlistId + " ;";
        ResultSet resultSet = databaseRep.getResultSet(sql);
        try {
            while(resultSet.next()) {
                String item_id = resultSet.getString(rows.get(0));
                String item_name = resultSet.getString(rows.get(1));
                String item_price = resultSet.getString(rows.get(2));
                String item_link = resultSet.getString(rows.get(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 */


    public static void main(String[] args) {
        ItemRep itemRep = new ItemRep();
        itemRep.deleteItem(2);
    }
}
