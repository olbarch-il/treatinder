package com.treat.treatinder.service.interactor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetInteraction {
    String userId;
    String petId;
    String actionId;
    boolean isLiked;
}
