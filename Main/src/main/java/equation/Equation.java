package equation;

public class Equation {

    private final Double a;
    private final Double b;
    private final Double c;

    public Equation(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }

    public Double getC() {
        return c;
    }

    @Override
    public String toString() {
        return String.format("%sx^2%sx%s=0", a, (b < 0 ? b : "+" + b), (c < 0 ? c : "+" + c));
    }
}
