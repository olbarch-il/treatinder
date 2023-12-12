package com.treat.treatinder.service.interactor.service;

import com.treat.treatinder.service.interactor.dao.DogInteractionRepository;
import com.treat.treatinder.service.interactor.model.PetInteraction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogInteractionService implements InteractionService {
    private final DogInteractionRepository interactionRepository;
    @Override
    public void saveInteraction(PetInteraction petInteraction) {
        interactionRepository.save(petInteraction);
    }
}