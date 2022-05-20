package equations;

public class Roots {

    public enum CountRoot {
        NO_ROOTS(0),
        ONE_ROOT(1),
        TWO_ROOTS(2);

        CountRoot(int amount) {
        }
    }

    private CountRoot countRoot;

    public CountRoot getCountRoot() {
        return countRoot;
    }

    private Double x1;
    private Double x2;

    public Roots(Double x1, Double x2) {
        this.x1 = x1;
        this.x2 = x2;
        countRoot = CountRoot.TWO_ROOTS;
    }

    public Roots(Double x1) {
        this.x1 = x1;
        countRoot = CountRoot.ONE_ROOT;
    }

    public Roots() {
        countRoot = CountRoot.NO_ROOTS;
    }

    @Override
    public String toString() {
        if (countRoot == CountRoot.TWO_ROOTS) {
            return String.format("Roots: x1=%s x2 =%s", x1, x2);
        } else if ((countRoot == CountRoot.ONE_ROOT)) return String.format("Root: x=%s", x1);
        else return String.format("No roots");
    }
}
