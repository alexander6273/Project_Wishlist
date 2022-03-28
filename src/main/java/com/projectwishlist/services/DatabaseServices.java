package com.projectwishlist.services;

import com.projectwishlist.models.Item;
import com.projectwishlist.repositories.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class DatabaseServices {
    private Connection connection = null;

    public DatabaseServices() {
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
}