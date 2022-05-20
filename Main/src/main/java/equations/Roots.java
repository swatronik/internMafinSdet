package equations;

public class Roots {
    private Double x1;
    private Double x2;

    public Roots(Double x1, Double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Roots(Double x1) {
        this.x1 = x1;
    }

    @Override
    public String toString() {
        if (x2 != null) {
            return String.format("Roots: x1=%s x2 =%s", x1, x2);
        } else return String.format("Roots: x=%s", x1);
    }
}
