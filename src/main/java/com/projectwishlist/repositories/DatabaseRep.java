package com.projectwishlist.repositories;

import com.projectwishlist.repositories.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class DatabaseRep {
    private Connection connection = null;
    private Statement stmt;
    private ResultSet rs;
    private String sqlString;
    private Connection con;

    public DatabaseRep() {
        this.connection = DatabaseConnection.getConnection();
    }

    private Statement getStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getResultSet(String sql) {
        try {
            return Objects.requireNonNull(getStatement()).executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAllItems() throws SQLException {
        //ArrayList<Item> users = new ArrayList<>();

        ResultSet resultSet = getResultSet("SELECT * FROM projectwishlist.item");
        String itemName = "fejl";
        System.out.println(itemName);

        while (resultSet.next()) {
            itemName = resultSet.getString("item_name");
            System.out.println(itemName);
        }
        return itemName;
        // return users;
    }

    public void insertdata(String table, String columns, String data) {
        try
        {
            sqlString = "INSERT INTO projectwishlist." + table + "(" + columns + ")" +
                    "VALUES(" + data + ")";
            stmt.executeUpdate(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println(sqlString);
    }
}