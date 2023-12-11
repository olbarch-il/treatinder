package com.treat.treatinder.model.dto;

import com.treat.treatinder.model.Dog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogPageResponse {
    private List<Dog> dogs;
    private Pagination pagination;
}
