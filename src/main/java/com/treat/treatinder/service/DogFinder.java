package com.treat.treatinder.service;

import com.treat.treatinder.model.Dog;
import com.treat.treatinder.model.dto.DogPageResponse;

import java.util.List;

public interface DogFinder {
    DogPageResponse getDogs(int page, int limit);
}



