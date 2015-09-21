package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bstang on 9/14/15.
 */
public abstract class Mood {
    protected String mood;
    private Date date;

    public Mood(String mood, Date date) {
        this.mood = mood;
        this.date = date;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        if (isHappy()) {
            mood = ":)";
        } else {
            mood = ":(";
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isHappy();
}
