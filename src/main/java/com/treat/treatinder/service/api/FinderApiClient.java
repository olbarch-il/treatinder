package com.treat.treatinder.service.api;

import com.treat.treatinder.constants.AnimalsTypes;
import com.treat.treatinder.model.dto.AnimalResponse;


public interface FinderApiClient {
    AnimalResponse fetchAnimals(int page, int limit, AnimalsTypes type);
}
