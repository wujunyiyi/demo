package leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Adam Wu
 * @date 2022-06-21 17:17:28
 */
// 串行
public class DiningPhilosophers {
    Semaphore[] semaphores = new Semaphore[]{
            new Semaphore(1),
            new Semaphore(0),
            new Semaphore(0),
            new Semaphore(0),
            new Semaphore(0)};

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        semaphores[philosopher % 5].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        semaphores[(philosopher + 1) % 5].release(1);
    }
}

class DiningPhilosophers1 {
    Lock lock = new ReentrantLock();

    Condition[] conditions = new Condition[]{
            lock.newCondition(),
            lock.newCondition(),
            lock.newCondition(),
            lock.newCondition(),
            lock.newCondition()};

    public DiningPhilosophers1() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
    }
}
