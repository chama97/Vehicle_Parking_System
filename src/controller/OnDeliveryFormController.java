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
import model.Delivery;

import java.io.IOException;
import java.net.URL;


public class OnDeliveryFormController {
    public AnchorPane deliveryContext;
    public TableView<Delivery> tblDelivery;
    public TableColumn<Delivery, String> colVNo;
    public TableColumn<Delivery, String> colVType;
    public TableColumn<Delivery, String> colDrName;
    public TableColumn<Delivery, String> colLeftTime;
    public ComboBox cmbOnDelivery;


    public void initialize() {

        colVNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDrName.setCellValueFactory(new PropertyValueFactory<>("driver"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        cmbOnDelivery.getItems().add("On Delivery");
        cmbOnDelivery.getItems().add("In Parking");

        loadAllSDelivery();
    }

    void loadAllSDelivery() {
        ObservableList<Delivery> tmObservableList = FXCollections.observableArrayList();
        for (Delivery temp : DB.deliveryList
        ) {
            tmObservableList.add(
                    new Delivery(temp.getVehicleNo(), temp.getVehicleType(), temp.getDriver(), temp.getTime())
            );
        }
        tblDelivery.setItems(tmObservableList);
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/DashBoardForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) deliveryContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void moveInParkingAction(ActionEvent actionEvent) throws IOException {
        if (cmbOnDelivery.getValue().equals("In Parking")) {
            URL resource  = (getClass().getResource("../view/InParkingForm.fxml"));
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) deliveryContext.getScene().getWindow();
            window.setScene(new Scene(load));
        }
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
}
