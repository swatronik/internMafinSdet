package equation;

public class Roots {

    public enum CountRoot {
        NO_ROOTS(0), ONE_ROOT(1), TWO_ROOTS(2);

        private final int amount;

        private CountRoot(int amount) {
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


    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

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

    //солюшен это this - obj это то что передаем, с чем сравниваем (руутс)
    @Override
    public boolean equals(Object obj) {
        Roots roots = (Roots) obj;

        if (this.countRoot == null) return false;

        if (!this.countRoot.equals(roots.countRoot)) return false;

        if (this.countRoot.equals(CountRoot.NO_ROOTS)) return true;

        if (this.countRoot.equals(CountRoot.ONE_ROOT) && this.x1.equals(roots.x1)) return true;

        if (this.countRoot.equals(CountRoot.TWO_ROOTS) && ((this.x1.equals(roots.x1)) && (this.x2.equals(roots.x2))) || (this.x2.equals(roots.x1) && this.x1.equals(roots.x2)))
            return true;

        return false;
    }

    @Override
    public String toString() {
        switch (countRoot) {
            case NO_ROOTS:
                return String.format("NO_ROOTS");
            case ONE_ROOT:
                return String.format("root = %.2f", x1);
            case TWO_ROOTS:
                return String.format("root 1 = %.2f , root 2 = %.2f", x1, x2);
            default:
                return "default";
        }
    }
}