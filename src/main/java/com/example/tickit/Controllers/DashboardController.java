package com.example.tickit.Controllers;

import com.example.tickit.DAO.TicketDAO;
import com.example.tickit.DAO.UserDAO;
import com.example.tickit.Models.Ticket;
import com.example.tickit.Models.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {
    @FXML
    private Button account;

    @FXML
    private Button closeTicket;

    @FXML
    private AnchorPane dashboardAnchor;

    @FXML
    private Button dashboardBttm;

    @FXML
    private Button exit;

    @FXML
    private Button modifyTicket;

    @FXML
    private Label numberOfPreviousTickets;

    @FXML
    private Label numberOfRequestsLabel;

    @FXML
    private Label numberOfTicketsLabel;

    @FXML
    private RadioButton requestRB;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    @FXML
    private Button submitRequest;

    @FXML
    private Button submitTicket;

    @FXML
    private ToggleGroup ticket;

    @FXML
    private Button openActivesButton;

    @FXML
    private Button previousTicketsButton;

    @FXML
    private Button activeRequestsButton;

    private static User currentUser;

    @FXML
    private RadioButton ticketRB;

    @FXML
    private TextField userNameField;

    @FXML
    private AnchorPane submitTicketAnchorPane;

    @FXML
    private ChoiceBox<?> priorityCB;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField locationTextField;

    @FXML
    private ChoiceBox<?> categoryCB;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button cancelButton;
    @FXML
    private Button submitTicketNew;

    @FXML
    void onActionSubmitTicket(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {

        int tickitID = 0;
        String user = currentUser.getUsername();
        String email = currentUser.getEmailAddress();
        //String userFirstName = currentUser.getFirstName();
        String priority = "";
        String title = titleTextField.getText();
        String location = locationTextField.getText();
        String category = "";
        String description = descriptionTextField.getText();
        int organization_id = currentUser.getOrgID();
        String assigned_to = "";
        String status = "";

        Ticket ticket = new Ticket(tickitID, user, email, priority, title, location, category, description, organization_id, assigned_to, status);
        TicketDAO.insert(ticket);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thank you for submitting your ticket");
        alert.setContentText("A technician will reach out to you regarding this ticket shortly");
        alert.showAndWait();




    }

    @FXML
    void onActionCancel(ActionEvent event) {

    }

    @FXML
    void openActives(ActionEvent event) {
        System.out.println("going to active tickets");
    }

    @FXML
    void openPreviousTickets(ActionEvent event) {
        System.out.println("going to previous ticke");
    }

    @FXML
    void opensRequests(ActionEvent event) {

    }

    @FXML
    void gotoAccount(ActionEvent event) {

    }

    @FXML
    void gotoDashboard(ActionEvent event) {

    }

    @FXML
    void gotoExit(ActionEvent event) {

    }

    @FXML
    void gotoNewTicket(ActionEvent event) {

        submitTicketAnchorPane.setVisible(true);
        dashboardAnchor.setVisible(false);
        userNameField.setText(currentUser.getUsername());

    }

    @FXML
    void gotoRequest(ActionEvent event) {

    }

    @FXML
    void onActionCloseTicket(ActionEvent event) {

    }

    @FXML
    void onActionModify(ActionEvent event) {

    }

    @FXML
    void onActionRequestTable(ActionEvent event) {

    }

    @FXML
    void onActionTicketTable(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

    public void receiveUser(User currentUserFromLogin){
        currentUser = currentUserFromLogin;
        System.out.println(currentUser.getFirstName());
    }

    public void getUserName(User user){
        System.out.println(user.getFirstName());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dashboardAnchor.setVisible(true);
        submitTicketAnchorPane.setVisible(false);
    }
}
