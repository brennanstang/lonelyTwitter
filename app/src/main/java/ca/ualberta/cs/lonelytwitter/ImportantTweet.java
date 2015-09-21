package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bstang on 9/14/15.
 */
public class ImportantTweet extends Tweet implements Tweetable {
    public ImportantTweet(String text, Date date) {
        super(text, date);
    }

    public ImportantTweet(String text) {
        super(text);
        this.setText(text);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
