package com.example.mysimpleproject;

/**
 * Created by Ian on 5/17/2016.
 */
public class Cat extends Pet {

    /**
     * Instantiates a new Pet object
     *
     * @param ageInYears the age of the pet in whole years
     * @param weightInPounds the weight of the pet in pounds
     */
    public Cat(int ageInYears, float weightInPounds) {
        super(ageInYears, weightInPounds, true);
    }

    @Override
    public boolean isCat() {
        return true;
    }

    @Override
    public String getFavoriteThing() {
        return "Sleep";
    }

    public void scratchSomeone() {
        // Placeholder
    }
}
