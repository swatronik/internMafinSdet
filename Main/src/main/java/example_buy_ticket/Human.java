package example_buy_ticket;

import java.util.ArrayList;

public class Human {

    private String last_name;
    private String first_name;
    private String middle_name;
    private String birthday;
    private String passport_date;
    private String passport_serie;
    private String passport_number;
    private String address;
    private String email;
    private String mobile;

    public Human(String last_name, String first_name, String middle_name, String birthday, String passport_date, String passport_serie, String passport_number, String address, String email, String mobile) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.birthday = birthday;
        this.passport_date = passport_date;
        this.passport_serie = passport_serie;
        this.passport_number = passport_number;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
    }

    public Ticket buyTheTicket() {

        System.out.println("Билет куплен");
        return new Ticket();
    }
}
