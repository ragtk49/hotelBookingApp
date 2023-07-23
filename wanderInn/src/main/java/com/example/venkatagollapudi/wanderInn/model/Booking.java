package com.example.venkatagollapudi.wanderInn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {

    private String id;
    private String hotelId;
    private String roomId;
    private String userId;
    private String checkInDate;
    private String checkOutDate;
    private String price;
    private String status;

}
