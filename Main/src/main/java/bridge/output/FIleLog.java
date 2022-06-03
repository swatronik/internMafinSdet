package bridge.output;

public class FIleLog implements Output {
    @Override
    public void log() {
        System.out.println("Output in file");
    }
}
