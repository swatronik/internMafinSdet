public class MyClass {

    public <T, U> U func(T x, Function<T, U> function){
        return function.apply(x);
    }
}
