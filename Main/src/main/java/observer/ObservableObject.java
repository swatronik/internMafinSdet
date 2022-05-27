package observer;

import java.util.ArrayList;

public class ObservableObject implements Observable{

    private ArrayList<Observe> massObserv = new ArrayList<>();

    @Override
    public void registr(Observe observe) {
        massObserv.add(observe);
        System.out.println("Observ was add");
    }

    @Override
    public void remove(Observe observe) {
        massObserv.remove(observe);
        System.out.println("Observ was delete");
    }

    @Override
    public void notifyObserv(String str) {
        for(Observe observe: massObserv){
            observe.update(str);
        }
        System.out.println("Observ was update");
    }

    @Override
    public void deleteAllObject() {
        for(Observe observe: massObserv){
            remove(observe);
        }
    }
}
