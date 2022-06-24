import example_buy_ticket.*;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        Human piter = new Human("Piter", "Parker", "Bendjamin", 21, "01.01.2001", new ArrayList<Ticket>());
        Human piter2 = new Human("Piter", "Parker", "Bendjamin", 21, new ArrayList<Ticket>());
        Human piter3 = new Human("Piter", "Parker", "Bendjamin", "01.01.2001",  new ArrayList<Ticket>());

        TicketHuman human = new BuilderHuman()
                .withFirst_name("Piter")
                .withLast_name("Parker")
                .withMiddle_name("Bendjamin")
                .withDayBirthday("01.01.2001")
                .withSite(5)
                .build();


        CreateTableHuman createTableHuman = new CreateTableHuman();
        createTableHuman.create(human);




        System.out.println(piter.buyTheTicket("Sochi"));
        System.out.println(piter.buyTheTicket("Moscow"));
        System.out.println(piter.getList());



    }
}
