package com.example.mysimpleproject;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by Ian on 5/17/2016.
 */
public class PetsArray {
    private static final String TAG = "PetsArray";

    private Pet[] pets;

    public void addPet(Pet pet) {
        if (pets == null) {
            pets = new Pet[] { pet };
        } else {
            int newArraySize = pets.length + 1;
            pets = Arrays.copyOf(pets, newArraySize);
            pets[pets.length - 1] = pet;
        }
        Log.d(TAG, "PetsArray size is now " + pets.length);
    }

    public float getTotalWeight() {
        float totalWeight = 0;
        if (pets == null) {
            return totalWeight;
        }
        // [0] Fido
        // [1] Wilson
//        for (int i = 0; i < pets.length; i++) {
//            totalWeight += pets[i].getWeight();
//        }

        for (Pet pet : pets) {
            totalWeight += pet.getWeight();
        }

        int five = 5;
        int ten = 10;
        int two = ten / five;
        int three = 3;

        float value = (float) ten / (float) three; // ???

        return totalWeight;
    }
}
