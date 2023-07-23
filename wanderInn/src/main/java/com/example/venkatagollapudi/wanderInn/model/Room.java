package com.example.venkatagollapudi.wanderInn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    @Id
    private String id;
    private String hotelId;
    private String roomType;
    private String roomNumber;
    private String price;
    private String description;
    private String image;
    private String rating;
    private String availability;
    private String amenities;
    private String capacity;

}
