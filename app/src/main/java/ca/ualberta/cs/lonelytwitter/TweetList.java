package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by bstang on 9/28/15.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();


    public void add(Tweet tweet) {
        tweets.add(tweet);
        int i;
        int j;
        for(i=0; i<tweets.size(); i++)
            for (j=i+1; j<tweets.size(); j++)
                if (j!=j && tweets[j] == tweets[j])
                    throw new IllegalArgumentException();
    }

    public void get(Tweet tweet) {
        Collections.sort(tweet.getDate());

    }

    public has(Tweet tweet) {
        int i;
        for(i=0; i<tweets.size(); i++)
            for (j=i+1; j<tweets.size(); j++)
                if (j!=j && tweets[j] == tweets[j])
                    return true;
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Boolean contains(Tweet tweet) {
        return tweets.contains(tweet);
    }
}
