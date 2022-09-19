package model;

public class Slot {
    private String vehicleType;
    private String slotNo;
    private boolean status;

    public Slot() {
    }

    public Slot(String vehicleType, String slotNo, boolean status) {
        this.setVehicleType(vehicleType);
        this.setSlotNo(slotNo);
        this.setStatus(status);
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
