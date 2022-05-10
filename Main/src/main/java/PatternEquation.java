import equation.Equation;
import exception.ExceptionMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternEquation {

    public static final String patternEquation = "((((-|\\+)?)([\\d]+|)x\\^2)(((-|\\+){1}([\\d]+|))x)((-|\\+){1}[\\d]+)=0){1,}";

    //Equation - возвращаем экземпляр Equation
    public static Equation getEquation(String eq) throws ExceptionMessage {

        Pattern pattern = Pattern.compile(patternEquation);
        Matcher matcher = pattern.matcher(eq);

        //matches() - определяет, совпадает уравнение или нет
        if (matcher.matches()) {

            double a;
            double b;
            double c;

            System.out.println("вытаскиваем коэфициенты по группам. a b c");

            a = Double.parseDouble(matcher.group(5));
            b = Double.parseDouble(matcher.group(7));
            c = Double.parseDouble(matcher.group(10));

            Main.logger.info("Введенное уравнение проходит проверку шаблона регулярки - ок");

            return new Equation(a, b, c);

        } else {
            throw new ExceptionMessage("не совпадает");
        }
    }
}

//x^2+2x+1=0
//x^2+x+1=0
//
//4x^2+0x+1=0
//-4x^2+2x+1=0
//4x^2+2x+1=0
//-4x^2-2x-1=0
//44x^2+2x+1=0
//111x^2-222x-333=0
//111x^2+222x+333=0
//
//{1,}-не менее 1 раза.
//+ -один или более
//? - ноль или одно
//*-ноль или более