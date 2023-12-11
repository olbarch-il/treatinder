package com.treat.treatinder.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnimalResponse {
    private List<Animal> animals;
    private Pagination pagination;
    @Data
    public static class Animal {
        private long id;
        private String organizationId;
        private String url;
        private String type;
        private String species;
        private Breed breeds;
        private Color colors;
        private String age;
        private String gender;
        private String size;
        private String coat;
        private Attributes attributes;
        private Environment environment;
        private List<String> tags;
        private String name;
        private String description;
        private String organizationAnimalId;
        private List<Photo> photos;
        private Photo primaryPhotoCropped;
        private String status;
        private String statusChangedAt;
        private String publishedAt;
        private Contact contact;
    }

    @Data
    public static class Breed {
        private String primary;
        private String secondary;
        private boolean mixed;
        private boolean unknown;
    }

    @Data
    public static class Color {
        private String primary;
        private String secondary;
        private String tertiary;
    }

    @Data
    public static class Attributes {
        private boolean spayedNeutered;
        private boolean houseTrained;
        private Boolean declawed;
        private boolean specialNeeds;
        private boolean shotsCurrent;
    }

    @Data
    public static class Environment {
        private Boolean children;
        private Boolean dogs;
        private Boolean cats;
    }

    @Data
    public static class Photo {
        private String small;
        private String medium;
        private String large;
        private String full;
    }

    @Data
    public static class Contact {
        private String email;
        private String phone;
        private Address address;
    }

    @Data
    public static class Address {
        private String address1;
        private String address2;
        private String city;
        private String state;
        private String postcode;
        private String country;
    }

    @Data
    public static class Links {
        private Link self;
        private Link type;
        private Link organization;

        @Data
        public static class Link {
            private String href;
        }
    }

}
