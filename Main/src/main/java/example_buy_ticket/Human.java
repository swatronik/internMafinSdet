package example_buy_ticket;

import java.util.ArrayList;

public class Human {

    private String last_name;
    private String first_name;
    private String middle_name;
    ArrayList<Ticket> list;

    public ArrayList<Ticket> getList() {
        return list;
    }

    public Human(String last_name, String first_name, String middle_name,ArrayList<Ticket> list) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.list=list;
    }

    public Ticket buyTheTicket(String direction) {

        System.out.println("Билет куплен");
        Ticket ticket=new Ticket(last_name, first_name, middle_name,direction);
        list.add(ticket);
        return ticket;
    }
}
