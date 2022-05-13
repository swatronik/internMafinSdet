package Factory;

import ObjectElement.DBElement;

public class DBStorage implements Strategy {

    Object object;

    public DBStorage(Object o) {
        object = o;
    }

    @Override
    public DBElement storage() {
        System.out.println("Запись в базу данных объекта: " + object.toString());
        return new DBElement(object);
    }
}
