package de.no3x.countercascade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by No3x on 22.01.2017.
 */
@ExtendWith(MockitoExtension.class)
class LinkedModCounterTest {

    private LinkedModCounter linkedModCounter;
    
    @Mock
    private LinkedModCounter nextModCounter;

    @BeforeEach
    public void setUp() {
        linkedModCounter = new LinkedModCounter(60, nextModCounter);
    }

    @Test
    void increment_withoutOverflowWithNext_doesNotNextIncrement() {
        assertThat(linkedModCounter.getCount()).isZero();

        linkedModCounter.increment();

        verify(nextModCounter, never()).increment();
    }

    @Test
    void increment_withoutOverflowWithoutNext_doesNotNextIncrement() {
        linkedModCounter = new LinkedModCounter(60, null);
        assertThat(linkedModCounter.getCount()).isZero();

        linkedModCounter.increment();

        verify(nextModCounter, never()).increment();
    }

    @Test
    void increment_withOverflowWithoutNext_doesNotNextIncrement() {
        assertThat(linkedModCounter.getCount()).isZero();
        linkedModCounter = new LinkedModCounter(60, null);

        for (int i = 0; i < TimeUnit.MINUTES.toSeconds(1); i++) {
            linkedModCounter.increment();
        }
        linkedModCounter.increment();

        verify(nextModCounter, never()).increment();
    }

    @Test
    void increment_withOverflowWithNext_doesIncrement() {
        assertThat(linkedModCounter.getCount()).isZero();

        for (int i = 0; i < TimeUnit.MINUTES.toSeconds(1); i++) {
            linkedModCounter.increment();
        }

        assertThat(linkedModCounter.getCount()).isZero();
        verify(nextModCounter, only()).increment();
    }

}