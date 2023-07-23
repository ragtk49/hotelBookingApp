package com.example.venkatagollapudi.wanderInn.repository;

import com.example.venkatagollapudi.wanderInn.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomRepository extends MongoRepository<Room, String> {

    // Get all rooms for a specific hotel
    List<Room> findByHotelId(String hotelId);

    // Get rooms by room type
    List<Room> findByRoomType(String roomType);

    // Get rooms with a specific rating or higher
    List<Room> findByRatingGreaterThanEqual(String rating);

    // Get rooms with a specific rating or higher, sorted by rating (descending)
    List<Room> findByRatingGreaterThanEqualOrderByRatingDesc(String rating);

    // Get rooms within a specific price range
    List<Room> findByPriceBetween(String minPrice, String maxPrice);

    // Get rooms with a specific availability status
    List<Room> findByAvailability(String availability);

    // Get rooms with specific amenities
    List<Room> findByAmenitiesContainingIgnoreCase(String amenity);

    // Get rooms with specific capacity
    List<Room> findByCapacity(String capacity);
}
