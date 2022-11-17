package com.study.java_study.thread;

import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class Interview {

    private static Integer count = 0;
    private static ReentrantLock reentrantLock = new ReentrantLock();

    /**
     * 题目：三个线程以此打印ABC
     */
    public static void main(String[] args) {
        Condition printACondition = reentrantLock.newCondition();
        Condition printBCondition = reentrantLock.newCondition();
        Condition printCCondition = reentrantLock.newCondition();

        Thread t1 = new Thread(() -> {
            while (true) {
                reentrantLock.lock();
                if (count + 1 <= 100) {
                    System.out.println("A");
                    count++;
                }
                printBCondition.signal();
                try {
                    printACondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                reentrantLock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                reentrantLock.lock();
                if (count + 1 <= 100) {
                    System.out.println("B");
                    count++;
                }
                printCCondition.signal();
                try {
                    printBCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                reentrantLock.unlock();
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                reentrantLock.lock();
                if (count + 1 <= 100) {
                    System.out.println("C");
                    count++;
                }
                printACondition.signal();
                try {
                    printCCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                reentrantLock.unlock();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
