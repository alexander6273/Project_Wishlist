package com.projectwishlist.repositories;

import com.projectwishlist.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRep {
 private User user;
 private final DatabaseRep databaseRep;

    public UserRep() {
        this.databaseRep = new DatabaseRep();
    }

    public User getUserFromDb(int userId) throws SQLException {
        /* SELECT * FROM Db_test.users WHERE user = '1'*/
        String sql = "SELECT * FROM projectwishlist.user WHERE user_id = " + "'" + userId + "'";
        ResultSet resultSet = databaseRep.getResultSet(sql);

        String username = null;
        String password = null;
        String firstName = null;
        User user = null;

        while (resultSet.next()) {
            username = resultSet.getString("user_username");
            password = resultSet.getString("user_password");
            firstName = resultSet.getString("user_firstname");
        }
        if(username != null) {

            user = new User(userId, username, password, firstName);
        }

        return user;
        }
}
