package db;

import model.*;

import java.util.ArrayList;

public class DB {

    public static ArrayList<Vehicle> vehicleList = new ArrayList();

    static {
        vehicleList.add(new Vehicle("NA-3434", "Bus", "3500", "60"));
        vehicleList.add(new Vehicle("KA-4563", "Van", "1500", "10"));
        vehicleList.add(new Vehicle("58-3567", "Van", "1500", "10"));
        vehicleList.add(new Vehicle("GF-4358", "Van", "2000", "10"));
        vehicleList.add(new Vehicle("CCB-3568", "Van", "1500", "12"));
        vehicleList.add(new Vehicle("LM-6679", "Van", "2000", "15"));
        vehicleList.add(new Vehicle("QA-3369", "Van", "1500", "13"));
        vehicleList.add(new Vehicle("KB-3668", "Cargo Lorry", "2000", "5"));
        vehicleList.add(new Vehicle("JJ-9878", "Cargo Lorry", "2000", "2"));
        vehicleList.add(new Vehicle("GH-5772", "Cargo Lorry",  "2300", "3"));
        vehicleList.add(new Vehicle("XY-4456", "Cargo Lorry",  "2300", "3"));
        vehicleList.add(new Vehicle(" YQ-3536", "Cargo Lorry", "2000", "2"));
        vehicleList.add(new Vehicle("CBB-3566", "Cargo Lorry",  "2500", "3"));
        vehicleList.add(new Vehicle("QH-3444", "Cargo Lorry", "2500", "3"));
    }


    public static ArrayList<Driver> driverList = new ArrayList<>();

    static {
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

    public static ArrayList<Slot>  slotTable = new ArrayList();
    static {
        slotTable.add(new Slot("Van","1",false));
        slotTable.add(new Slot("Van","2",false));
        slotTable.add(new Slot("Van","3",false));
        slotTable.add(new Slot("Van","4",false));
        slotTable.add(new Slot("Cargo Lorry","5",false));
        slotTable.add(new Slot("Cargo Lorry","6",false));
        slotTable.add(new Slot("Cargo Lorry","7",false));
        slotTable.add(new Slot("Cargo Lorry","8",false));
        slotTable.add(new Slot("Cargo Lorry","9",false));
        slotTable.add(new Slot("Cargo Lorry","10",false));
        slotTable.add(new Slot("Cargo Lorry","11",false));
        slotTable.add(new Slot("Van","12",false));
        slotTable.add(new Slot("Van","13",false));
        slotTable.add(new Slot("Bus","14",false));
    }

    public static ArrayList<Delivery> deliveryList = new ArrayList<Delivery>();

    static {

    }

    public static ArrayList<Parking> parkingList = new ArrayList<Parking>();
    static {

    }

}
