package com.example.tickit.DAO;

import com.example.tickit.JDBC;
import com.example.tickit.Models.Organization;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrganizationDAO {

    public static void insert(Organization organization) throws SQLException, IOException, ClassNotFoundException {
        Connection con = JDBC.openConnection();
        String sql = "INSERT INTO organizations(organization_id, name, location) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, organization.getOrganization_id());
        ps.setString(2,organization.getOrganizationName());
        ps.setString(3,organization.getOrganizationLocation());

        ps.executeUpdate();
        JDBC.closeConnection();
    }
}
