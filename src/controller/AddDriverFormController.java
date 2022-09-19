package controller;

import com.jfoenix.controls.JFXTextField;
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

//        Driver driver = new Driver(txtDrName.getText(), txtNIC.getText(), txtLiceNo.getText(), txtAddress.getText(), txtContact.getText());
//        try{
//            FXMLLoader loader =  new FXMLLoader(getClass().getResource("../view/DriversForm.fxml"));
//            Parent parent = loader.load();
//
//
//            if (controller.getDriverList().add(driver)) {
//                controller.loadAllSDrivers();
//                new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
//            } else {
//                new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
//            }
//
//
//            Stage window = (Stage) addDriverContext.getScene().getWindow();
//            window.setScene(new Scene(parent));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public void moveToPassword(ActionEvent actionEvent) {

    }

    public void setTextField(String driverName, String NIC, String licenseNo, String address, String contact) {
        txtDrName.setText(driverName);
        txtNIC.setText(NIC);
        txtLiceNo.setText(licenseNo);
        txtAddress.setText(address);
        txtContact.setText(contact);
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
}