package example_buy_ticket;

public class Ticket {

    private String last_name;
    private String first_name;
    private String middle_name;
    private String direction;

    public Ticket(String last_name, String first_name, String middle_name,String direction) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.direction=direction;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
