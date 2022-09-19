package controller;

import db.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Parking;


import java.io.IOException;
import java.net.URL;

public class InParkingFormController {
    public AnchorPane parkingContext;
    public TableView<Parking> tblPark;
    public TableColumn<Parking, String> colVNo;
    public TableColumn<Parking, String>  colVType;
    public TableColumn<Parking, String>  colSlot;
    public TableColumn<Parking, String>  colParkTime;
    public ComboBox cmbInParking;


    public void initialize() {

        colVNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colSlot.setCellValueFactory(new PropertyValueFactory<>("slotNo"));
        colParkTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        loadAllSParks();

        cmbInParking.getItems().add("In Parking");
        cmbInParking.getItems().add("On Delivery");
    }


    void loadAllSParks() {
        ObservableList<Parking> tmObservableList = FXCollections.observableArrayList();
        for (Parking temp : DB.parkingList
        ) {
            tmObservableList.add(
                   new Parking(temp.getVehicleNo(), temp.getVehicleType(), temp.getSlotNo(), temp.getTime())
            );
        }
        tblPark.setItems(tmObservableList);
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) parkingContext.getScene().getWindow();
        window.close();
    }

    public void AddDriverOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/AddDriverForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public void AddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/AddVehicleForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public void moveToOnDeliveryAction(ActionEvent actionEvent) throws IOException {
        if (cmbInParking.getValue().equals("On Delivery")) {
            URL resource  = (getClass().getResource("../view/OnDeliveryForm.fxml"));
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) parkingContext.getScene().getWindow();
            window.setScene(new Scene(load));
        }
    }
}
