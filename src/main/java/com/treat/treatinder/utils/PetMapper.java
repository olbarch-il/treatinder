package com.treat.treatinder.utils;

import com.treat.treatinder.model.Dog;
import com.treat.treatinder.model.dto.AnimalResponse;
import com.treat.treatinder.model.dto.DogPageResponse;
import com.treat.treatinder.model.dto.LinksResponse;
import com.treat.treatinder.model.dto.PaginationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetMapper {

    public DogPageResponse toDogsResponse(AnimalResponse response) {
        List<Dog> dogs = response.getAnimals().stream().map(this::mapToDog).toList();
        PaginationResponse pagination = toPagination(response.getPagination());
        return new DogPageResponse(dogs, pagination);
    }

    private PaginationResponse toPagination(AnimalResponse.Pagination pagination) {
        return PaginationResponse.builder()
                .countPerPage(pagination.getCountPerPage())
                .currentPage(pagination.getCurrentPage())
                .totalPages(pagination.getTotalPages())
                .totalCount(pagination.getTotalCount())
                .nextPage(getNextPage(pagination))
                .build();
    }

    private static String getNextPage(AnimalResponse.Pagination pagination) {
        return Optional.of(pagination.getLinks())
                .map(AnimalResponse.Links::getNext)
                .map(AnimalResponse.Links.Link::getHref)
                .orElse(null);
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
