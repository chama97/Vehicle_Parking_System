package model;

import javafx.collections.ObservableList;

public class NewVehicle {
    private String vehicleNo;
    private String vehicleType;
    private String weight;
    private String noPassengers;

    public NewVehicle() {
    }

    public NewVehicle(String vehicleNo, String vehicleType, String weight, String noPassengers) {
        this.setVehicleNo(vehicleNo);
        this.setVehicleType(vehicleType);
        this.setWeight(weight);
        this.setNoPassengers(noPassengers);
    }


    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNoPassengers() {
        return noPassengers;
    }

    public void setNoPassengers(String noPassengers) {
        this.noPassengers = noPassengers;
    }
}
