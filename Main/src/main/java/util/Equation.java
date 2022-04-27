package util;

public class Equation {

    private double a = 0.0;
    private double b = 0.0;
    private double c = 0.0;

    String signB = "";
    String signC = "";

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

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        if (b > 0)
            signB = "+";
        if (c > 0)
            signC = "+";
        return String.format("%f x^2 %s %f x %s %f = 0", a, signB, b, signC, c);
    }

}
