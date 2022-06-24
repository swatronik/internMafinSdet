import example_buy_ticket.Human;
import example_buy_ticket.Ticket;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        Human piter = new Human("Piter", "Parker", "Bendjamin",new ArrayList<Ticket>());
        System.out.println(piter.buyTheTicket("Sochi"));
        System.out.println(piter.buyTheTicket("Moscow"));
        System.out.println(piter.getList());



    }
}
