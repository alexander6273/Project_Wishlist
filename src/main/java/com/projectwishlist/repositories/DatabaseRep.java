package com.projectwishlist.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class DatabaseRep {
    private Connection connection = null;
    private Statement statement;
    private ResultSet rs;
    private String sqlString;
    private Connection con;

    public DatabaseRep() {
        this.connection = DatabaseConnection.getConnection();
        this.statement = getStatement();
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

    public ResultSet getDataFromDbWhereId(String table, String rowIdName, int dataId){
        String sql = "SELECT * FROM projectwishlist." + table +
                "WHERE" + rowIdName + "='" + dataId + "';";
        ResultSet resultSet = getResultSet(sql);
        return resultSet;
    }

    public void insertdata(String table, String rows, String data) {
        try
        {
            sqlString = "INSERT INTO projectwishlist." + table + "(" + rows + ")" +
                    "VALUES(" + data + ");";
            statement.executeUpdate(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println(sqlString);
    }

    public void deletedata(String table,String row, String itemId){
        try
        {
            sqlString = "DELETE FROM projectwishlist." + table +
                    "WHERE (" + row + "=" + itemId + ");";
            statement.executeUpdate(sqlString);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String commaSeperateData(ArrayList<String> data){
        int size = data.size();
        int count = 1;
        String result = "";
        if (size > 0 ){
            for (String input : data){
                if (size == count){
                    result += "'" + input + "'";
                } else {
                    result += "'" + input + "'" + ", ";
                }
                count ++;
            }

        }
        return result;
    }

    public String commaSeperateRows(ArrayList<String> data){
        int size = data.size();
        int count = 1;
        String result = "";
        if (size > 0 ){
            for (String input : data){
                if (size == count){
                    result += input ;
                } else {
                    result += input + ", ";
                }
                count ++;
            }

        }
        return result;
    }
}