package controller;

import com.jfoenix.controls.JFXTextField;
import db.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import java.io.IOException;

public class AddDriverFormController {
    public AnchorPane addDriverContext;
    public JFXTextField txtDrName;
    public JFXTextField txtLiceNo;
    public JFXTextField txtNIC;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;


    public void AddDriverSaveOnAction(ActionEvent actionEvent) {

        if(txtDrName.getText().equals("") || txtLiceNo.getText().equals("") ||
                txtNIC.getText().equals("") || txtAddress.getText().equals("") || txtContact.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please Fill All Data", ButtonType.CLOSE).show();

        } else {
            Driver driver = new Driver(txtDrName.getText(), txtNIC.getText(), txtLiceNo.getText(), txtAddress.getText(), txtContact.getText());

            if (DB.driverList.add(driver)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved Driver Successfully", ButtonType.CLOSE).show();
                clearTextField();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
            }
        }
    }

    public void clearTextField() {
        txtDrName.setText(null);
        txtNIC.setText(null);
        txtLiceNo.setText(null);
        txtAddress.setText(null);
        txtContact.setText(null);
    }

    public void moveToNICOnAction(ActionEvent actionEvent) {
        txtNIC.requestFocus();
    }

    public void moveToAddressOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void moveToLicenseOnAction(ActionEvent actionEvent) {
        txtLiceNo.requestFocus();
    }

    public void moveToContactOnAction(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }

    public void CancelOnAction(ActionEvent actionEvent) {
    }
}