package com.example.venkatagollapudi.wanderInn.repository;

import com.example.venkatagollapudi.wanderInn.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {

    // Get hotels by city or state
    List<Hotel> findByCityOrState(String city, String state);

    // Get hotels with a specific rating or higher
    List<Hotel> findByRatingGreaterThanEqual(String rating);

    // Get hotels with a specific rating or higher, sorted by rating (descending)
    List<Hotel> findByRatingGreaterThanEqualOrderByRatingDesc(String rating);

    // Get hotels with a specific rating or higher, located in a specific city or state
    List<Hotel> findByRatingGreaterThanEqualAndCityOrState(String rating, String city, String state);
}
