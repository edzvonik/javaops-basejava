package com.dzvonik.webapp;

public class MainConcurrency {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("New thread is start!");
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();
        System.out.println(thread1.getName());
    }

}
