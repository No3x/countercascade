package de.no3x.countercascade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

/**
 * Created by noex_ on 22.01.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class LinkedModCounterTest {

    @Mock
    private LinkedModCounter nextModCounter;
    private LinkedModCounter linkedModCounter;

    @Before
    public void setUp() {
        linkedModCounter = new LinkedModCounter(60, nextModCounter);
    }

    @Test
    public void incrementWithoutOverflow() throws Exception {
        Assert.assertThat( linkedModCounter.getCount(), is(0));
        linkedModCounter.increment();
        verify(nextModCounter, never()).increment();
    }

    @Test
    public void incrementWithOverflowWithoutNext() throws Exception {
        Assert.assertThat( linkedModCounter.getCount(), is(0));
        linkedModCounter = new LinkedModCounter(60, null);
        linkedModCounter.increment();
        verify(nextModCounter, never()).increment();
    }

    @Test
    public void incrementWithOverflow() throws Exception {

        Assert.assertThat( linkedModCounter.getCount(), is(0));
        for (int i = 0; i < TimeUnit.MINUTES.toSeconds(1); i++) {
            linkedModCounter.increment();
        }
        verify(nextModCounter, only()).increment();

    }

}