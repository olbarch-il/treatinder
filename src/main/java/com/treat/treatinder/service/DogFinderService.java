package com.treat.treatinder.service;

import com.treat.treatinder.constants.AnimalsTypes;
import com.treat.treatinder.model.Dog;
import com.treat.treatinder.model.dto.AnimalResponse;
import com.treat.treatinder.model.dto.DogPageResponse;
import com.treat.treatinder.service.api.FinderApiClient;
import com.treat.treatinder.utils.PetMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DogFinderService implements DogFinder {

    private final FinderApiClient api;
    private final PetMapper mapper;
    @Override
    public DogPageResponse getDogs(int page, int limit) {
        AnimalResponse response = api.fetchAnimals(page, limit, AnimalsTypes.DOG);
        List<Dog> dogs = mapper.toDogs(response);
        return new DogPageResponse(dogs, response.getPagination());
    }
}


