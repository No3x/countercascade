package de.no3x.countercascade;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by noex_ on 22.01.2017.
 */
public class CounterTest {

    private Counter counter = new Counter();

    @Test
    public void increment() throws Exception {
        Assert.assertThat(counter.getCount(), is(0));
        counter.increment();
        counter.increment();
        Assert.assertThat(counter.getCount(), is(2));
    }

    @Test
    public void decrement() throws Exception {
        Assert.assertThat(counter.getCount(), is(0));
        counter.decrement();
        counter.decrement();
        Assert.assertThat(counter.getCount(), is(-2));
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertThat(counter.toString(), is("0"));
    }
}