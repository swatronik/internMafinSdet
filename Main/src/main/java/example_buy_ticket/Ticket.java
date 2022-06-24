package example_buy_ticket;

public class Ticket {

    private String last_name;
    private String first_name;
    private String middle_name;
    private String passport_date;
    private String passport_serie;
    private String passport_number;
    private String address;
    private String email;
    private String mobile;

    public Ticket(String last_name, String first_name, String middle_name, String passport_date, String passport_serie, String passport_number, String address, String email, String mobile, String s) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.passport_date = passport_date;
        this.passport_serie = passport_serie;
        this.passport_number = passport_number;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getPassport_date() {
        return passport_date;
    }

    public String getPassport_serie() {
        return passport_serie;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
}
