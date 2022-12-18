import Protect.ProtectClass;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /**
     * 1. Убрать 5 самых больших значений (Учитывая повторы).
     * 2. Убрать дублирующиеся элементы.
     * 3. Убрать все чётные значения.
     * 4. Получить все элементы единой строкой через запятую.
     * <p>
     * Все операции должны проходить в рамках одного стрима.
     */
    public static void main(String[] args) throws IOException {
        final var objects = generateObjects();

        System.out.println(objects.stream()
                .flatMap(Collection::stream)
                .map(x->(Integer) x)
                .sorted(Comparator.reverseOrder())
                .skip(5)
                .distinct()
                .filter(x -> x % 2 == 1)
                .map(Object::toString)
                .collect(Collectors.joining(",")));
    }

    private static List<List<Object>> generateObjects() {
        final var objects = new ArrayList<List<Object>>();
        final var random = new Random();
        final var arrays = random.nextInt(5) + 3;
        for (var i = 0; i < arrays; i++) {
            final var elements = random.nextInt(20) + 5;
            final var list = new ArrayList<>();
            for (var j = 0; j < elements; j++) {
                list.add(random.nextInt(1000));
            }
            objects.add(list);
        }
        return objects;
    }
}
