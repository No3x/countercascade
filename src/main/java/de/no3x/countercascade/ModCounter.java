package de.no3x.countercascade;

/**
 * Created by No3x on 21.01.2017.
 */

/**
 * A mod counter counts increasing from 0 to mod-1.
 */
public class ModCounter extends Counter {

    private int mod;

    public ModCounter(int mod) {
        this.mod = mod;
    }

    @Override
    public int increment() {
        set( super.increment() % mod);
        return 0;
    }

    @Override
    public int decrement() {
        return set( ( getCount() + mod - 1 ) % mod);
    }
}
