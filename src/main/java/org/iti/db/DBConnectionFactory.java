package org.iti.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionFactory {

    private static  DBConnectionFactory dbConnectionFactory = null;


    private DBConnectionFactory(){}

    public static DBConnectionFactory  getInstance(){

        if(dbConnectionFactory == null){
            synchronized (DBConnectionFactory.class){
                if(dbConnectionFactory == null){
                    dbConnectionFactory = new DBConnectionFactory();
                }
            }
        }
        return dbConnectionFactory;
    }

    public Connection getConnection(){
        Connection conn = null;
        try {
            InitialContext ctx = null;
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myusers");
            conn = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return  conn;
    }



}
