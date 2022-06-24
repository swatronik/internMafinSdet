package example_buy_ticket;

import java.util.ArrayList;

public class TicketHuman {

    public String last_name;
    public String first_name;
    public String middle_name;
    public Integer age;
    public BuilderHuman.SEX sex;
    public String dayBirthday;

    protected TicketHuman(String last_name, String first_name, String middle_name, Integer age, BuilderHuman.SEX sex, String dayBirthday) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.age = age;
        this.sex = sex;
        this.dayBirthday = dayBirthday;
    }
}
