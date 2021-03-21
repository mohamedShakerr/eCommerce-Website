package org.iti.data.daos;

import java.sql.SQLException;


public interface UserDao {

    // Check user existence
    boolean isLoginValid(String email, String password) throws SQLException ;

    // Get User Id By email
    int getUserIdByEmail(String email) throws SQLException;

    }