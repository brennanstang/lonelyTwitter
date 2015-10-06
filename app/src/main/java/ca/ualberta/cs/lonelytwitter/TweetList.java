package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by bstang on 9/28/15.
 */
public class TweetList implements MyObservable, MyObserver {
    public ArrayList<Tweet> getTweets(){
        return tweets;
    }

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    private void notifyAllObservers() {
        for (MyObserver observer: observers) {
            observer.myNotify(this);
        }
    }


    public void add(Tweet tweet) {
        tweets.add(tweet);
        notifyAllObservers();
    }


    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Boolean contains(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    public void myNotify(MyObservable observable) {
        notifyAllObservers();
    }

}
