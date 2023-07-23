package com.example.venkatagollapudi.wanderInn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotels")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {
    @Id
    private String id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
    private String email;
    private String website;
    private String image;
    private String description;
    private String rating;

}
