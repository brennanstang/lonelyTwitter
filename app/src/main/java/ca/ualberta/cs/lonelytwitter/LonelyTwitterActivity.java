package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity implements MyObserver {

	private static final String FILENAME = "file.sav";	//model
	private EditText bodyText;	//model
	private ListView oldTweetsList;	//model
	private ArrayList<Tweet> tweets;	//model
	private ArrayAdapter<Tweet> adapter;	//model

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {	//all

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); //View

		bodyText = (EditText) findViewById(R.id.body); //Controller
		Button saveButton = (Button) findViewById(R.id.save); //View
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList); //View

		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();	//move to controller
				tweets.add(new NormalTweet(text));	//move to controller
				saveInFile();	//move to model
				adapter.notifyDataSetChanged();	//model
			}
		});
	}

	@Override
	protected void onStart() {	//model
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();	//model
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);	//model
		oldTweetsList.setAdapter(adapter);	//model
	}

	private void loadFromFile() { //model
		try {
			FileInputStream fis = openFileInput(FILENAME);	//model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));	//model
			Gson gson = new Gson();	//model
			//Following line based on https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();	//model
			tweets = gson.fromJson(in, listType);	//model


		} catch (FileNotFoundException e) {	//model
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException(e); 	//model
		}
	}
	
	private void saveInFile() {	//model
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);	//model
			OutputStreamWriter writer = new OutputStreamWriter(fos);	//model
			Gson gson = new Gson();	//model
			gson.toJson(tweets, writer);	//model
			writer.flush();	//model
			fos.close();	//model
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);	//model
		} catch (IOException e) {
			throw new RuntimeException(e);	//model
		}
	}

	public void myNotify(MyObservable observable) {
		adapter.notifyDataSetChanged();	//model
	}
}