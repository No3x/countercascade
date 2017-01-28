package de.no3x.countercascade;

/**
 * Created by No3x on 21.01.2017.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Simple Counter that stores the count value.
 */
public class Counter {
    private AtomicInteger count = new AtomicInteger(0);

    public int increment() {
        return count.incrementAndGet();
    }

    public int decrement() {
        return count.decrementAndGet();
    }

    public int set(int count) {
        return this.count.getAndSet(count);
    }

    public int getCount() {
        return count.get();
    }

    @Override
    public String toString() {
        return "" + getCount();
    }
}
