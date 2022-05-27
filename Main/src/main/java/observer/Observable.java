package observer;

public interface Observable {

    public void registr(Observe observe);

    public void remove(Observe observe);

    public void notifyObserv(String str);

    public void deleteAllObject();
}
