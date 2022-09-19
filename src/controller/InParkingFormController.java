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
import model.Parking;
import view.tm.DriverTm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class InParkingFormController {
    public AnchorPane parkingContext;
    public TableView<Parking> tblPark;
    public TableColumn<Parking, String> colVNo;
    public TableColumn<Parking, String>  colVType;
    public TableColumn<Parking, String>  colSlot;
    public TableColumn<Parking, String>  colParkTime;

    ArrayList<Parking> parkList = new ArrayList<>();

    public ArrayList<Parking> getParkList() {
        return parkList;
    }

    public void initialize() {

        colVNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colSlot.setCellValueFactory(new PropertyValueFactory<>("slotNo"));
        colParkTime.setCellValueFactory(new PropertyValueFactory<>("time"));
       // colParkTime.setCellValueFactory(new PropertyValueFactory<>("date"));

    }


    void loadAllSParks() {

        ObservableList<Parking> tmObservableList = FXCollections.observableArrayList();
        for (Parking temp : parkList
        ) {
            tmObservableList.add(
                   new Parking(temp.getVehicleNo(), temp.getVehicleType(), temp.getSlotNo(), temp.getTime(), temp.getDate())
            );
        }
        tblPark.setItems(tmObservableList);

    }


    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/ManagementForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) parkingContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
