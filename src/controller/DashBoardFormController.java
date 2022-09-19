package controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.Delivery;
import model.Driver;
import model.Parking;
import model.Vehicle;

import java.io.IOException;

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
    public JFXButton btnPark;
    public JFXButton btnDelivery;


    public void initialize() {

        loadDateAndTime();
        loadAllDrivers();
        loadAllVehicles();

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
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ManagerLoginForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public void parkVehicleSaveOnAction(ActionEvent actionEvent) {

        for(int i=0; i<DB.slotTable.size(); i++) {
            if (txtSlotNo.getText().equals(DB.slotTable.get(i).getSlotNo())) {
                DB.slotTable.get(i).setStatus(true);
            }
        }
        if(cmbVehicle.getValue()!=null) {
            String data = (String.valueOf(cmbVehicle.getValue()));
            Parking parking = new Parking( lblVehicleType.getText(),cmbVehicle.getValue(), txtSlotNo.getText(), lblTime.getText(), lblDate.getText());
            DB.parkingList.add(parking);
            clearData();
            btnDelivery.setDisable(true);
            btnPark.setDisable(true);

            for (int i=0; i<DB.deliveryList.size(); i++) {
                if (DB.deliveryList.get(i).getVehicleNo().contains(data)) {
                    DB.deliveryList.remove(i);
                }
            }
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
            clearData();
            btnDelivery.setDisable(true);
            btnPark.setDisable(true);
        }
        for (int i=0; i<DB.parkingList.size(); i++) {
            if (cmbVehicle.getValue().equals(DB.parkingList.get(i).getVehicleNo())) {
                setStatusFalse(DB.parkingList.get(i).getSlotNo());
            }
        }
    }

    private void setStatusFalse(String slot) {
        for (int i=0; i<DB.slotTable.size(); i++){
            if (DB.slotTable.get(i).getSlotNo().equals(slot)){
                DB.slotTable.get(i).setStatus(false);
            }
        }
    }

    private void clearData() {
        lblVehicleType.setText(null);
        txtSlotNo.setText(null);
//        cmbVehicle.getSelectionModel().clearSelection();
//        cmbDriver.getSelectionModel().clearSelection();
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
        if(lblVehicleType.getText()!=null) {
            btnPark.setDisable(false);
            btnDelivery.setDisable(false);
        }
    }
}

