package org.iti.data.daoimpl;

import org.iti.data.daos.UserDao;
import org.iti.db.DBConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static volatile UserDaoImpl userDao = null;
    private static Connection conn;
    DBConnectionFactory dataSource = DBConnectionFactory.getInstance();

    private UserDaoImpl() throws SQLException {
        conn = dataSource.getConnection();
    }

    public static UserDaoImpl getUserDaoInstance() throws SQLException {
        if(userDao == null){
            synchronized (UserDaoImpl.class){
                if(userDao == null){
                    userDao = new UserDaoImpl();
                }
            }
        }
        return userDao;
    }

// ============================ Implementations ================================

    @Override
    public boolean isLoginValid(String email, String password) {
        String mail = null;
        String pass = null;
        ResultSet rs ;

        try {

            String myQuerySt = "SELECT email,password FROM ecomm.customers WHERE email=? and password=? ;";

            PreparedStatement prepSt = conn.prepareStatement(myQuerySt, ResultSet.TYPE_SCROLL_SENSITIVE,
                                                             ResultSet.CONCUR_UPDATABLE);
            prepSt.setString(1, email);
            prepSt.setString(2, password);

            rs = prepSt.executeQuery();

            while(rs.next())
            {
                mail = rs.getString("email");
                pass = rs.getString("password");
            }

            if (email.equalsIgnoreCase(mail) && password.equals(pass)) {
                prepSt.close();

                return true;
            }

            prepSt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int getUserIdByEmail(String email) throws SQLException {

        int userId = 0;
        ResultSet rs;

        try {
        String query = "SELECT customer_id FROM ecomm.customers WHERE email = ?";

        PreparedStatement prepSt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                                                     ResultSet.CONCUR_UPDATABLE);

        prepSt.setString(1,email);

        rs = prepSt.executeQuery();

        while (rs.next()){
            userId = rs.getInt("customer_id");
        }
        prepSt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

}