import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyClass2 {

    private Map<String, Function> map;

    public MyClass2(){
        Function <Integer, Double> function = x -> 1.0/x;
        Function <Double , Double> function2 = x -> x*x*x;

        map = new HashMap<>();

        map.put("java.lang.Integer", function);
        map.put("java.lang.Double", function2);
    }

    public Double funcInter(Object k) {
        MyClass myClass = new MyClass();

        return (Double) myClass.func(k, map.get(k.getClass().getName()));
    }
}
