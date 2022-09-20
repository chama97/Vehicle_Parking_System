package controller;

import com.jfoenix.controls.JFXTextField;
import db.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import model.Vehicle;


import java.net.URL;
import java.util.ResourceBundle;

public class AddVehicleFormController implements Initializable {
    public AnchorPane addVehicleContext;
    public JFXTextField txtVehName;
    public JFXTextField txtWeight;
    public JFXTextField txtNoPas;
    public ComboBox<String> combVehType;

    public void AddVehicleSaveOnAction(ActionEvent actionEvent) {

        if(txtVehName.getText().equals("") || txtWeight.getText().equals("") ||
                txtNoPas.getText().equals("") || combVehType.valueProperty().equals(null) ) {
            new Alert(Alert.AlertType.WARNING, "Please Fill All Data", ButtonType.CLOSE).show();

        } else {
        Vehicle vehicle = new Vehicle(txtVehName.getText(), combVehType.getValue(),txtWeight.getText(), txtNoPas.getText());
            if (DB.vehicleList.add(vehicle)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved Driver Successfully", ButtonType.CLOSE).show();
                clearTextField();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
            }
        }
    }

    public void clearTextField() {
        txtVehName.setText(null);
        txtNoPas.setText(null);
        txtWeight.setText(null);
        combVehType.valueProperty().set(null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        combVehType.getItems().addAll(
                "Van",
                "Bus",
                "Cargo Lorry"

        );
    }

    public void moveToWeightOnAction(ActionEvent actionEvent) {
        txtWeight.requestFocus();
    }

    public void moveToPassengerOnAction(ActionEvent actionEvent) {
        txtNoPas.requestFocus();
    }

    public void CancelOnAction(ActionEvent actionEvent) {
        txtVehName.setText(null);
        txtNoPas.setText(null);
        txtWeight.setText(null);
        combVehType.valueProperty().set(null);
    }
}
