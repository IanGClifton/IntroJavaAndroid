package com.example.planetsapp.old;

/**
 * Outdated Planet class
 * 
 * @deprecated Use the new enum instead
 */
public abstract class Planet {

    private final int nameResourceId;
    private final int descriptionResourceId;
    private final int imageResourceId;
    private final float weightMultiplier;

    /**
     * Constructs a new Planet
     *
     * @param nameResourceId int name of the planet such as "Earth"
     * @param descriptionResourceId int description of the planet; a short sentence or two
     * @param imageResourceId drawable resource ID for the planet's image
     * @param weightMultiplier float multiplier to figure out the weight on this planet
     */
    public Planet(int nameResourceId, int descriptionResourceId, int imageResourceId, float weightMultiplier) {
        this.nameResourceId = nameResourceId;
        this.descriptionResourceId = descriptionResourceId;
        this.imageResourceId = imageResourceId;
        this.weightMultiplier = weightMultiplier;
    }

    public int getNameResourceId() {
        return nameResourceId;
    }

    public int getDescriptionResourceId() {
        return descriptionResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    /**
     * Returns what the weight on a planet would be
     *
     * @param weightOnEarth float weight of the object on earth
     * @return float weight of the object on this planet
     */
    public float getWeightOnPlanet(float weightOnEarth) {
        return weightOnEarth * weightMultiplier;
    }
}
