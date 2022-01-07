package model;

public class Parking {
    private String vehicleNo;
    private String vehicleType;
    private String slotNo;
    private String time;
    private  String date;


    public Parking() {
    }

    public Parking(String vehicleNo, String vehicleType, String slotNo, String time, String date) {
        this.setVehicleNo(vehicleNo);
        this.setVehicleType(vehicleType);
        this.setSlotNo(slotNo);
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

    public String getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }

    public String getTime() { return time; }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() { return date; }

    public void setDate(String time) {
        this.date = date;
    }


}
