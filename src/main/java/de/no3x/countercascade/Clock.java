package de.no3x.countercascade;

/**
 * Created by No3x on 21.01.2017.
 */
public class Clock {

    private final de.no3x.countercascade.LinkedModCounter hours = new de.no3x.countercascade.LinkedModCounter(24, null);
    private final de.no3x.countercascade.LinkedModCounter minutes = new de.no3x.countercascade.LinkedModCounter(60, hours);
    private final de.no3x.countercascade.LinkedModCounter seconds = new de.no3x.countercascade.LinkedModCounter(60, minutes);

    public int getSeconds() {
        return seconds.getCount();
    }

    public int getMinutes() {
        return minutes.getCount();
    }

    public int getHours() {
        return hours.getCount();
    }

    public void tick() {
        seconds.increment();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Clock{");
        sb.append("seconds=")
          .append(seconds);
        sb.append(", minutes=")
          .append(minutes);
        sb.append(", hours=")
          .append(hours);
        sb.append('}');
        return sb.toString();
    }
}
