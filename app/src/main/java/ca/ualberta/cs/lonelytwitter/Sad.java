package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bstang on 9/14/15.
 */
public class Sad extends Mood {
    protected date moodDate = getDate();

    public Sad(String mood, Date date) {
        super(mood, date);
    }

    public Boolean isHappy() {
        return Boolean.FALSE;
    }
}
