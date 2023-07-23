package com.example.venkatagollapudi.wanderInn.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "users")
@Getter
@Setter
public class User {
    @Id
    private String id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String role;

}
