package de.no3x.countercascade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by No3x on 22.01.2017.
 */
@ExtendWith(MockitoExtension.class)
class CounterTest {

    private final Counter counter = new Counter();

    @Test
    void increment() {
        assertThat(counter.getCount()).isZero();
        counter.increment();
        counter.increment();
        assertThat(counter.getCount()).isEqualTo(2);
    }

    @Test
    void decrement() {
        assertThat(counter.getCount()).isZero();
        counter.decrement();
        counter.decrement();
        assertThat(counter.getCount()).isEqualTo(-2);
    }

    @Test
    void set() {
        assertThat(counter.getCount()).isZero();
        assertThat(counter.set(1)).isZero();
        assertThat(counter.set(2)).isOne();
        assertThat(counter.getCount()).isEqualTo(2);
    }

    @Test
    void testToString() {
        assertThat(counter).hasToString("0");
    }
}