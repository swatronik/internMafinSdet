package statePattern;

public class CreateJob implements State{

    @Override
    public State accept() {
        return new InProgressJob();
    }

    @Override
    public State cancel() {
        return this;
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
