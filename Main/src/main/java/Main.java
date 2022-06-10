import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static long time = System.currentTimeMillis();

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static int method(int threatNumber) {
        try {
            Thread.sleep((long) (Math.random()*1000+1000));
            long countIter = 1000;
            while (true) {
                int i = atomicInteger.get();
                if (atomicInteger.get() == 1) {
                    return i;
                } else {
                    Thread.sleep(10);
                }
                if (countIter > 0) {
                    countIter--;
                } else {
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i=1; i<40; i++){
            int finalI = i;
            Runnable task = () -> {
                System.out.println("Task "+ finalI +": " + method(finalI));
                System.out.println(System.currentTimeMillis() - time);
            };
            threads.add(new Thread(task));
        }

        for(Thread thread: threads){
            thread.start();
        }
        System.out.println(System.currentTimeMillis() - time);

    }

}
