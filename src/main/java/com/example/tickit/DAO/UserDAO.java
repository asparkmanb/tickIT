package com.example.tickit.DAO;

import com.example.tickit.JDBC;
import com.example.tickit.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDAO {

    public static ObservableList<User> getAllUsers() throws SQLException, IOException, ClassNotFoundException {
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        //JDBC.openConnection();
        String sql = "SELECT * FROM users";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        User user;
        try {
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email_address"), rs.getInt("organization_id"), rs.getInt("superadmin"), rs.getInt("admin"));
                allUsers.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allUsers;
    }

    public static void insert(User user) throws SQLException, IOException, ClassNotFoundException {
       // Connection con = JDBC.openConnection();
        String sql = "INSERT INTO users(id, username, password, first_name, last_name, email_address, organization_id, superadmin, admin) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, user.getId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getFirstName());
        ps.setString(5, user.getLastName());
        ps.setString(6, user.getEmailAddress());
        ps.setInt(7, user.getOrgID());
        ps.setInt(8, user.getSuperAdmin());
        ps.setInt(9, user.getAdmin());
        ps.executeUpdate();
        //JDBC.closeConnection();
    }
}
