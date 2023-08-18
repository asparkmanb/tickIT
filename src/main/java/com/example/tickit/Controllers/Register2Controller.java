package com.example.tickit.Controllers;

import com.example.tickit.DAO.UserDAO;
import com.example.tickit.DAO.OrganizationDAO;
import com.example.tickit.Main;
import com.example.tickit.Models.User;
import com.example.tickit.Models.Organization;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Register2Controller implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private PasswordField confirmPasswordInput;

    @FXML
    private TextField emailAddressInput;

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameInput;

    private String test;

    private static String newOrgName;
    private static String newOrgLocation;
    private static String userName;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static String emailAddress;


    public void recieveOrganization(String orgName,String orgLocation){
        newOrgName = orgName;
        newOrgLocation = orgLocation;
    }

    public static boolean isValidPassword(String password)
    {
        boolean isValid = true;
        if (password.length() > 20 || password.length() < 8)
        {
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        {
            isValid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars ))
        {
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers ))
        {
            isValid = false;
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars ))
        {
            isValid = false;
        }
        return isValid;
    }

    @FXML
    void back(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("register_1.fxml"));
        loader.load();
        Stage stage;
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene, 621, 388));
        stage.setTitle("Register");
        stage.show();
    }

    @FXML
    void register(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {

        Organization newOrganization = new Organization(0, newOrgName, newOrgLocation);
        OrganizationDAO.insert(newOrganization);

        int orgID = OrganizationDAO.getOrganizationID(newOrgName);

        userName = usernameInput.getText();

        if(passwordInput.getText().equals(confirmPasswordInput.getText())){
            password = passwordInput.getText();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("The two passwords do not match");
            alert.showAndWait();
        }

        firstName = firstNameInput.getText();
        lastName = lastNameInput.getText();
        emailAddress = emailAddressInput.getText();

        boolean isValidUsername = true;
        boolean allFieldsEntered = false;

        for(User user : UserDAO.getAllUsers()){
            if(userName.equals(user.getUsername())) {
                isValidUsername = false;
            }
        }

        if(isValidUsername == false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("This username already exists");
            alert.showAndWait();
        }

        if(!isValidPassword(password)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Password must be 8-20 characters, contain an uppercase and lowercase, a number, and a symbol");
            alert.showAndWait();
        }

        if (userName.isEmpty() || password.isEmpty() || newOrgName.isEmpty() || newOrgLocation.isEmpty() || firstName.isEmpty() || lastName.isEmpty()|| emailAddress.isEmpty()){
            allFieldsEntered = false;
        }
        else{
            allFieldsEntered = true;
        }


        if(allFieldsEntered == false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No fields can be blank");
            alert.showAndWait();
        }


        if(isValidUsername && isValidPassword(password) && allFieldsEntered){
            User user = new User(0, userName, password, firstName, lastName, emailAddress, orgID, 1, 1);
            UserDAO.insert(user);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thank you for registering");
            alert.setContentText("You may now log in with your admin credentials");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {





    }
}
