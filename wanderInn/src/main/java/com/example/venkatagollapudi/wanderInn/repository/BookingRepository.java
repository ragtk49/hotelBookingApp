package com.example.venkatagollapudi.wanderInn.repository;

import com.example.venkatagollapudi.wanderInn.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {

        // Get all bookings for a specific user
        List<Booking> findByUserId(String userId);

        // Get all bookings for a specific hotel
        List<Booking> findByHotelId(String hotelId);

        // Get all bookings for a specific room
        List<Booking> findByRoomId(String roomId);

        // Get all bookings within a given date range
        List<Booking> findByCheckInDateGreaterThanEqualAndCheckOutDateLessThanEqual(String fromDate, String toDate);

        // Get all bookings with a specific status
        List<Booking> findByStatus(String status);

        // Get all bookings with a specific status and user
        List<Booking> findByStatusAndUserId(String status, String userId);

        // Get all bookings with a specific status and hotel
        List<Booking> findByStatusAndHotelId(String status, String hotelId);

        // Get all bookings with a specific status and room
        List<Booking> findByStatusAndRoomId(String status, String roomId);

        // Get all bookings for a specific user, sorted by check-in date (ascending)
        List<Booking> findByUserIdOrderByCheckInDateAsc(String userId);

        // Get all bookings for a specific user, sorted by check-out date (descending)
        List<Booking> findByUserIdOrderByCheckOutDateDesc(String userId);
}
