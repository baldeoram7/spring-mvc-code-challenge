package com.api.service.impl;

import com.api.model.request.Pet;
import com.api.repository.PetsRepository;
import com.api.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PetsServiceImpl implements PetsService {

    @Autowired
    private PetsRepository petsRepository;

    @Override
    public List<Pet> getPets(Optional<String> petsType) {

        if (petsType.isPresent() && !petsType.get().isEmpty()) {
            return petsRepository.findByPetType(petsType.get());
        } else {
            Iterable<Pet> iterable = petsRepository.findAll();
            return StreamSupport.stream(iterable.spliterator(), false)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void savePets(Pet pet, Optional<String> petsType) {
        petsRepository.save(pet);
    }
}
