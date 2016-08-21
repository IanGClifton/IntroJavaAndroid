package com.example.mysimpleproject;

import android.util.Log;
import android.view.View;

/**
 * Created by Ian on 5/17/2016.
 */
public class SimpleClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        Log.d("SimpleClickListener", "The view was clicked");
    }
}
