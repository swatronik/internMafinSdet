package equations;

public class Roots {

    public enum CountRoot {
        NO_ROOTS(0),
        ONE_ROOT(1),
        TWO_ROOTS(2);

        private final int amount;

        CountRoot(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }
    }

    private final CountRoot countRoot;

    public CountRoot getCountRoot() {
        return countRoot;
    }

    private final Double x1;
    private final Double x2;

    public Roots() {
        this.x1 = null;
        this.x2 = null;
        countRoot = CountRoot.NO_ROOTS;
    }

    public Roots(Double x1) {
        this.x1 = x1;
        this.x2 = null;
        countRoot = CountRoot.ONE_ROOT;
    }

    public Roots(Double x1, Double x2) {
        this.x1 = x1;
        this.x2 = x2;
        countRoot = CountRoot.TWO_ROOTS;
    }

    @Override
    public String toString() {

        switch (countRoot) {
            case NO_ROOTS:
                return String.format("No roots");
            case ONE_ROOT:
                return String.format("Root: x= %s", x1);
            case TWO_ROOTS:
                return String.format("Roots: x1= %s x2= %s", x1, x2);
            default:
                return "";
        }
    }
}
