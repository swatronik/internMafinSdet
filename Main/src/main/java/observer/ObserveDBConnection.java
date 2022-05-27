package observer;

public class ObserveDBConnection implements Observe{


    @Override
    public void update(String str) {
        System.out.println("Update Data Base Connection: " + str);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().equals(ObserveDBConnection.class);
    }

    @Override
    public int hashCode() {
        return 2;
    }
}
