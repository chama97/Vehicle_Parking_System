package controller;

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
import model.Parking;

import java.io.IOException;
import java.net.URL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("    HH:mm:ss ");
            lblTime.setText(LocalDateTime.now().format(dateFormatter));
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("              yyyy-MM-dd ");
            lblDate.setText(LocalDateTime.now().format(timeFormatter));

        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        cmbDriver.getItems().addAll(
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

        );


     /*   FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/VehiclesForm.fxml"));
        VehiclesFormController controller = loader.getController();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (String temp : controller.get
             ) {

        }
*/
    }
    // controller.setTextDrivers(cmbDriver.getAccessibleText());


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

        Delivery delivery = new Delivery(cmbVehicle.getValue(), lblVehicleType.getText(), cmbDriver.getValue(), lblTime.getText());
        try{
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("../view/OnDeliveryForm.fxml"));
            Parent parent = loader.load();
           OnDeliveryFormController controller = loader.getController();

            if (controller.getDeliveryList().add(delivery)) {
                controller.loadAllSDelivery();

            }

            Stage window = (Stage) dashBoardContext.getScene().getWindow();
            window.setScene(new Scene(parent));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void vehicleTypeOnAction(ActionEvent actionEvent) {
        if (cmbVehicle.getValue().equals("NA-3434")) {
            lblVehicleType.setText("Bus");
        }else if (cmbVehicle.getValue().equals("KA-4563") || cmbVehicle.getValue().equals("58-3567") || cmbVehicle.getValue().equals( "GF-4358") || cmbVehicle.getValue().equals("CCB-3568") || cmbVehicle.getValue().equals( "QA-3369") || cmbVehicle.getValue().equals("LM-6679")){
            lblVehicleType.setText("Van");
        } else {
            lblVehicleType.setText("Cargo Lorry");

        }

        txtSlotNo.setText("      01");
    }

    public void driverNameOnAction (ActionEvent actionEvent){
    }
}

