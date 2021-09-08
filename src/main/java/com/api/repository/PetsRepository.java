package com.api.repository;

import com.api.model.request.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetsRepository extends CrudRepository<Pet, Long> {
    List<Pet> findByPetType(String petType);
}