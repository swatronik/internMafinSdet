import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) throws IOException {
        String a = "0", b = "0", c = "0";
        if(args.length > 0){
            for (int i = 0; i < args.length - 1; i++){
               if(args[i].contains("a")){
                    a = args[i+1].toString();
               }
               else if(args[i].contains("b")){
                    b = args[i+1].toString();
               }
               else if(args[i].contains("c")){
                    c = args[i+1].toString();
               }
            }
        }
        else {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("Enter a from aX^2 + bX + c = 0");
             a = reader.readLine();
            System.out.println(a + " is a-factor");

            System.out.println("Enter b from aX^2 + bX + c = 0");
             b = reader.readLine();
            System.out.println(b + " is b-factor");

            System.out.println("Enter c from aX^2 + bX + c = 0");
             c = reader.readLine();
            System.out.println(c + " is c-factor");
        }

        try {
            Float aFactor = Float.parseFloat(a);
            Float bFactor = Float.parseFloat(b);
            Float cFactor = Float.parseFloat(c);

            Float D = bFactor*bFactor - 4*aFactor*cFactor;

            if(D < 0) {
                System.out.println("There is no solution!");
            }
            else if (D==0) {
            Float Result = -1*bFactor/(2*aFactor);
                System.out.println(Result);
            }
            else if (D>0){
                double Result1 = (-1*bFactor+sqrt(D))/(2*aFactor);
                double Result2 = (-1*bFactor-sqrt(D))/(2*aFactor);
                System.out.println("Result 1 is: " +  Result1 + " Result 2 is: " + Result2);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
