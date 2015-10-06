package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import java.util.ArrayList;

/**
 * Created by bstang on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver, MyObservable {

    public Boolean wasNotified = Boolean.FALSE;
    public ArrayList<MyObserver> observers;

    public TweetListTest() {
            super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddObserver() {
        TweetList list = new TweetList();
        list.addObserver(this);
        wasNotified = Boolean.FALSE;
        list.add(new NormalTweet("Test"));
        assertTrue(wasNotified);
    }

    public void testTweetObserver() {
        TweetList list = new TweetList();
        list.addObserver(this);
        Tweet tweet = new NormalTweet("Test");
        list.add(tweet);
        wasNotified = Boolean.FALSE;
        tweet.setText("different");

    }


    /*public void testAddTweet() {
        TweetList list = new TweetList();
        list.add(new NormalTweet("test"));
        list.add(new NormalTweet("test"));
   }

    public void testGetTweets() {
        list.get(tweet);

   }

    public void testRemoveTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.delete(tweet);
        assertFalse(false);
    }

    public void testContains() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.contains(tweet));
    }*/

    public void notifyAllObservers() {
        for (MyObserver observer: observers){
            observer.myNotify(this);
        }
    }

    public void myNotify(MyObservable observable) {
        notifyAllObservers();
    }

    public void addObserver(MyObserver observer){
        observers.add(observer);
    }

}