package de.no3x.countercascade;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by noex_ on 21.01.2017.
 */
public class ModCounterTest {

    private ModCounter modCounter = new ModCounter(3);

    @Test
    public void increment() throws Exception {
        assertThat( modCounter.getCount(), is(0) );
        modCounter.increment();
        assertThat( modCounter.getCount(), is(1) );
        modCounter.increment();
        assertThat( modCounter.getCount(), is(2) );
        modCounter.increment();
        assertThat( modCounter.getCount(), is(0) );
    }

    @Test
    public void decrement() throws Exception {
        assertThat( modCounter.getCount(), is(0) );
        modCounter.decrement();
        assertThat( modCounter.getCount(), is(2) );
        modCounter.decrement();
        assertThat( modCounter.getCount(), is(1) );
        modCounter.decrement();
        assertThat( modCounter.getCount(), is(0) );
    }
}