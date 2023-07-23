package com.example.venkatagollapudi.wanderInn.service;

import com.example.venkatagollapudi.wanderInn.model.Hotel;
import com.example.venkatagollapudi.wanderInn.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElse(null);
    }

    public List<Hotel> getHotelsByCityOrState(String city, String state) {
        return hotelRepository.findByCityOrState(city, state);
    }

    public List<Hotel> getHotelsWithRatingGreaterThanOrEqualTo(String rating) {
        return hotelRepository.findByRatingGreaterThanEqual(rating);
    }

    public List<Hotel> getHotelsWithRatingGreaterThanOrEqualToSortedByRatingDesc(String rating) {
        return hotelRepository.findByRatingGreaterThanEqualOrderByRatingDesc(rating);
    }

    public List<Hotel> getHotelsWithRatingGreaterThanOrEqualToInCityOrState(String rating, String city, String state) {
        return hotelRepository.findByRatingGreaterThanEqualAndCityOrState(rating, city, state);
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(String hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
