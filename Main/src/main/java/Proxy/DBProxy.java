package Proxy;

public class DBProxy implements ProxyInterface {

    DBController dbController;

    @Override
    public void select() {
        lazyInit();
        dbController.select();
    }

    @Override
    public void update() {
        lazyInit();
        dbController.update();
        System.out.println("Proxy update");
    }

    @Override
    public void delete() {
        System.out.println("Proxy delete");
    }

    private void lazyInit(){
        if (dbController == null) {
            dbController = new DBController();
        }
    }
}
