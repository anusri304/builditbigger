package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import android.widget.ProgressBar;
import com.example.androidjokes.utils.ApplicationConstants;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button buttonJoke;
    ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root=  inflater.inflate(R.layout.fragment_main, container, false);

        buttonJoke = (Button) root.findViewById(R.id.button_joke);

        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        buttonJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                launchJokeActivity();
            }
        });
        return root;

    }

    private void launchJokeActivity() {
        try {
            String data = new EndpointsAsyncTask(progressBar).execute(getActivity().getApplicationContext()).get();
            //TODO remove log
            //Log.d("Anandhi", "Anandhi" + data);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
