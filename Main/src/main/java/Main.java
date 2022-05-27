
import Proxy.DBController;
import Proxy.DBProxy;
import Proxy.ProxyInterface;
import observer.*;

public class Main {

    public static Observable observableObject = new ObservableObject();

    public static void main(String[] args) throws InterruptedException {

        /*
        Observable observableObject = new ObservableObject();

        observableObject.registr(new ObserveDBConnection());
        observableObject.registr(new ObserveFileConnection());


        while (true) {
            Thread.sleep(10000);
            observableObject.notifyObserv("password");
            observableObject.deleteAllObject();
        }
        */
        ProxyInterface dbController;
        if ("test".equals("test")){
            dbController = new DBProxy();
        } else {
            dbController = new DBController();
        }


        dbController.select();
        dbController.delete();
        dbController.update();
        dbController.select();

    }

}
