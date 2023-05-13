package de.no3x.countercascade;

/**
 * A mod counter counts increasing from 0 to mod-1.
 */
public class ModCounter extends Counter {

    private final int mod;

    public ModCounter(int mod) {
        this.mod = mod;
    }

    @Override
    public int increment() {
        return set(super.increment() % mod);
    }

    @Override
    public int decrement() {
        return set((getCount() + mod - 1) % mod);
    }
}
