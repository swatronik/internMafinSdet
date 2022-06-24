import example_buy_ticket.Human;
import example_buy_ticket.Ticket;

import java.util.ArrayList;

public class Main {

    private static Ticket people;

    public static void main(String[] args) {

        Human piter = new Human("Piter", "Parker", "Bendjamin", "11.11.1990", "11.11.1999", "2222", "333333", "NY LA","piter@gmail.com", "9819998010");

        ArrayList<String> nums = piter.buyTheTicket(new Ticket("Piter", "Parker", "Bendjamin", "11.11.1990", "11.11.1999", "2222", "333333", "NY LA","piter@gmail.com", "9819998010"));

        System.out.println(nums.add(piter.buyTheTicket()));
        System.out.println(nums.get(1));




    }
}
