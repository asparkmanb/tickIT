package com.example.tickit.Controllers;

import com.example.tickit.DAO.OrganizationDAO;
import com.example.tickit.Main;
import com.example.tickit.Models.Organization;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Register1Controller implements Initializable {

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

    private Parent root;


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
    void next(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {


        String newOrgName = nameInput.getText();
        String newOrgLocation = addressInput.getText();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("register_2.fxml"));
        loader.load();
        Stage stage;

        Register2Controller register2Controller = loader.getController();
        register2Controller.recieveOrganization(newOrgName, newOrgLocation);

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene, 731, 452));
        stage.setTitle("Register");
        stage.show();

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth()-stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
