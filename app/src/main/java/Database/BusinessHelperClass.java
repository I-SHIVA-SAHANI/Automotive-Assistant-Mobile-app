package Database;

public class BusinessHelperClass {

    String Bname, Bphone, Bemail, Bpassword1;

    public BusinessHelperClass(String bname, String bphone, String bemail, String bpassword1) {
        Bname = bname;
        Bphone = bphone;
        Bemail = bemail;
        Bpassword1 = bpassword1;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public String getBphone() {
        return Bphone;
    }

    public void setBphone(String bphone) {
        Bphone = bphone;
    }

    public String getBemail() {
        return Bemail;
    }

    public void setBemail(String bemail) {
        Bemail = bemail;
    }

    public String getBpassword1() {
        return Bpassword1;
    }

    public void setBpassword1(String bpassword1) {
        Bpassword1 = bpassword1;
    }
}
