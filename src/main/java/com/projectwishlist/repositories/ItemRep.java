package com.projectwishlist.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemRep {

    /*private Statement stmt;
    private ResultSet rs;
    private String sqlString;
    private Connection con;*/

    private DatabaseRep databaseRep = null;
    private String table = "item";
    private String rows = null;

    public ItemRep()
    {
        this.databaseRep = new DatabaseRep();
        this.rows = rowsToString();
    }

    public String rowsToString(){
        ArrayList<String> rows = new ArrayList<>();
        rows.add("item_name");
        rows.add("item_price");
        rows.add("item_link");
        return databaseRep.commaSeperateRows(rows);
    }

    /*public void selectData()
    {
        try
        {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sqlString = "SELECT * from `projectwishlist`.`item`";
            rs = stmt.executeQuery(sqlString);

            while(rs.next())
            {
                String name= rs.getString("item_name");
                int price = rs.getInt("item_price");
                String link = rs.getString("item_link");
                System.out.println("\titem name = " + name + ", price = " + price + ", link = " + link);
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }*/

    public void insertToDb(ArrayList<String> data) {
        String dataString = databaseRep.commaSeperateData(data);
        databaseRep.insertdata(table, rows, dataString);
    }

    public void deleteItem(){

    }

    public static void main(String[] args)
    {
        ItemRep itemRep = new ItemRep();
        ArrayList<String> data = new ArrayList<>();
        data.add("test");
        data.add("200");
        data.add("link");
        itemRep.insertToDb(data);
    }
}
