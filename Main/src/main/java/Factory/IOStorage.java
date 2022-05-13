package Factory;

import ObjectElement.IOElement;

public class IOStorage implements Strategy {

    Object object;

    public IOStorage(Object o) {
        object = o;
    }

    @Override
    public IOElement storage() {
        System.out.println("Запись в файл объекта: " + object.toString());
        return new IOElement(object);
    }
}
