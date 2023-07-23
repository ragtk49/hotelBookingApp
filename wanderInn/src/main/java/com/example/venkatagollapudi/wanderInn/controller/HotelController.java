package com.example.venkatagollapudi.wanderInn.controller;

import com.example.venkatagollapudi.wanderInn.model.Hotel;
import com.example.venkatagollapudi.wanderInn.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.saveHotel(hotel);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String hotelId, @RequestBody Hotel hotel) {
        Hotel existingHotel = hotelService.getHotelById(hotelId);
        if (existingHotel != null) {
            hotel.setId(hotelId);
            Hotel updatedHotel = hotelService.updateHotel(hotel);
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable String hotelId) {
        Hotel existingHotel = hotelService.getHotelById(hotelId);
        if (existingHotel != null) {
            hotelService.deleteHotel(hotelId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable String city) {
        List<Hotel> hotels = hotelService.getHotelsByCityOrState(city, null);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<Hotel>> getHotelsByState(@PathVariable String state) {
        List<Hotel> hotels = hotelService.getHotelsByCityOrState(null, state);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    // Add more endpoints for other hotel-related queries if required
}
