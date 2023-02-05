public class Main {

    public static void main(String[] args) {
        Ticket ticket = new Ticket()
                .withFirstName("Evgeny")
                .withLastName("Malgin")
                .withCountry("Russia")
                .withGender("man")
                .withDateOfBirth("12.08.1995")
                .withMiddleName("123");

        //Ticket ticket = new Ticket("Evgeny","Malgin","man","12.08.1995",null,null);
        //Ticket ticket2 = new Ticket("Evgeny","Malgin","man","12.08.1995");
        ticket.registration();
    }
}
