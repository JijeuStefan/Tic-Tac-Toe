package com.example.tictactoe2.DataBase;

import com.example.tictactoe2.Model.User;

import java.sql.*;

public class DataBase {
    private Statement stmt;

    public DataBase() {
        connect();
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tic-tac-toe", "root", "");
            stmt = con.createStatement();
        } catch(Exception ex) {
            System.out.println("error at connection:"+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public User authenticate(String username, String password) {
        ResultSet rs;
        User user = null;
        try {
            rs = stmt.executeQuery("select * from users where username='"+username+"' and password='"+password+"'");
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
