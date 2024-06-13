package fact.it.startproject.model;

import javax.persistence.Embeddable;

@Embeddable
public class Time {
    private int minutes,seconds;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
