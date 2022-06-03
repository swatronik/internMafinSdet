package statePattern;

public interface State {

    public State accept();
    public State cancel();
    public State denide();
    public void toLog();
}
