package ElectricBunkDatabase;

public class ElectricModel {
    String elbname, elavailability, eladdress, elstate, elcity, elpin;


    public ElectricModel() {
    }

    public ElectricModel(String elbname, String elavailability, String eladdress, String elstate, String elcity, String elpin) {
        this.elbname = elbname;
        this.elavailability = elavailability;
        this.eladdress = eladdress;
        this.elstate = elstate;
        this.elcity = elcity;
        this.elpin = elpin;
    }

    public String getElbname() {
        return elbname;
    }

    public void setElbname(String elbname) {
        this.elbname = elbname;
    }

    public String getElavailability() {
        return elavailability;
    }

    public void setElavailability(String elavailability) {
        this.elavailability = elavailability;
    }

    public String getEladdress() {
        return eladdress;
    }

    public void setEladdress(String eladdress) {
        this.eladdress = eladdress;
    }

    public String getElstate() {
        return elstate;
    }

    public void setElstate(String elstate) {
        this.elstate = elstate;
    }

    public String getElcity() {
        return elcity;
    }

    public void setElcity(String elcity) {
        this.elcity = elcity;
    }

    public String getElpin() {
        return elpin;
    }

    public void setElpin(String elpin) {
        this.elpin = elpin;
    }
}
