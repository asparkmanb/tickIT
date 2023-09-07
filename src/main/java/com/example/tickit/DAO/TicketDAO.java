package com.example.tickit.DAO;

import com.example.tickit.JDBC;
import com.example.tickit.Models.Ticket;
import com.example.tickit.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface TicketDAO {

    public static ObservableList<Ticket> getAllTickets() throws SQLException, IOException, ClassNotFoundException {
        ObservableList<Ticket> allTickets = FXCollections.observableArrayList();
        String sql = "SELECT * FROM tickets";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Ticket ticket;
        try {
            while (rs.next()) {
                ticket = new Ticket(rs.getInt("ticket_id"), rs.getInt("user"), rs.getString("email"), rs.getString("priority"), rs.getString("title"), rs.getString("location"), rs.getString("category"), rs.getString("description"), rs.getInt("organization_id"), rs.getInt("assigned_to"), rs.getString("status"));
                allTickets.add(ticket);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allTickets;
    }

    public static ObservableList<Ticket> getAllTicketsofUser(int userID) throws SQLException, IOException, ClassNotFoundException {
        ObservableList<Ticket> allTicketsForUser = FXCollections.observableArrayList();
        String sql = "SELECT * FROM tickets WHERE user = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, userID);
        ResultSet rs = ps.executeQuery();
        Ticket ticket;
        try {
            while (rs.next()) {
                ticket = new Ticket(rs.getInt("ticket_id"), rs.getInt("user"), rs.getString("email"), rs.getString("priority"), rs.getString("title"), rs.getString("location"), rs.getString("category"), rs.getString("description"), rs.getInt("organization_id"), rs.getInt("assigned_to"), rs.getString("status"));
                allTicketsForUser.add(ticket);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allTicketsForUser;
    }

    public static void insert(Ticket ticket) throws SQLException, IOException, ClassNotFoundException {
        String sql = "INSERT INTO tickets(ticket_id, user, email, priority, title, location, category, description, organization_id, assigned_to, status) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, ticket.getTicketID());
        ps.setInt(2, ticket.getUser());
        ps.setString(3, ticket.getEmail());
        ps.setString(4, ticket.getPriority());
        ps.setString(5, ticket.getTitle());
        ps.setString(6, ticket.getLocation());
        ps.setString(7, ticket.getCategory());
        ps.setString(8, ticket.getDescription());
        ps.setInt(9, ticket.getOrganizationID());
        ps.setInt(10, ticket.getAssignedTo());
        ps.setString(11, ticket.getStatus());
        ps.executeUpdate();
    }
}
