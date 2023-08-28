package com.example.tickit.Controllers;

import com.example.tickit.DAO.UserDAO;
import com.example.tickit.Main;
import com.example.tickit.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController {
    @FXML
    private Label invalidLabel;

    @FXML
    private Label error;

    @FXML
    private Hyperlink hyperLink;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    private User loggedInUser;

    @FXML
    void Login(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        boolean userNameValid = false;
        boolean passwordValid = false;


        String userName = usernameField.getText();
        String password = passwordField.getText();

        for(User user : UserDAO.getAllUsers()){
            if (user.getUsername().equals(userName)){
                userNameValid = true;
                if(user.getPassword().equals(password)){
                    passwordValid = true;
                    if(userNameValid & passwordValid){
                        loggedInUser = user;
                        System.out.println(loggedInUser.getFirstName());
                    }
                }
            };
        }

        if(userNameValid & passwordValid){
            System.out.println("login successful");
            invalidLabel.setVisible(false);


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("dashboard.fxml"));
            loader.load();
            Stage stage;

            DashboardController dashboardController = loader.getController();
            dashboardController.receiveUser(loggedInUser);

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene, 1070, 612));
            stage.setTitle("Dashboard");
            stage.show();

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((screenBounds.getWidth()-stage.getWidth()) / 2);
            stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);
        }
        else{
            System.out.println("login not successful");
            invalidLabel.setVisible(true);
        }

    }

    @FXML
    void hyperLink(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Main.class.getResource("register_1.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 621, 388);
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth()-stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);
    }

}
