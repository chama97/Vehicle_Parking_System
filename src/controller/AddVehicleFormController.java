package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.NewVehicle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddVehicleFormController implements Initializable {
    public AnchorPane addVehicleContext;
    public JFXTextField txtVehName;
    public JFXTextField txtWeight;
    public JFXTextField txtNoPas;
    public ComboBox<String> combVehType;

    public void AddVehicleSaveOnAction(ActionEvent actionEvent) {
        NewVehicle vehicle = new NewVehicle(txtVehName.getText(), combVehType.getValue(),txtWeight.getText(), txtNoPas.getText());
        try{
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("../view/VehiclesForm.fxml"));
            Parent parent = loader.load();
            VehiclesFormController controller = loader.getController();

            if (controller.getVehicleList().add(vehicle)) {
                controller.loadAllSVehicle();
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
            }


            Stage window = (Stage) addVehicleContext.getScene().getWindow();
            window.setScene(new Scene(parent));

        } catch (IOException e) {
            e.printStackTrace();
        }

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
}
