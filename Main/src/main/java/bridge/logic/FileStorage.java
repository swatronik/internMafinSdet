package bridge.logic;

public class FileStorage implements Storage {
    @Override
    public void store(String name) {
        System.out.println("Person " + name + " store in File");
    }
}
