package com.example.venkatagollapudi.wanderInn.service;

import com.example.venkatagollapudi.wanderInn.model.Booking;
import com.example.venkatagollapudi.wanderInn.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(String bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public List<Booking> getBookingsByUserId(String userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getBookingsByHotelId(String hotelId) {
        return bookingRepository.findByHotelId(hotelId);
    }

    public List<Booking> getBookingsByRoomId(String roomId) {
        return bookingRepository.findByRoomId(roomId);
    }

    public List<Booking> getBookingsWithinDateRange(String fromDate, String toDate) {
        return bookingRepository.findByCheckInDateGreaterThanEqualAndCheckOutDateLessThanEqual(fromDate, toDate);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByStatus(String status) {
        return bookingRepository.findByStatus(status);
    }

    public List<Booking> getBookingsByStatusAndUserId(String status, String userId) {
        return bookingRepository.findByStatusAndUserId(status, userId);
    }

    public List<Booking> getBookingsByStatusAndHotelId(String status, String hotelId) {
        return bookingRepository.findByStatusAndHotelId(status, hotelId);
    }

    public List<Booking> getBookingsByStatusAndRoomId(String status, String roomId) {
        return bookingRepository.findByStatusAndRoomId(status, roomId);
    }

    public List<Booking> getBookingsForUserSortedByCheckInDate(String userId) {
        return bookingRepository.findByUserIdOrderByCheckInDateAsc(userId);
    }

    public List<Booking> getBookingsForUserSortedByCheckOutDate(String userId) {
        return bookingRepository.findByUserIdOrderByCheckOutDateDesc(userId);
    }
}
