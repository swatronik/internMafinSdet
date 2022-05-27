package Proxy;

public class DBController implements ProxyInterface {

    public DBController(){
        System.out.println("Create Real DB Connection");
    }

    @Override
    public void select(){
        System.out.println("Real Select DB");
    }

    @Override
    public void update(){
        System.out.println("Real Update DB");
    }

    @Override
    public void delete(){
        System.out.println("Real Delete DB");
    }
}
