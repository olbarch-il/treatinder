package com.treat.treatinder.service.interactor.dao;

import com.treat.treatinder.service.interactor.model.PetInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogInteractionRepository extends JpaRepository<PetInteraction, Long> {
}
