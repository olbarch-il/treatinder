package com.treat.treatinder.controller;

import com.treat.treatinder.model.Dog;
import com.treat.treatinder.service.DogFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dogs")
public class DogController {
    private final DogFinderService dogFinderService;

    @GetMapping
    public ResponseEntity<List<Dog>> getDogs(@RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "10") int limit) {
        List<Dog> dogs = dogFinderService.getDogs(page, limit);
        return ResponseEntity.ok(dogs);
    }
}
