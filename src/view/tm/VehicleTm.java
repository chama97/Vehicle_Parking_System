package view.tm;

import javafx.scene.control.Button;

public class VehicleTm {
    private String vehicleNo;
    private String vehicleType;
    private String weight;
    private String noPassengers;
    private Button btn;

    public VehicleTm() {
    }

    public VehicleTm(String vehicleNo, String vehicleType, String weight, String noPassengers, Button btn) {
        this.setVehicleNo(vehicleNo);
        this.setVehicleType(vehicleType);
        this.setWeight(weight);
        this.setNoPassengers(noPassengers);
        this.setBtn(btn);
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
