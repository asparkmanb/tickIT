package com.example.tickit.Controllers;

import com.example.tickit.Models.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
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

    private static User currentUser;

    @FXML
    private RadioButton ticketRB;

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

    }
}
