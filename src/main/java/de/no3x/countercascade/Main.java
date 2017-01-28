package de.no3x.countercascade;

import java.util.concurrent.TimeUnit;

/**
 * Created by No3x on 22.01.2017.
 */
public class Main {

    private final Clock clock = new Clock();

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clock.tick();
                System.out.println(clock);
            }
        }).start();
    }
}
