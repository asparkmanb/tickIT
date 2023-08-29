package com.example.tickit.DAO;

import com.example.tickit.JDBC;
import com.example.tickit.Models.Organization;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrganizationDAO {

    public static void insert(Organization organization) throws SQLException, IOException, ClassNotFoundException {
        String sql = "INSERT INTO organizations(organization_id, name, location) VALUES (?,?,?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, organization.getOrganization_id());
        ps.setString(2,organization.getOrganizationName());
        ps.setString(3,organization.getOrganizationLocation());

        ps.executeUpdate();
    }

    public static ObservableList<Organization> getAllOrganizations() throws SQLException, IOException, ClassNotFoundException {
        ObservableList<Organization> allOrganizations = FXCollections.observableArrayList();
        //JDBC.openConnection();

        String sql = "SELECT * FROM organizations";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Organization organization;
        try {
            while (rs.next()) {
                organization = new Organization(rs.getInt("organization_id"), rs.getString("name"), rs.getString("location"));
                allOrganizations.add(organization);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //JDBC.closeConnection();
        return allOrganizations;
    }

    public static int getOrganizationID(String orgName) throws SQLException, IOException, ClassNotFoundException {
        int orgID =0;
        ObservableList<Integer> orgIDs = FXCollections.observableArrayList();
        String sql = "SELECT * FROM organizations WHERE name = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, orgName);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                orgIDs.add(rs.getInt("organization_id"));
                orgID = orgIDs.get(0);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orgID;

    }


}
