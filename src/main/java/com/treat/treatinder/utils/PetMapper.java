package com.treat.treatinder.utils;

import com.treat.treatinder.model.Dog;
import com.treat.treatinder.model.dto.AnimalResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetMapper {

    public List<Dog> toDogs(AnimalResponse response) {
        return response.getAnimals().stream().map(this::mapToDog).collect(Collectors.toList());
    }

    private Dog mapToDog(AnimalResponse.Animal animal) {
        List<String> photos = animal.getPhotos() != null ?
                animal.getPhotos().stream().map(AnimalResponse.Photo::getMedium).toList() : null;
        return Dog.builder()
                .id(String.valueOf(animal.getId()))
                .name(animal.getName())
                .breedPrimary(animal.getBreeds().getPrimary())
                .age(animal.getAge())
                .gender(animal.getGender())
                .size(animal.getSize())
                .coat(animal.getCoat())
                .color(animal.getColors() != null ? animal.getColors().getPrimary() : null)
                .photos(photos)
                .status(animal.getStatus())
                .description(animal.getDescription())
                .build();
    }
}
