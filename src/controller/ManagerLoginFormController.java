package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagerLoginFormController {
    public AnchorPane MngContext;
    public TextField unLogin;
    public PasswordField pwLogin;
    public Label lblLogin;
    public Button btnLogin;

    public void inParkingOnAction(ActionEvent actionEvent) {
        try {
            checkLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkLogin() throws IOException {
        if(unLogin.getText().equals("aaa") && pwLogin.getText().equals("123")) {
           lblLogin.setText("Success!");
            URL resource  = (getClass().getResource("../view/InParkingForm.fxml"));
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) MngContext.getScene().getWindow();
            window.setScene(new Scene(load));
        }
        else if(unLogin.getText().isEmpty() && pwLogin.getText().isEmpty()) {
            lblLogin.setText("Please enter your data.");
        }
        else {
           lblLogin.setText("Wrong username or password!");
        }
    }

    public void backToDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/DashBoardForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) MngContext.getScene().getWindow();
        window.setScene(new Scene(load));
//        Stage window = (Stage) MngContext.getScene().getWindow();
//        window.close();
    }

    public void moveToPassword(ActionEvent actionEvent) {
        pwLogin.requestFocus();
    }

    public void moveToLogin(ActionEvent actionEvent) {
        btnLogin.requestFocus();
    }


}

