import Factory.DBStorage;
import Factory.IOStorage;
import Factory.Strategy;
import ObjectElement.DBElement;
import ObjectElement.Element;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

       ArrayList<Strategy> poolStorage = new ArrayList<>();
       poolStorage.add(new DBStorage("12345"));
       poolStorage.add(new IOStorage(new Boolean(true)));
       poolStorage.add(new DBStorage(new Integer(4)));
       poolStorage.add(new IOStorage(new Double(10.5)));


       ArrayList<Element> storageElement = new ArrayList<>();

       for(Strategy strategy: poolStorage){
           Element storage = strategy.storage();
           storageElement.add(storage);
           Thread.sleep(1000);
       }

        for(Element element: storageElement){
            if (element instanceof DBElement) {
                DBElement dbElement = (DBElement) element;
                Object object = dbElement.object;
            }
            element.getTime();
        }
    }

}
