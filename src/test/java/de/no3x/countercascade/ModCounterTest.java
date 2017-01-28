package de.no3x.countercascade;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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

    @Test
    public void discreteTests() throws Exception {
        Function<Integer, Integer> f = t -> ( (int) Math.ceil( (t+1)/60.)) % 60;

        for (int i = 0; i <= TimeUnit.MINUTES.toSeconds(1)-1; i++) {
            System.out.println(f.apply(i));
            assertThat( f.apply(i), is(0));
        }

        for (int i = 60; i <= TimeUnit.MINUTES.toSeconds(2)-1; i++) {
            assertThat( f.apply(i), is(1));
        }

        assertThat( f.apply( (int) TimeUnit.MINUTES.toSeconds(1)), is(1));
        assertThat( f.apply( (int) TimeUnit.MINUTES.toSeconds(2)), is(2));
    }
}