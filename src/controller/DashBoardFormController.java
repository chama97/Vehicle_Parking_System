package controller;

import db.DB;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Delivery;
import model.Driver;
import model.Parking;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class DashBoardFormController {
    public AnchorPane dashBoardContext;
    public Label txtSlotNo;
    public ComboBox<String> cmbDriver;
    public Label lblTime;
    public Label lblDate;
    public ComboBox<String> cmbVehicle;
    public Label lblVehicleType;
    public volatile boolean stop;


    public void initialize() {

        loadDateAndTime();
        loadAllDrivers();
        loadAllVehicles();

       /* cmbDriver.getItems().addAll(
                "Sumith Kumara",
                "Amila Pathirana",
                "Jithmal Perera",
                "Sumith Dissanayaka",
                "Sumanasiri Herath",
                "Awantha Fernando",
                "Charith Sudara",
                "Prashan Dineth",
                "Chethiya Dilan",
                "Dushantha Perera",
                "Sumith Udayanga",
                "Dinesh Udara",
                "Udana Chathuranga",
                "Mohommad Riaz",
                "Sandun Kumara",
                "Priyanga Perera"
        );

        cmbVehicle.getItems().addAll(
                "NA-3434",
                "KA-4563",
                "58-3567",
                "GF-4358",
                "CCB-3568",
                "LM-6679",
                "QA-3369",
                "KB-3668",
                "JJ-9878",
                "GH-5772",
                "XY-4456",
                "YQ-3536",
                "CBB-3566",
                "QH-3444"

        );*/
    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    private void loadAllDrivers() {
        ArrayList<Driver> all = DB.driverList;
        for (Driver dto : all) {
            cmbDriver.getItems().add(dto.getDriverName());
        }
    }

    private void loadAllVehicles() {
        ArrayList<Vehicle> all = DB.vehicleList;
        for (Vehicle dto : all) {
            cmbVehicle.getItems().add(dto.getVehicleNo());
        }
    }

    public void managementLoginOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = (getClass().getResource("../view/ManagerLoginForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashBoardContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void parkVehicleSaveOnAction(ActionEvent actionEvent) {
        Parking park = new Parking( lblVehicleType.getText(),cmbVehicle.getValue(), txtSlotNo.getText(), lblTime.getText(), lblDate.getText());
        try{
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("../view/InParkingForm.fxml"));
            Parent parent = loader.load();
            InParkingFormController controller = loader.getController();

            if (controller.getParkList().add(park)) {
                controller.loadAllSParks();

            }

            Stage window = (Stage) dashBoardContext.getScene().getWindow();
            window.setScene(new Scene(parent));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void deliveryShiftSaveOnAction(ActionEvent actionEvent) {

        if(cmbVehicle.getValue()!=null && cmbDriver.getValue()!=null) {
            String data = (String.valueOf(cmbVehicle.getValue()));

            for (int i=0; i<DB.parkingList.size(); i++) {
                if (DB.parkingList.get(i).getVehicleNo().contains(data)) {
                    DB.parkingList.remove(i);
                }
            }
            Delivery delivery = new Delivery(cmbVehicle.getValue(), lblVehicleType.getText(), cmbDriver.getValue(), lblTime.getText());
            DB.deliveryList.add(delivery);
        }
    }

    public void vehicleTypeOnAction(ActionEvent actionEvent) {
        String id = cmbVehicle.getValue();
        for(int i=0; i<DB.vehicleList.size(); i++){
            String no = DB.vehicleList.get(i).getVehicleNo();
            if(id.equals(no)){
                lblVehicleType.setText(DB.vehicleList.get(i).getVehicleType());
            }
        }
        switch (lblVehicleType.getText()){
            case "Van": {
                setSlot("Van");
            }break;

            case "Bus": {
                setSlot("Bus");
            }break;

            case "Cargo Lorry": {
                setSlot("Cargo Lorry");
            }break;
        }
    }

    private void setSlot(String vehicleType) {
        for(int i=0; i<DB.slotTable.size(); i++){
            for (int j=0; j<DB.slotTable.size(); j++){
                if(vehicleType.equals(DB.slotTable.get(i).getVehicleType()) && DB.slotTable.get(i).isStatus() == false){
                    txtSlotNo.setText(DB.slotTable.get(i).getSlotNo());
                    return;
                }
            }
        }
    }


    public void driverNameOnAction (ActionEvent actionEvent){
    }
}

