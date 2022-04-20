package com.company;

import java.util.concurrent.Semaphore;

public class Main {
    static int people = 20;
    static Semaphore sem = new Semaphore(2, true);
    public static void main(String[] args) {


        Timer time = new Timer();
	    Restroom1 rr1 = new Restroom1();
        Restroom2 rr2 = new Restroom2();
        Restroom3 rr3 = new Restroom3();
        Restroom4 rr4 = new Restroom4();


        Thread t1 = new Thread(time);
        Thread t2 = new Thread(rr1);
        Thread t3 = new Thread(rr2);
        Thread t4 = new Thread(rr3);
        Thread t5 = new Thread(rr4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}

class Timer implements Runnable{
    public void run(){
        for (int i = 0; i < 30; i++) {
            System.out.println(i);
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}

class Restroom1 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.people; i++) {
            try {Main.sem.acquire(1);} catch (InterruptedException e) {e.printStackTrace();}
            Main.people--;
            System.out.println("Restroom1 in use");
            try {Thread.sleep(2250);} catch (InterruptedException e) {e.printStackTrace();}
            Main.sem.release();
            System.out.println("Restroom1 Done");
        }
    }
}

class Restroom2 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.people; i++) {
            try {Main.sem.acquire(1);} catch (InterruptedException e) {e.printStackTrace();}
            Main.people--;
            System.out.println("Restroom2 in use");
            try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
            Main.sem.release();
            System.out.println("Restroom2 Done");
        }
    }
}
class Restroom3 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.people; i++) {
            try {Main.sem.acquire(1);} catch (InterruptedException e) {e.printStackTrace();}
            Main.people--;
            System.out.println("Restroom3 in use");
            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            Main.sem.release();
            System.out.println("Restroom3 Done");
        }
    }
}
class Restroom4 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.people; i++) {
            try {Main.sem.acquire();} catch (InterruptedException e) {e.printStackTrace();}
            Main.people--;
            System.out.println("Restroom4 in use");
            try {Thread.sleep(3500);} catch (InterruptedException e) {e.printStackTrace();}
            Main.sem.release();
            System.out.println("Restroom4 Done");
        }
    }
}