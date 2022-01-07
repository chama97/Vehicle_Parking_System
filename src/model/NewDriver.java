package model;

import javafx.collections.ObservableList;

public class NewDriver {
    private String driverName;
    private String NIC;
    private String licenseNo;
    private String address;
    private String contact;

    public NewDriver(ObservableList<String> value) {
    }


    public NewDriver(String driverName, String NIC, String licenseNo, String address, String contact) {
        this.setDriverName(driverName);
        this.setNIC(NIC);
        this.setLicenseNo(licenseNo);
        this.setAddress(address);
        this.setContact(contact);
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
}
