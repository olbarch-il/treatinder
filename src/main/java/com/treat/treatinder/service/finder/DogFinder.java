package com.treat.treatinder.service.finder;

import com.treat.treatinder.model.dto.DogPageResponse;

public interface DogFinder {
    DogPageResponse fetchDogs(int page, int limit);
}



