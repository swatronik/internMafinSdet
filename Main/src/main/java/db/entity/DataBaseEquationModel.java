package db.entity;

public class DataBaseEquationModel {
    public Integer number;
    public String quadratic;
    public String date;
    public String roots;

    public DataBaseEquationModel(Integer number, String quadratic, String date, String roots) {
        this.number = number;
        this.quadratic = quadratic;
        this.date = date;
        this.roots = roots;
    }

    public DataBaseEquationModel() {
    }
}
