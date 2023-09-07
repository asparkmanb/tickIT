package com.example.tickit.Controllers;

import com.example.tickit.DAO.TicketDAO;
import com.example.tickit.DAO.UserDAO;
import com.example.tickit.Models.Ticket;
import com.example.tickit.Models.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<Ticket, String> assignedCol;
    @FXML
    private TableColumn<Ticket, String> categoryCol;
    @FXML
    private TableColumn<Ticket, String > descriptionCol;
    @FXML
    private TableColumn<Ticket, Integer> idCol;
    @FXML
    private TableColumn<Ticket, String> locationCol;
    @FXML
    private TableColumn<Ticket, String> priorityCol;
    @FXML
    private TableColumn<Ticket, String> statusCol;
    @FXML
    private TableColumn<Ticket, String> titleCol;
    @FXML
    private TableView<Ticket> trTableView;

    ObservableList<Ticket> usersTickets = FXCollections.observableArrayList();

    @FXML
    void onActionSubmitTicket(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {

        int tickitID = 0;
        int user = currentUser.getId();
        String priority = "";
        String title = titleTextField.getText();
        String location = locationTextField.getText();
        String category = "";
        String description = descriptionTextField.getText();
        int organization_id = currentUser.getOrgID();
        int assigned_to = 16;
        String status = "New";
        String email = currentUser.getEmailAddress();

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
    void gotoDashboard(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        trTableView.setItems(TicketDAO.getAllTickets());

        dashboardAnchor.setVisible(true);
        submitTicketAnchorPane.setVisible(false);
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
    void onActionModify(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        getUserTickets();
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


    public void getUserTickets() throws SQLException, IOException, ClassNotFoundException {
        int userID = currentUser.getId();
        usersTickets.setAll(TicketDAO.getAllTicketsofUser(userID));
        trTableView.setItems(usersTickets);
        System.out.println(userID);
        System.out.println(usersTickets);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




        idCol.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("ticketID"));
        // statusCol.setCellValueFactory(new PropertyValueFactory<Ticket, String>("status"));
       // priorityCol.setCellValueFactory(new PropertyValueFactory<Ticket, String>("priority"));
       // categoryCol.setCellValueFactory(new PropertyValueFactory<Ticket, String>("category"));
       // titleCol.setCellValueFactory(new PropertyValueFactory<Ticket, String>("title"));
       // locationCol.setCellValueFactory(new PropertyValueFactory<Ticket, String >("location"));
       // descriptionCol.setCellValueFactory(new PropertyValueFactory<Ticket, String>("description"));
       // assignedCol.setCellValueFactory(new PropertyValueFactory<Ticket, String >("assignedTo"));


        try {
            trTableView.setItems(TicketDAO.getAllTickets());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        dashboardAnchor.setVisible(true);
        submitTicketAnchorPane.setVisible(false);


    }
}
