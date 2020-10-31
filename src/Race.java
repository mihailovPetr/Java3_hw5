import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    private ArrayList<Stage> stages;
    private boolean somebodyFinished = false;
    private Lock somebodyFinishedLock = new ReentrantLock();

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public void iAmFinish(Car car) {
        somebodyFinishedLock.lock();

        if (!somebodyFinished) {
            somebodyFinished = true;
            System.out.println("\n" + car.getName() + " WIN\n");
        } else {
            System.out.println(car.getName() + " завершил гонку");
        }

        somebodyFinishedLock.unlock();
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
