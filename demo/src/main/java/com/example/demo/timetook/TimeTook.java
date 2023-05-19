package com.example.demo.timetook;

public class TimeTook {
    public void showTime(int count, Runnable r) {
        long firstTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            r.run();
        }
        long secondTime = System.currentTimeMillis();

        System.out.println(String.format("First : %d, Second : %d\ndiff : %d\navg : %f", firstTime, secondTime, secondTime - firstTime, (float)(secondTime - firstTime) / count));
    }
}
