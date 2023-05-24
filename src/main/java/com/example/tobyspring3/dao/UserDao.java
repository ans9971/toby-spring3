package com.example.tobyspring3.dao;

import com.example.tobyspring3.UserDao.SimpleConnectionMaker;
import com.example.tobyspring3.dmain.User;

import java.sql.*;

import static java.lang.System.getenv;


public class UserDao {
    ConnectionMaker connectionMaker;
//    SimpleConnectionMaker connectionMaker = new SimpleConnectionMaker();

    public void add(User user) throws ClassNotFoundException, SQLException {

        Connection conn = connectionMaker.makeConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());

        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection conn = connectionMaker.makeConnection();

        PreparedStatement pstmt = conn.prepareStatement("select id, name, password from users where id = ?");
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        rs.next(); // ctrl + enter

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        pstmt.close();
        conn.close();

        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setId("5");
        user.setName("kyeongrok");
        user.setPassword("1234");
        userDao.add(user);

        User selectedUser = userDao.get("1");
        System.out.println(selectedUser.getId());
        System.out.println(selectedUser.getName());
        System.out.println(selectedUser.getPassword());
    }
}

//public class UserDao {
//
//    // return type이 Connection
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        Map<String, String> env = getenv();
//        String dbHost = env.get("DB_HOST"); //DB_HOST=jdbc:mysql://localhost:3306/spring-db
//        String dbUser = env.get("DB_USER");
//        String dbPassword = env.get("DB_PASSWORD");
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection(
//                dbHost, dbUser, dbPassword
//        );
//        return conn;
//    }
//    SimpleConnectionMaker connectionMaker = new SimpleConnectionMaker();
//
//    public void add(User user) throws ClassNotFoundException, SQLException {
//
//        Connection conn = getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
//        pstmt.setString(1, user.getId());
//        pstmt.setString(2, user.getName());
//        pstmt.setString(3, user.getPassword());
//
//        pstmt.executeUpdate();
//
//        pstmt.close();
//        conn.close();
//    }
//
//    public User get(String id) throws ClassNotFoundException, SQLException {
//        Connection conn = getConnection();
//
//        PreparedStatement pstmt = conn.prepareStatement("select id, name, password from users where id = ?");
//        pstmt.setString(1, id);
//        ResultSet rs = pstmt.executeQuery();
//        rs.next(); // ctrl + enter
//
//        User user = new User();
//        user.setId(rs.getString("id"));
//        user.setName(rs.getString("name"));
//        user.setPassword(rs.getString("password"));
//
//        rs.close();
//        pstmt.close();
//        conn.close();
//
//        return user;
//    }
//
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        UserDao userDao = new NUserDao();
//        User user = new User();
//        user.setId("4");
//        user.setName("kyeongrok");
//        user.setPassword("1234");
//        userDao.add(user);
//
//        User selectedUser = userDao.get("4");
//        System.out.println(selectedUser.getId());
//        System.out.println(selectedUser.getName());
//        System.out.println(selectedUser.getPassword());
//    }
//}


//
//public class UserDao {
//    public void add(User user) throws SQLException, ClassNotFoundException {
//        Map<String, String> env = getenv();
//        String dbHost = env.get("DB_HOST");
//        String dbUser = env.get("DB_USER");
//        String dbPassword = env.get("DB_PASSWORD");
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);
//        PreparedStatement pstmt = conn.prepareStatement("insert into users(id,name,password) values (?,?,?)");
//        pstmt.setString(1,user.getId());
//        pstmt.setString(2,user.getName());
//        pstmt.setString(3,user.getPassword());
//        pstmt.executeUpdate();
//        pstmt.close();
//        conn.close();
//
//    }
//    public User get(String id) throws ClassNotFoundException, SQLException {
//        Map<String, String> env = getenv();
//        String dbHost = env.get("DB_HOST"); //DB_HOST=jdbc:mysql://localhost:3306/spring-db
//        String dbUser = env.get("DB_USER");
//        String dbPassword = env.get("DB_PASSWORD");
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection(
//                dbHost, dbUser, dbPassword
//        );
//
//        PreparedStatement pstmt = conn.prepareStatement("select id, name, password from users where id = ?");
//        pstmt.setString(1, id);
//        ResultSet rs = pstmt.executeQuery();
//        rs.next(); // ctrl + enter
//
//        User user = new User();
//        user.setId(rs.getString("id"));
//        user.setName(rs.getString("name"));
//        user.setPassword(rs.getString("password"));
//
//        rs.close();
//        pstmt.close();
//        conn.close();
//
//        return user;
//    }
//
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setId("2");
//        user.setName("kyeongrok");
//        user.setPassword("1234");
////        userDao.add(user);
//
//        User selectedUser = userDao.get("2");
//        System.out.println(selectedUser.getId());
//        System.out.println(selectedUser.getName());
//        System.out.println(selectedUser.getPassword());
//    }






//    public User get(String id) throws SQLException, ClassNotFoundException {
//
//        Map<String, String> env = getenv();
//        String dbHost = env.get("DB_HOST"); //DB_HOST=jdbc:mysql://localhost:3306/spring-db
//        String dbUser = env.get("DB_USER");
//        String dbPassword = env.get("DB_PASSWORD");
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection(
//                dbHost, dbUser, dbPassword
//        );
//
//        PreparedStatement pstmt = conn.prepareStatement("select id, name, password from users where id = ?");
//        pstmt.setString(1, id);

        //        Map<String, String> env = getenv();
//        String dbHost = env.get("DB_HOST");
//        String dbUser = env.get("DB_USER");
//        String dbPassword = env.get("DB_PASSWORD");
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);
//        PreparedStatement pstmt = conn.prepareStatement("select id, name, password from users where id =?");
//        pstmt.setString(1, id);
//        ResultSet rs = pstmt.executeUpdate();
//        ResultSet rs = pstmt.executeQuery();
//        rs.next();
//
//        User user = new User();
//        user.setId(rs.getString("id"));
//        user.setName(rs.getString("name"));
//        user.setPassword(rs.getString("password"));
//        rs.close();
//        pstmt.close();
//        conn.close();
//        return new User();
//    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setId("2");
//        user.setName("kyeongrok");
//        user.setPassword("1234");
//        userDao.add(user);
//    }


