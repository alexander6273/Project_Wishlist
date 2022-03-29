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
            sqlString = "SELECT * from persons";
            rs = stmt.executeQuery(sqlString);

            while(rs.next())
            {
                String fn= rs.getString("fname");
                String sn = rs.getString("sname");
                int a = rs.getInt("age");
                System.out.println("\tname = " + fn + " " + sn + ", Alder = " + a);
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
            sqlString = "INSERT INTO `projectwishlist`.`item` (`id`,`name`,`price`,`link`, `reserved`) " +
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
