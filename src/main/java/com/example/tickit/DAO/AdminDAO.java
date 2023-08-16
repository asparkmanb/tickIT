package com.example.tickit.DAO;

import com.example.tickit.JDBC;
import com.example.tickit.Models.Admin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdminDAO{

    public static ObservableList<Admin> getAllAdmins() throws SQLException, IOException, ClassNotFoundException {
        ObservableList<Admin> allAdmins = FXCollections.observableArrayList();
        JDBC.openConnection();
        String sql = "SELECT * FROM admins";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Admin admin;
        try {
            while (rs.next()) {
                admin = new Admin(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email_address"), rs.getInt("organization_id"), rs.getInt("superadmin"));
                allAdmins.add(admin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allAdmins;
    }
}
