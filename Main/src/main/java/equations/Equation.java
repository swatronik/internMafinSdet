package equations;

public class Equation {

    private final double a;
    private final double b;
    private final double c;

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(a).append("*x^2");

        if (b > 0) stringBuilder.append("+").append(b).append("*x");
        else if (b == 0) stringBuilder.append(" ");
        else if (b < 0) stringBuilder.append(b).append("*x");

        if (c == 0) stringBuilder.append(" ");
        else if (c < 0) stringBuilder.append(c);
        else if (c > 0) stringBuilder.append("+").append(c);

        stringBuilder.append("=0");

        return stringBuilder.toString();
    }

}
