package com.treat.treatinder.constants;

import lombok.Getter;

@Getter
public enum AnimalsTypes {
    DOG("Dog"),
    CAT("Cat");

    private final String value;
    AnimalsTypes(String value) {
        this.value = value;
    }
}
