package com.example.planetsapp.old;

import com.example.planetsapp.R;

/**
 * @deprecated 
 */
public class Mars extends Planet {

    private static final float MARS_WEIGHT_MULTIPLIER = 0.377f;

    public Mars() {
        super(R.string.mars, R.string.mars_description, R.drawable.mars, MARS_WEIGHT_MULTIPLIER);
    }
}
