package com.example.tickit.Controllers;

import com.example.tickit.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Register1Controller {

    @FXML
    private TextField addressInput;

    @FXML
    private AnchorPane register1Anchor;

    @FXML
    private Button backButton;

    @FXML
    private TextField nameInput;

    @FXML
    private Button nextButton;

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("login.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setTitle("tickIT Solutions");
        stage.setScene(scene);
        stage.show();
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth()-stage.getWidth()) / 2);
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("register_2.fxml"));
        Stage stage;
        Scene scene;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 731, 452);
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth()-stage.getWidth()) / 2);

    }

}
