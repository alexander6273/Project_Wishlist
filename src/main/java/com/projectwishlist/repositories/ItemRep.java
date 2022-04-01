package com.projectwishlist.repositories;

import java.util.ArrayList;

public class ItemRep {

    /*private Statement stmt;
    private ResultSet rs;
    private String sqlString;
    private Connection con;*/

    private DatabaseRep databaseRep = null;
    private String table = "item";
    private String rowsString = null;
    private ArrayList<String> rows = new ArrayList<>();

    public ItemRep()
    {
        declareRowsArray();
        this.databaseRep = new DatabaseRep();
        this.rowsString = rowsToString();
    }

    public String rowsToString(){
        return databaseRep.commaSeperateRows(rows);
    }

    public void declareRowsArray(){
        rows.add("item_id");
        rows.add("item_name");
        rows.add("item_price");
        rows.add("item_link");
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
        //removes id because auto increment
        rows.remove(0);
        String dataString = databaseRep.commaSeperateData(data);
        databaseRep.insertdata(table, rowsString, dataString);
        //adds id back
        rows.add(0, "item_id");
    }

    public void deleteItem(){
        databaseRep.deletedata(table, rowsString, );
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
