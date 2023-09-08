package Database;

public class BunkHelper {

    String bunkname, bunkavailability, bunkstate, bunkcity, bunkaddress, bunkpinCode, bunkphone, bunklandmark;

    public BunkHelper(String bunkname, String bunkavailability, String bunkstate, String bunkcity, String bunkaddress, String bunkpinCode, String bunkphone, String bunklandmark) {
        this.bunkname = bunkname;
        this.bunkavailability = bunkavailability;
        this.bunkstate = bunkstate;
        this.bunkcity = bunkcity;
        this.bunkaddress = bunkaddress;
        this.bunkpinCode = bunkpinCode;
        this.bunkphone = bunkphone;
        this.bunklandmark = bunklandmark;
    }



    public String getBunkname() {
        return bunkname;
    }

    public void setBunkname(String bunkname) {
        this.bunkname = bunkname;
    }

    public String getBunkavailability() {
        return bunkavailability;
    }

    public void setBunkavailability(String bunkavailability) {
        this.bunkavailability = bunkavailability;
    }

    public String getBunkstate() {
        return bunkstate;
    }

    public void setBunkstate(String bunkstate) {
        this.bunkstate = bunkstate;
    }

    public String getBunkcity() {
        return bunkcity;
    }

    public void setBunkcity(String bunkcity) {
        this.bunkcity = bunkcity;
    }

    public String getBunkaddress() {
        return bunkaddress;
    }

    public void setBunkaddress(String bunkaddress) {
        this.bunkaddress = bunkaddress;
    }

    public String getBunkpinCode() {
        return bunkpinCode;
    }

    public void setBunkpinCode(String bunkpinCode) {
        this.bunkpinCode = bunkpinCode;
    }

    public String getBunkphone() {
        return bunkphone;
    }

    public void setBunkphone(String bunkphone) {
        this.bunkphone = bunkphone;
    }

    public String getBunklandmark() {
        return bunklandmark;
    }

    public void setBunklandmark(String bunklandmark) {
        this.bunklandmark = bunklandmark;
    }
}
