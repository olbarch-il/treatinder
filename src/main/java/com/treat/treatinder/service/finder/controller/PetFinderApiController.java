package com.treat.treatinder.service.finder.controller;

import com.treat.treatinder.model.dto.DogPageResponse;
import com.treat.treatinder.service.finder.service.DogFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dogs")
public class PetFinderApiController {
    private final DogFinderService dogFinderService;
    @GetMapping
    public ResponseEntity<DogPageResponse> getDogs(@RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "10") int limit) {
        DogPageResponse dogs = dogFinderService.fetchDogs(page, limit);
        return ResponseEntity.ok(dogs);
    }
}
