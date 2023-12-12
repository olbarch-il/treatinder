package com.treat.treatinder.service.interactor.controller;

import com.treat.treatinder.service.interactor.model.PetInteraction;
import com.treat.treatinder.service.interactor.service.DogInteractionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/interactions")
public class DogInteractionController {
    private DogInteractionService service;

    @PostMapping
    public ResponseEntity<?> handleInteraction(@RequestBody PetInteraction interaction) {
        service.saveInteraction(interaction);
        return ResponseEntity.ok().build();
    }

}
