package com.treat.treatinder.service.finder;

import com.treat.treatinder.constants.AnimalsTypes;
import com.treat.treatinder.model.dto.AnimalResponse;
import com.treat.treatinder.model.dto.DogPageResponse;
import com.treat.treatinder.service.finder.api.FinderApiClient;
import com.treat.treatinder.utils.PetMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DogFinderService implements DogFinder {
    private final FinderApiClient api;
    private final PetMapper mapper;
    @Override
    public DogPageResponse fetchDogs(int page, int limit) {
        AnimalResponse response = api.fetchAnimals(page, limit, AnimalsTypes.DOG);
        return mapper.toDogsResponse(response);
    }
}


