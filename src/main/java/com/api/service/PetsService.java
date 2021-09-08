package com.api.service;

import com.api.model.request.Pet;

import java.util.List;
import java.util.Optional;

public interface PetsService {
    List<Pet> getPets(Optional<String> petsType);

    void savePets(Pet pet, Optional<String> petsType);
}
