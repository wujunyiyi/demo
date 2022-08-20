package leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author Adam Wu
 * @date 2022-06-20 13:47:04
 */
public class FizzBuzz {

    /**
     * 利用AtomicInteger
     */
    private int n;

    private AtomicInteger acc = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int i;
        while ((i = acc.get()) <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
                acc.incrementAndGet();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int i;
        while ((i = acc.get()) <= n) {
            if (i % 3 != 0 && i % 5 == 0) {
                printBuzz.run();
                acc.incrementAndGet();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int i;
        while ((i = acc.get()) <= n) {
            if (i % 3 == 0 && i % 5 == 0) {
                printFizzBuzz.run();
                acc.incrementAndGet();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        int i;
        while ((i = acc.get()) <= n) {
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                acc.incrementAndGet();
            }
        }
    }
}

// 无锁 volatile
class FizzBuzz1 {

    /**
     * 利用volatile
     */
    private int n;

    private volatile int acc = 1;

    public FizzBuzz1(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (acc <= n) {
            if (acc % 3 == 0 && acc % 5 != 0) {
                printFizz.run();
                acc++;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (acc <= n) {
            if (acc % 3 != 0 && acc % 5 == 0) {
                printBuzz.run();
                acc++;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (acc <= n) {
            if (acc % 3 == 0 && acc % 5 == 0) {
                printFizzBuzz.run();
                acc++;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (acc <= n) {
            if (acc % 3 != 0 && acc % 5 != 0) {
                printNumber.accept(acc);
                acc++;
            }
        }
    }
}
