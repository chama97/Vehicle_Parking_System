package view.tm;

import javafx.scene.control.Button;
import model.NewDriver;

public class DriverTm {
    private String driverName;
    private String NIC;
    private String licenseNo;
    private String address;
    private String contact;
    private Button btn;

    public DriverTm(String driverName, String nic, String contact, String licenseNo, String address, String tempContact, Button btn) {
    }

    public DriverTm(String driverName, String NIC, String licenseNo, String address, String contact, Button btn) {
        this.setDriverName(driverName);
        this.setNIC(NIC);
        this.setLicenseNo(licenseNo);
        this.setAddress(address);
        this.setContact(contact);
        this.setBtn(btn);
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
