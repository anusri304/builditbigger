package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.idling.CountingIdlingResource;
import com.example.androidjokes.utils.ApplicationConstants;

public class MainActivity extends AppCompatActivity {


    CountingIdlingResource espressoTestIdlingResource = new CountingIdlingResource(ApplicationConstants.NETWORK_CALL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        try {
            String data = new EndpointsAsyncTask().execute(this).get();
            //Log.d("Anandhi", "Anandhi" + data);

            Intent intent = new Intent(this, com.example.androidjokes.JokeActivity.class);
            intent.putExtra(ApplicationConstants.JOKE, data);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }


//       Intent intent = new Intent(this,com.example.androidjokes.JokeActivity.class);
//       intent.putExtra(ApplicationConstants.JOKE,new Joker().getJoke());
//       startActivity(intent);
    }

    public CountingIdlingResource getEspressoTestIdlingResource() {
        return espressoTestIdlingResource;
    }
}
