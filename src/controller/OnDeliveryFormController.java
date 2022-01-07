package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Delivery;
import model.Parking;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class OnDeliveryFormController {
    public AnchorPane deliveryContext;
    public TableView<Delivery> tblDelivery;
    public TableColumn<Delivery, String> colVNo;
    public TableColumn<Delivery, String> colVType;
    public TableColumn<Delivery, String> colDrName;
    public TableColumn<Delivery, String> colLeftTime;


    ArrayList<Delivery> deliveryList = new ArrayList<>();

    public ArrayList<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public void initialize() {

        colVNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDrName.setCellValueFactory(new PropertyValueFactory<>("driver"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("time"));

    }


    void loadAllSDelivery() {

        ObservableList<Delivery> tmObservableList = FXCollections.observableArrayList();
        for (Delivery temp : deliveryList
        ) {
            tmObservableList.add(
                    new Delivery(temp.getVehicleNo(), temp.getVehicleType(), temp.getDriver(), temp.getTime())
            );
        }
        tblDelivery.setItems(tmObservableList);

    }


    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/ManagementForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) deliveryContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
