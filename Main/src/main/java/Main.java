import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        MyClass2 myClass2 = new MyClass2();

        System.out.println(myClass2.funcInter(10.5));

        MyClass3 myClass3 = new MyClass3();
        myClass3.run();

        ArrayList<Integer> arrayList = new ArrayList<>();

        Object[] objects = arrayList.stream().filter(x -> x > 5).toArray();

    }

}
