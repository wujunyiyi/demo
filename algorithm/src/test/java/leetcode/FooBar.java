package leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 给你一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 * <p>
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例：
 * <p>
 * 线程 A 将会调用 foo() 方法，而
 * 线程 B 将会调用 bar() 方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出："foobar"
 * 解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出："foobarfoobar"
 * 解释："foobar" 将被输出两次。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Adam Wu
 * @date 2022-06-16 10:53:24
 */
// yield + volatile
public class FooBar {
    private int n;
    private volatile boolean flag = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag) {
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = !flag;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!flag) {
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = !flag;
        }
    }
}

// synchronized+标志位
class FooBar2 {
    private int n;
    private boolean flag = false;
    private Object lock = new Object();

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (flag) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = !flag;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!flag) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = !flag;
                lock.notifyAll();
            }
        }
    }
}

// lock +condition
class FooBar3 {
    private int n;
    private boolean flag = false;

    // 公平锁
    private Lock lock = new ReentrantLock(true);
    Condition foo = lock.newCondition();
    Condition bar = lock.newCondition();

    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag) {
                    foo.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = !flag;
                bar.signal();
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!flag) {
                    bar.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = !flag;
                foo.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}

// semaphore
class FooBar4 {
    private int n;
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);


    public FooBar4(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}