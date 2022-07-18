import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        MyClass myClass = new MyClass();

        Function <Integer, Double> function = x -> 1.0/x;
        Function <Double , Double> function2 = x -> x*x*x;

        ArrayList<String> arrayList = new ArrayList<>();

        String[] objects = (String[]) arrayList.stream().filter(x -> x.length() > 10).toArray();

        Integer k1 = 10;
        Double k2 = 10.5;

        Object kUnknown = k1;

        if(kUnknown instanceof Integer) {
            System.out.println(myClass.func(10, function));
        }
        if (kUnknown instanceof Double) {
            System.out.println(myClass.func(10.5, function2));
        }
    }

}
