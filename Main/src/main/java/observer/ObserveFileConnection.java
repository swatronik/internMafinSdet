package observer;

public class ObserveFileConnection implements Observe{


    @Override
    public void update(String str) {
        System.out.println("Update File Connection: " + str);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().equals(ObserveDBConnection.class);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}