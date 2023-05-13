package de.no3x.countercascade;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by No3x on 21.01.2017.
 */
@ExtendWith(MockitoExtension.class)
class ModCounterTest {

    private final ModCounter modCounter = new ModCounter(3);

    @Test
    void increment() {
        assertThat(modCounter.getCount()).isZero();
        modCounter.increment();
        assertThat(modCounter.getCount()).isOne();
        modCounter.increment();
        assertThat(modCounter.getCount()).isEqualTo(2);
        modCounter.increment();
        assertThat(modCounter.getCount()).isZero();
    }

    @Test
    void decrement() {
        assertThat(modCounter.getCount()).isZero();
        assertThat(modCounter.decrement()).isZero();
        assertThat(modCounter.getCount()).isEqualTo(2);
        modCounter.decrement();
        assertThat(modCounter.getCount()).isOne();
        modCounter.decrement();
        assertThat(modCounter.getCount()).isZero();
    }

    @Test
    void discreteTests() {
        Function<Integer, Integer> f = t -> (int) Math.floor(t / 60.) % 60;
        for (int i = 0; i <= TimeUnit.MINUTES.toSeconds(1) - 1; i++) {
            System.out.println(f.apply(i));
            assertThat(f.apply(i)).isZero();
        }

        for (int i = 60; i <= TimeUnit.MINUTES.toSeconds(2) - 1; i++) {
            assertThat(f.apply(i)).isOne();
        }

        assertThat(f.apply((int) TimeUnit.MINUTES.toSeconds(1))).isOne();
        assertThat(f.apply((int) TimeUnit.MINUTES.toSeconds(2))).isEqualTo(2);
    }
}