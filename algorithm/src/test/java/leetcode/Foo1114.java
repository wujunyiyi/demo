package leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * @author Adam Wu
 * @date 2022-06-15 10:00:47
 */
public class Foo1114 {
    CountDownLatch cs = new CountDownLatch(1);
    CountDownLatch ct = new CountDownLatch(1);

    public Foo1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        cs.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        cs.await();
        printSecond.run();
        ct.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        ct.await();
        printThird.run();
    }
}
