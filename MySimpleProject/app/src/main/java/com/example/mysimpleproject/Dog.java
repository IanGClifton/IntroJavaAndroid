package com.example.mysimpleproject;

/**
 * Created by Ian on 5/17/2016.
 */
public class Dog extends Pet {

    public Dog() {
        super();
    }

    /**
     * Instantiates a new Pet object
     *
     * @param ageInYears the age of the pet in whole years
     * @param weightInPounds the weight of the pet in pounds
     */
    public Dog(int ageInYears, float weightInPounds) {
        super(ageInYears, weightInPounds, false);
    }

    @Override
    public String getFavoriteThing() {
        return "Everything";
    }
}
