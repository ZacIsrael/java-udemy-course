package com.zacisrael;

import static com.zacisrael.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hell from MyRunnable's implementation of run()");
    }
}
