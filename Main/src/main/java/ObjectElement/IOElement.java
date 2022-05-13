package ObjectElement;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class IOElement implements Element {

    LocalDateTime now;
    public Object object;

    public IOElement(Object o) {
        now = LocalDateTime.now();
        object = o;
    }

    @Override
    public void getTime() {
        System.out.println(object+" "+now);
    }
}
