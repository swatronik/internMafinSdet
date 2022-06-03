package statePattern;

public class EndedJob implements State{
    @Override
    public State accept() {
        return new EndedJob();
    }

    @Override
    public State cancel() {
        return new EndedJob();
    }

    @Override
    public State denide() {
        return new DenideJob();
    }

    @Override
    public void toLog() {
        System.out.println(this.getClass());
    }
}
