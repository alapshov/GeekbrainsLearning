import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    private CyclicBarrier cyclicBarrier;
    private CountDownLatch countDownLatch;

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public Race(CountDownLatch countDownLatch, CyclicBarrier cyclicBarrier, Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatch = countDownLatch;
    }
}