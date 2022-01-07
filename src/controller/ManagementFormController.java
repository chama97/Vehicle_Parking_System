package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementFormController {
    public AnchorPane MngHomeContext;

    public void inParkingOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/InParkingForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) MngHomeContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void OnDeliveryOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/OnDeliveryForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) MngHomeContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void vehiclesOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/VehiclesForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) MngHomeContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void driversOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/DriversForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) MngHomeContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }


    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/DashBoardForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) MngHomeContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
