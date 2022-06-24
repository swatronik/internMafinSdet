package example_buy_ticket;

public class BuilderHuman {

    public enum SEX{
        MAN,
        WOMAN;
    }

    public String last_name;
    public String first_name;
    public String middle_name;
    public Integer age;
    public SEX sex;
    public String dayBirthday;
    public Integer site;

    public boolean isContainLast_name() {
        return last_name != null && !last_name.isEmpty() && last_name.length()>3 && last_name.length()<10;
    }

    public boolean isContainFirst_name() {
        return first_name != null && !first_name.isEmpty();
    }

    public boolean isContainMiddle_name() {
        return middle_name != null && !middle_name.isEmpty();
    }

    public boolean isContainAge() {
        return age != null && !(age > 0);
    }

    public boolean isContainSex() {
        return sex != null;
    }

    public boolean isContainSite() {
        return site != null && site >= 0;
    }

    public boolean isContainDayBirthday() {
        return dayBirthday != null && !dayBirthday.isEmpty();
    }

    public BuilderHuman withLast_name (String value) {
        this.last_name = value;
        return this;
    }

    public BuilderHuman withFirst_name (String value) {
        this.first_name = value;
        return this;
    }

    public BuilderHuman withMiddle_name (String value) {
        this.middle_name = value;
        return this;
    }

    public BuilderHuman withAge (Integer value) {
        this.age = value;
        return this;
    }

    public BuilderHuman withSex (SEX value) {
        this.sex = value;
        return this;
    }

    public BuilderHuman withDayBirthday (String value) {
        this.dayBirthday = value;
        return this;
    }

    public BuilderHuman withSite (Integer value) {
        this.site = value;
        return this;
    }

    public TicketHuman build(){
        if (!this.isContainFirst_name()){
            System.out.println("ERROR");
        }

        if (!this.isContainLast_name()){
            System.out.println("ERROR");
        }

        if (!this.isContainMiddle_name()){
            throw new IllegalArgumentException("Human must have middleName");
        }

        if (!this.isContainSite()){
            throw new IllegalArgumentException("Human must have site");
        }
        return new TicketHuman(last_name, first_name, middle_name, age, sex, dayBirthday);
    }

}
