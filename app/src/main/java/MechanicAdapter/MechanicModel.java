package MechanicAdapter;

public class MechanicModel {

    String address, availability, businessname, services, city, mechanicname, phone, pinCode, state;

    public MechanicModel() {
    }

    public MechanicModel(String address, String availability, String businessname, String services, String city, String mechanicname, String phone, String pinCode, String state) {


        this.address = address;
        this.availability = availability;
        this.businessname = businessname;
        this.services = services;
        this.city = city;
        this.mechanicname = mechanicname;
        this.phone = phone;
        this.pinCode = pinCode;
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
