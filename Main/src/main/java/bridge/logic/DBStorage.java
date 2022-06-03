package bridge.logic;

public class DBStorage implements Storage {
    @Override
    public void store(String name) {
        System.out.println("Person " + name + " store in DB");
    }
}
