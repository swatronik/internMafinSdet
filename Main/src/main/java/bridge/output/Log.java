package bridge.output;


public class Log implements Output {
    @Override
    public void log() {
        System.out.println("Output in log");
    }
}
