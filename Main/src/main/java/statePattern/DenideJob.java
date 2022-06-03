package statePattern;

public class DenideJob implements State{
    @Override
    public State accept() {
        return this;
    }

    @Override
    public State cancel() {
        return this;
    }

    @Override
    public State denide() {
        return this;
    }

    @Override
    public void toLog() {
        System.out.println(this.getClass());
    }
}
