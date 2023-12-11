package com.treat.treatinder.model;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dog {
    @EqualsAndHashCode.Include
    private String id;
    private String name;
    private String breedPrimary;
    private String age;
    private String gender;
    private String size;
    private String coat;
    private String color;
    private List<String> photos;
    private String status;
    private String description;
}
