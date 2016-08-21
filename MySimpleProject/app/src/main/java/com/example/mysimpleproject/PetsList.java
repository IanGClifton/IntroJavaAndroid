package com.example.mysimpleproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ian on 5/18/2016.
 */
public class PetsList {

    private final List<Pet> pets = new ArrayList<>();
    private final Map<String, Pet> petsMap = new HashMap<>();

    /**
     * Add a Pet to our List
     *
     * @param pet to add, must have a name
     * @throws DuplicatePetNameException if the pet's name is already in our map
     */
    public void addPet(Pet pet) {
        if (petsMap.containsKey(pet.getName())) {
            throw new DuplicatePetNameException("Pet name already exists: " + pet.getName());
        }

        pets.add(pet);
        petsMap.put(pet.getName(), pet);
    }

    public float getTotalWeight() {
        int weight = 0;

        for (Pet pet : pets) {
            weight += pet.getWeight();
        }

        return weight;
    }

    public Pet getMostRecent() {
        if (pets.isEmpty()) {
            return null;
        }

        return pets.get(pets.size() - 1);
    }

    public Pet getPetByName(String name) {
        return petsMap.get(name);
    }
}
