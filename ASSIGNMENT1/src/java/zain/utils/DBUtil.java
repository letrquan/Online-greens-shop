/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author quan2
 */
public class DBUtil {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Assignment";
        conn = DriverManager.getConnection(url, "zain", "4444");
        return conn;
    }

//    public static Connection getConnection() throws NamingException, SQLException {
//        Connection conn = null;
//        Context context = new InitialContext();
//        Context end = (Context) context.lookup("java:comp/env");
//        DataSource ds = (DataSource) end.lookup("DBCon");
//        conn = ds.getConnection();
//        return conn;
//    }
}
