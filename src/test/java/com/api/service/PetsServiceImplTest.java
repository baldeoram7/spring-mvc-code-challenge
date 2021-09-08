package com.api.service;

import com.api.model.request.Pet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PetsServiceImplTest {

    @Autowired
    private PetsService petsService;

    @Test
    public void testNonNullResponse() {
        List<Pet> petsList = this.petsService.getPets(Optional.of("CAT"));
        Assertions.assertThat(petsList.size()).isGreaterThan(0);
    }

    @Test
    public void testFilterResponse() {
        List<Pet> petsList = this.petsService.getPets(Optional.of("CAT"));
        Assertions.assertThat(petsList.stream().allMatch(s -> s.getPetType().contains("CAT")));
    }

}
