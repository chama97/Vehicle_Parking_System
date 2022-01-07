package model;

public class Delivery {
    private String vehicleNo;
    private String vehicleType;
    private String driver;
    private String time;

    public Delivery() {
    }

    public Delivery(String vehicleNo, String vehicleType, String driver, String time) {
        this.setVehicleNo(vehicleNo);
        this.setVehicleType(vehicleType);
        this.setDriver(driver);
        this.setTime(time);
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
