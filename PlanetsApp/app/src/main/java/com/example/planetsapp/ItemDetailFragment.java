package com.example.planetsapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    private static final String TAG = "ItemDetailFragment";

    private static final String PREF_WEIGHT = "weight";

    public static final String ARG_PLANET = "planet";

    private Planet planet;

    private EditText weightEditText;
    private TextView resultTextView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    public static ItemDetailFragment newInstance(Planet planet) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(ItemDetailFragment.ARG_PLANET, planet);
        ItemDetailFragment fragment = new ItemDetailFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_PLANET)) {
            planet = (Planet) getArguments().getSerializable(ARG_PLANET);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(planet.name());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.planet_detail_rl, container, false);

        TextView planetName = (TextView) rootView.findViewById(R.id.planetNameTextView);
        planetName.setText(planet.getNameResourceId());

        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
        imageView.setImageResource(planet.getImageResourceId());

        TextView descriptionView = (TextView) rootView.findViewById(R.id.descriptionTextView);
        descriptionView.setText(planet.getDescriptionResourceId());

        weightEditText = (EditText) rootView.findViewById(R.id.editText);
        resultTextView = (TextView) rootView.findViewById(R.id.resultTextView);

        // Recover any values that were used previously
        SharedPreferences sharedPreferences = getActivity().getPreferences(Activity.MODE_PRIVATE);
        float userInput = sharedPreferences.getFloat(PREF_WEIGHT, -1);
        if (userInput != -1) {
            weightEditText.setText("" + (int) userInput);
            updateResultTextView(userInput);
        }

        rootView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = weightEditText.getText().toString();

                float newWeight;
                try {
                    newWeight = Float.valueOf(userInput);
                } catch (NumberFormatException e) {
                    resultTextView.setText("Bad input: " + userInput);
                    return;
                }

                updateResultTextView(newWeight);

                SharedPreferences sharedPreferences = getActivity().getPreferences(Activity.MODE_PRIVATE);
                sharedPreferences.edit().putFloat(PREF_WEIGHT, newWeight).apply();
                Log.d(TAG, "Saving preferences for weight of " + newWeight);
            }
        });


        return rootView;
    }

    private void updateResultTextView(float weight) {
        resultTextView.setText("Weight on this planet: " + planet.getWeightOnPlanet(weight));
    }
}
