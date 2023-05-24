package com.example.tobyspring3.db;
import java.sql.*;
import java.util.Map;

import static java.lang.System.getenv;

public class ConnectionChecker {

    public void check() throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-3-35-67-179.ap-northeast-2.compute.amazonaws.com/spring-db",
                "root", "password");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("show databases");

        while(rs.next()){
            String line =rs.getString(1);
            System.out.println(line);
        }
    }

    public void add() throws ClassNotFoundException, SQLException {
        Map<String, String> env = getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                dbHost, dbUser, dbPassword
        );

        PreparedStatement pstmt = conn.prepareStatement(
                "insert into users(id, name, password) values (?, ?, ?)"
        );
        pstmt.setString(1, "4");
        pstmt.setString(2, "kyeongrok3");
        pstmt.setString(3, "12343");
        pstmt.executeUpdate();

    }
    public void select() throws SQLException, ClassNotFoundException {


        Map<String, String> env = getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                dbHost, dbUser, dbPassword
        );
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from users");
        rs = st.getResultSet();
        while (rs.next()) {
            String str = rs.getString(1);
            String str2 = rs.getString(2);
            String str3 = rs.getString(3);
            System.out.println(str + str2 + str3);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionChecker cc = new ConnectionChecker();
        cc.select();

    }
}





//import java.sql.*;
//
//public class ConnectionChecker {
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://ec2-3-35-67-179.ap-northeast-2.compute.amazonaws.com/spring-db",
//                "root", "password");
//
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery("SHOW DATABASES");
//        rs = st.getResultSet();
//        while (rs.next()) {
//            String str = rs.getString(1);
//            System.out.println(str);
//        }
//        ConnectionChecker cc = new ConnectionChecker();
//        cc.add();
//    }
//    public void add() throws ClassNotFoundException, SQLException {
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://ec2-3-35-67-179.ap-northeast-2.compute.amazonaws.com/spring-db",
//                "root", "password");
//
//        PreparedStatement pstmt = con.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
//        pstmt.setString(1, "1");
//        pstmt.setString(2, "kyeongrok");
//        pstmt.setString(3, "12345678");
//        pstmt.executeUpdate();
//    }
//
//}
