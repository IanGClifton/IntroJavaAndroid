package com.example.mysimpleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private TextView resultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");

        Pet tom = new Cat(1, 5f);
        tom.setName("Tom");
        Pet grumpy = new Dog();
        grumpy.setName("Grumpy");

        Log.d(TAG, "Tom's favorite thing is " + tom.getFavoriteThing());
        Log.d(TAG, "Grumpy's favorite thing is " + grumpy.getFavoriteThing());

        PetsArray petsArray = new PetsArray();
        petsArray.addPet(tom);
        petsArray.addPet(grumpy);

        Log.d(TAG, "Total pet weight: " + petsArray.getTotalWeight());


        // Test out our PetsList
        PetsList petsList = new PetsList();
        petsList.addPet(tom);
        petsList.addPet(grumpy);
        Pet mostRecentPet = petsList.getMostRecent();

        if (mostRecentPet instanceof Dog) {
            Dog mostRecentDog = (Dog) mostRecentPet;
//            mostRecentDog.setName("Fido");
            Log.d(TAG, "Most recent pet is a dog named " + mostRecentDog.getName());
        } else if (mostRecentPet instanceof Cat) {
            Cat mostRecentCat = (Cat) mostRecentPet;
            mostRecentCat.scratchSomeone();
            Log.d(TAG, "Most recent pet is a cat named " + mostRecentCat.getName());
        }

        Pet foundGrumpy = petsList.getPetByName("Grumpy");
        Log.d(TAG, "Found a Pet named " + foundGrumpy.getName());

        try {
            petsList.addPet(foundGrumpy);
        } catch (DuplicatePetNameException e) {
            Log.w(TAG, "Pet could not be added because its name is already used: " + foundGrumpy.getName());
            Log.w(TAG, "Error was: " + e.getMessage());
        }





        // This seems to set up the Hello World text
        setContentView(R.layout.activity_main); // This is a comment
        resultsTextView = (TextView) findViewById(R.id.resultsTextView);
        View myButton = findViewById(R.id.saveButton);
//        myButton.setOnClickListener(new SimpleClickListener());
//        myButton.setOnClickListener(this);
        assert myButton != null;
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "The view was clicked");

                // Get the name of the pet
                TextView petNameEditText = (TextView) findViewById(R.id.petNameEditText);
                String petName = petNameEditText.getText().toString();
                if (TextUtils.isEmpty(petName)) {
                    // Pet name is empty
                    resultsTextView.setText(R.string.error_no_pet_name);
                    return;
                }

                // Get the age of the pet
                TextView petAgeEditText = (TextView) findViewById(R.id.petAgeEditText);
                String petAgeString = petAgeEditText.getText().toString();

                int age;
                try {
                    // Code to try that might throw an exception
                    age = Integer.valueOf(petAgeString);
                } catch (NumberFormatException e) {
                    // Code to run if we caught the exception
                    Log.w(TAG, "Invalid input for age: " + e.getMessage());
                    String errorMessage = getString(R.string.error_invalid_age);
                    resultsTextView.setText(errorMessage + petAgeString);
                    return;
                }


                // Create the new pet
                Pet newPet = new Cat(age, 10f);
                newPet.setName(petName);

                // Figure out the word to use for the age
                String ageDescriptor;
                if (age < 5) {
                    // Age is less than five
                    ageDescriptor = getString(R.string.young);
                } else if (age < 10) {
                    // Age is 5-9
                    ageDescriptor = getString(R.string.typical_age);
                } else if (age < 15) {
                    // Age is 10-14
                    ageDescriptor = getString(R.string.old);
                } else {
                    // Age is 15+
                    ageDescriptor = getString(R.string.ancient);
                }

                if (age == 10 && newPet.getName().equalsIgnoreCase("spot")) {
                    // The age is 10 AND the name is "Spot"
                    ageDescriptor = "an amazing pet";
                }
                if (age == 99 || newPet.getName().equals("Fido")) {
                    // Either the age is 99 OR the name is "Fido"
                    ageDescriptor = "magical";
                }

                // Update the TextView
                String outputText = getString(R.string.pet_output, newPet.getName(), ageDescriptor);
                resultsTextView.setText(outputText);
            }
        });

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "The view was clicked");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy called");
    }
}
