package com.projectwishlist.repositories;

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

    public static void main(String[] args) {
        ItemRep itemRep = new ItemRep();
        itemRep.deleteItem(2);
    }
}
