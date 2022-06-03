package statePattern;

public class InProgressJob implements State{

    @Override
    public State accept() {
        return new EndedJob();
    }

    @Override
    public State cancel() {
        return new CreateJob();
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
