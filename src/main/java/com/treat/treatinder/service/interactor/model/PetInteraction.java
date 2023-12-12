package com.treat.treatinder.service.interactor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ITERACTIONS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PetInteraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userId;
    String petId;
    Boolean isLiked;
}