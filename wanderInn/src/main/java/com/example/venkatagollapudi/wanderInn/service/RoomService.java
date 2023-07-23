package com.example.venkatagollapudi.wanderInn.service;

import com.example.venkatagollapudi.wanderInn.model.Room;
import com.example.venkatagollapudi.wanderInn.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(String roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    public List<Room> getRoomsByHotelId(String hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    public List<Room> getRoomsByRoomType(String roomType) {
        return roomRepository.findByRoomType(roomType);
    }

    public List<Room> getRoomsWithRatingGreaterThanOrEqualTo(String rating) {
        return roomRepository.findByRatingGreaterThanEqual(rating);
    }

    public List<Room> getRoomsWithRatingGreaterThanOrEqualToSortedByRatingDesc(String rating) {
        return roomRepository.findByRatingGreaterThanEqualOrderByRatingDesc(rating);
    }

    public List<Room> getRoomsWithinPriceRange(String minPrice, String maxPrice) {
        return roomRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Room> getRoomsByAvailability(String availability) {
        return roomRepository.findByAvailability(availability);
    }

    public List<Room> getRoomsByAmenity(String amenity) {
        return roomRepository.findByAmenitiesContainingIgnoreCase(amenity);
    }

    public List<Room> getRoomsByCapacity(String capacity) {
        return roomRepository.findByCapacity(capacity);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(String roomId) {
        roomRepository.deleteById(roomId);
    }

    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }
}
