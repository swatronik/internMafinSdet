public class MyClass3 {

    private Double sqr(Integer k) {
        return Double.parseDouble(String.valueOf(k*k));
    }

    private Double sqrt(Integer k) {
        return Math.sqrt(k);
    }

    public Double run(){
        Double var = this.func(this::sqrt, 5);
        return var;
    }

    public Double func(Function<Integer, Double> function, Integer k) {
        Double apply = function.apply(k);
        System.out.println(apply);
        return apply;
    }
}
