package com.playground.concurrent;

public class TT implements Runnable {
    int b = 100;

    public synchronized void m1() throws Exception {
        b = 1000;
        Thread.sleep(5000);
        System.out.println("b = " + b + Thread.currentThread().getName());
    }

    public void m2() throws Exception {
        Thread.sleep(2500);
        b = 2000;
        System.out.println("b = " + b + Thread.currentThread().getName());
    }

    public void run() {
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        TT tt = new TT();
        Thread t = new Thread(tt);
        t.start();
        tt.m2();
        System.out.println(tt.b);
    }
}