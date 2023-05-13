package de.no3x.countercascade;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by No3x on 22.01.2017.
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private final Clock clock = new Clock();

    public static void main(String[] args) {
        new Main().run();
    }

    private void task() {
        clock.tick();
        LOGGER.log(INFO, "clock: {0}", clock);
    }

    public void run() {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> future = executorService.scheduleAtFixedRate(this::task, 0, 1, TimeUnit.SECONDS);
        LOGGER.log(INFO, "future: {0}", future);
    }
}
