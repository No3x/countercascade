package de.no3x.countercascade;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

/**
 * Created by noex_ on 21.01.2017.
 */
public class ClockTest {

    private Clock clock = new Clock();

    @Test
    public void tick() throws Exception {
        Assert.assertThat(clock.getSeconds(), is(0));
        Assert.assertThat(clock.getMinutes(), is(0));
        Assert.assertThat(clock.getHours(), is(0));
        for (int i = 0; i < TimeUnit.MINUTES.toSeconds(1); i++) {
            clock.tick();
        }
        Assert.assertThat(clock.getSeconds(), is(0));
        Assert.assertThat(clock.getMinutes(), is(1));
        Assert.assertThat(clock.getHours(), is(0));

        for (int i = 0; i < TimeUnit.MINUTES.toSeconds(59); i++) {
            clock.tick();
        }
        Assert.assertThat(clock.getSeconds(), is(0));
        Assert.assertThat(clock.getMinutes(), is(0));
        Assert.assertThat(clock.getHours(), is(1));
    }

    @Test
    public void testToString() {
        Assert.assertThat(clock.toString(), is("Clock{seconds=0, minutes=0, hours=0}"));
    }
}