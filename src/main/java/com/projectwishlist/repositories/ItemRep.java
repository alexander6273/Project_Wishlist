package com.projectwishlist.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ItemRep {

    private Statement stmt;
    private ResultSet rs;
    private String sqlString;
    private Connection con;

    public void selectData()
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
    }

    public void insertdata() {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int price = sc.nextInt();
        String link = sc.next();
        boolean reserved = false;

        try
        {
            sqlString = "INSERT INTO `projectwishlist`.`item` (`name`,`price`,`link`, `reserved`) " +
                    "VALUES('" + name + "'," + price + "," + link + "," + reserved + ")";
            stmt.executeUpdate(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println(sqlString);
    }
}
