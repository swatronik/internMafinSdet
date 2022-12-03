public class Roots {
    private Double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = getX1();
        this.x2 = getX2();
    }

    public Roots(double x) {
        this.x1 = x;
        this.x2 = null;
    }

    public Roots() {
        this.x1 = null;
        this.x2 = null;
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }
}
