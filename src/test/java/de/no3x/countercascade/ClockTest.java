package de.no3x.countercascade;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by No3x on 21.01.2017.
 */
@ExtendWith(MockitoExtension.class)
class ClockTest {

    private final Clock clock = new Clock();

    @Test
    void tick() {
        assertThat(clock.getSeconds()).isZero();
        assertThat(clock.getMinutes()).isZero();
        assertThat(clock.getHours()).isZero();
        for (int i = 0; i < TimeUnit.MINUTES.toSeconds(1); i++) {
            clock.tick();
        }
        assertThat(clock.getSeconds()).isZero();
        assertThat(clock.getMinutes()).isOne();
        assertThat(clock.getHours()).isZero();

        for (int i = 0; i < TimeUnit.MINUTES.toSeconds(59); i++) {
            clock.tick();
        }
        assertThat(clock.getSeconds()).isZero();
        assertThat(clock.getMinutes()).isZero();
        assertThat(clock.getHours()).isOne();
    }

    @Test
    void testToString() {
        assertThat(clock).hasToString("Clock{seconds=0, minutes=0, hours=0}");
    }
}