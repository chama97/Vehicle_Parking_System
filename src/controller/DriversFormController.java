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
import model.Driver;
import view.tm.DriverTm;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class DriversFormController {

    public AnchorPane driversContext;
    public TableView<DriverTm> tblDriver;
    public TableColumn<DriverTm, String> colName;
    public TableColumn<DriverTm, String> colNIC;
    public TableColumn<DriverTm, String> colLiceNo;
    public TableColumn<DriverTm, String> colAddress;
    public TableColumn<DriverTm, String> colContact;
    public TableColumn<DriverTm, String> colDelete;


    ArrayList<Driver> driverList = new ArrayList<>();

    public ArrayList<Driver> getDriverList() {
        return driverList;
    }

    {
        driverList.add(new Driver("Sumith Kumara", "7834354546V", "B6464845", "Colombo", "0772345672"));
        driverList.add(new Driver("Amila Pathirana", " 8826253734V", "  B3354674", "  Galle", " 0717573583"));
        driverList.add(new Driver("Jithmal Perera", "9283289272V", "  B3674589", " Horana", " 0772452457"));
        driverList.add(new Driver("Sumith Dissanayaka", "9425245373V", "  B8366399", "  Kaluthara", "0782686390"));
        driverList.add(new Driver("Sumanasiri Herath", "8976544373V", " B3537538", "Beruwala", "  0772534436"));
        driverList.add(new Driver("Awantha Fernando", " 9173537839V", "  B3554789", "  Matara", "  0714534356"));
        driverList.add(new Driver("Charith Sudara", " 9173537479V", "  B3454789", " Ambalangoda", "  0764545856"));
        driverList.add(new Driver("Prashan Dineth", "9362426738V", "B2683536", "Wadduwa", "0752345672"));
        driverList.add(new Driver("Dushantha Perera", " 8826253734V", "  B3354674", "  Galle", " 0717573583"));
        driverList.add(new Driver("Sumith Udayanga", "9283289272V", "  B3674589", " Horana", " 0772452457"));
        driverList.add(new Driver("Sandun Kumara", "9425245373V", "  B8366399", "  Panadura", "0782686390"));
        driverList.add(new Driver(" Mohommad Riaz", "8876544373V", " B3437538", "Ratnapura", "  0772534436"));
        driverList.add(new Driver("Udana Chathuranga", " 9773537839V", "  B3554789", " Colombo 3", "  0714534356"));
        driverList.add(new Driver("Dinesh Udara", " 9673537479V", "  B3455783", " Bambalapitiya", "  0764545856"));
        driverList.add(new Driver("Jineth Dilshan", " 9973537839V", "  B9076789", " Ratmalana", "  0714534356"));
        driverList.add(new Driver(" Priyanga Perera", " 9173537479V", "  B4689789", " Kollupitiya", "  0764545856"));
    }


    public void initialize() {

        colName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colLiceNo.setCellValueFactory(new PropertyValueFactory<>("licenseNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        ObservableList<DriverTm> tmObservableList = FXCollections.observableArrayList();
        for (Driver temp : driverList
        ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new DriverTm(temp.getDriverName(), temp.getNIC(), temp.getLicenseNo(), temp.getAddress(), temp.getContact(),btn)
            );
        }
        tblDriver.setItems(FXCollections.observableArrayList(tmObservableList));

    }

    void loadAllSDrivers() {
        ObservableList<DriverTm> tmObservableList = FXCollections.observableArrayList();
        for (Driver temp : driverList
             ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new DriverTm(temp.getDriverName(), temp.getNIC(), temp.getLicenseNo(), temp.getAddress(), temp.getContact(),btn)
            );
        }
        tblDriver.setItems(tmObservableList);

    }


    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = (getClass().getResource("../view/ManagementForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) driversContext.getScene().getWindow();
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






    /*
    */


}