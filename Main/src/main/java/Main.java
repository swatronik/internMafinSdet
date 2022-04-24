

import org.apache.commons.cli.ParseException;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) throws ParseException {

        ParserArgument parserArgument = new ParserArgument(args);

        double discriminant = parserArgument.getA() * parserArgument.getB() - 4 * parserArgument.getA() * parserArgument.getC();
        System.out.println("discriminant = " + discriminant);

        if (discriminant == 0) {

            System.out.println("discriminant = 0, get one root");
            double x = -parserArgument.getB() / (2 * parserArgument.getA());
            System.out.println("root =  " + x);
        } else if (discriminant > 0) {
            System.out.println("discriminant is positive, get two roots");
            double x1 = (-parserArgument.getB() + sqrt(discriminant)) / (2 * parserArgument.getA());
            double x2 = (-parserArgument.getB() - sqrt(discriminant)) / (2 * parserArgument.getA());
            System.out.println("root 1 = " + x1);
            System.out.println("root 2 = " + x2);
        } else
            System.out.println("discriminant is negative, no roots");
    }
}
