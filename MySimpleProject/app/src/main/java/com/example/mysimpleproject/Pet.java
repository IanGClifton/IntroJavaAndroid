package com.example.mysimpleproject;

/**
 * Represents an animal that lives in someone's house.
 */
public abstract class Pet {

    private static int petCount = 0;

    private int age;
    private float weight;
    private final boolean isCat;
    private String name;

    /**
     * Instantiates a new Pet object with an age of 1, a weight of 5, and isCat set to true
     */
    public Pet() {
        this(1, 5f, true);
    }

    /**
     * Instantiates a new Pet object
     *
     * @param ageInYears the age of the pet in whole years
     * @param weightInPounds the weight of the pet in pounds
     * @param isCat whether or not this pet is a cat
     */
    public Pet(int ageInYears, float weightInPounds, boolean isCat) {
        // This is the constructor
        this.age = ageInYears;
        this.weight = weightInPounds;
        this.isCat = isCat;
        petCount++;
    }

    public static int getPetCount() {
        return petCount;
    }

    /**
     * Returns the age in years
     *
     * @return the age in whole years
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the pet age in years
     *
     * @param age the pet age in years
     */
    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isCat() {
        return isCat;
    }

    /**
     * Returns the name of the pet
     *
     * @return the name of the pet
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the pet
     *
     * @param name to use for the pet such as "Fido"
     */
    public void setName(String name) {
        this.name = name;
    }

    public abstract String getFavoriteThing();
}
