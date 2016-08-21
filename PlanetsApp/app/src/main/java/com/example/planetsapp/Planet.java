package com.example.planetsapp;

/**
 * Created by Ian on 5/18/2016.
 */
public enum Planet {
    MERCURY(R.string.mercury, R.string.mercury_description, R.drawable.earth, 0.38f),
    VENUS(R.string.venus, R.string.venus_description, R.drawable.earth, 0.9f),
    EARTH(R.string.earth, R.string.earth_description, R.drawable.earth, 1f),
    MARS(R.string.mars, R.string.mars_description, R.drawable.mars, 0.337f),
    JUPITER(R.string.jupiter, R.string.jupiter_description, R.drawable.earth, 2.54f),
    SATURN(R.string.saturn, R.string.saturn_description, R.drawable.earth, 1.16f),
    URANUS(R.string.uranus, R.string.uranus_description, R.drawable.earth, 0.92f),
    NEPTUNE(R.string.neptune, R.string.neptune_description, R.drawable.earth, 1.19f),
    PLUTO(R.string.pluto, R.string.pluto_description, R.drawable.earth, 0.06f);




    private final int nameResourceId;
    private final int descriptionResourceId;
    private final int imageResourceId;
    private final float weightMultiplier;

    Planet(int nameResourceId, int descriptionResourceId, int imageResourceId, float weightMultiplier) {
        this.nameResourceId = nameResourceId;
        this.descriptionResourceId = descriptionResourceId;
        this.imageResourceId = imageResourceId;
        this.weightMultiplier = weightMultiplier;
    }

    public float getWeightOnPlanet(float weightOnEarth) {
        return weightOnEarth * weightMultiplier;
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
}
