package de.no3x.countercascade;

/**
 * Created by No3x on 21.01.2017.
 */
public class LinkedModCounter extends ModCounter {
    private LinkedModCounter next;

    public LinkedModCounter(final int mod, final LinkedModCounter next) {
        super(mod);
        this.next = next;
    }

    @Override
    public int increment() {
        super.increment();
        if (0 == getCount() && null != next) {
            next.increment();
        }
        return 0;
    }

}
