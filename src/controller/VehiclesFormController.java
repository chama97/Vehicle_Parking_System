package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.NewDriver;
import model.NewVehicle;
import view.tm.DriverTm;
import view.tm.VehicleTm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class VehiclesFormController {
    public AnchorPane vehicleContext;
    public TableView<VehicleTm> tblVehicle;
    public TableColumn<VehicleTm, String> colVNo;
    public TableColumn<VehicleTm, String>  colVType;
    public TableColumn<VehicleTm, String>  colWeight;
    public TableColumn<VehicleTm, String>  colNoPasseng;


    ArrayList<NewVehicle> vehicleList = new ArrayList();
    public ArrayList<NewVehicle> getVehicleList() {
        return vehicleList;
    }

    {
        vehicleList.add(new NewVehicle("NA-3434", "Bus", "3500", "60"));
        vehicleList.add(new NewVehicle("KA-4563", "Van", "1500", "10"));
        vehicleList.add(new NewVehicle("58-3567", "Van", "1500", "10"));
        vehicleList.add(new NewVehicle("GF-4358", "Van", "2000", "10"));
        vehicleList.add(new NewVehicle("CCB-3568", "Van", "1500", "12"));
        vehicleList.add(new NewVehicle("LM-6679", "Van", "2000", "15"));
        vehicleList.add(new NewVehicle("QA-3369", "Van", "1500", "13"));
        vehicleList.add(new NewVehicle("KB-3668", "Cargo Lorry", "2000", "5"));
        vehicleList.add(new NewVehicle("JJ-9878", "Cargo Lorry", "2000", "2"));
        vehicleList.add(new NewVehicle("GH-5772", "Cargo Lorry",  "2300", "3"));
        vehicleList.add(new NewVehicle("XY-4456", "Cargo Lorry",  "2300", "3"));
        vehicleList.add(new NewVehicle(" YQ-3536", "Cargo Lorry", "2000", "2"));
        vehicleList.add(new NewVehicle("CBB-3566", "Cargo Lorry",  "2500", "3"));
        vehicleList.add(new NewVehicle("QH-3444", "Cargo Lorry", "2500", "3"));

    }

    public void initialize(){

        colVNo.setCellValueFactory(new PropertyValueFactory("vehicleNo"));
        colVType.setCellValueFactory(new PropertyValueFactory("VehicleType"));
        colWeight.setCellValueFactory(new PropertyValueFactory("weight"));
        colNoPasseng.setCellValueFactory(new PropertyValueFactory("noPassengers"));


        ObservableList<VehicleTm> tmObservableList = FXCollections.observableArrayList();
        for (NewVehicle temp : vehicleList
        ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new VehicleTm(temp.getVehicleNo(), temp.getVehicleType(), temp.getWeight(), temp.getNoPassengers(),btn)
            );
        }
        tblVehicle.setItems(FXCollections.observableArrayList(tmObservableList));

        //tblVehicle.setItems(FXCollections.observableArrayList(vehicleList));

    }

    void loadAllSVehicle() {
        ObservableList<VehicleTm> tmObservableList = FXCollections.observableArrayList();
        for (NewVehicle temp : vehicleList
        ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new VehicleTm(temp.getVehicleNo(), temp.getVehicleType(), temp.getWeight(), temp.getNoPassengers(),btn)
            );
        }
        tblVehicle.setItems(tmObservableList);

    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/ManagementForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) vehicleContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
