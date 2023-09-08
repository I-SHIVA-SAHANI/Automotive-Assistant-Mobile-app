package Business;

public class BusinessHelper2 {
    String businessname;
    String mechanicname;
    String services;
    String availability;
    String state;
    String city;
    String address;
    String phone;
    String pinCode;

    public BusinessHelper2(String businessname, String mechanicname, String services, String availability, String state, String city, String address, String phone, String pinCode) {
        this.businessname = businessname;
        this.mechanicname = mechanicname;
        this.services = services;
        this.availability = availability;
        this.state = state;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.pinCode = pinCode;


    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
