package com.example.venkatagollapudi.wanderInn.controller;

import com.example.venkatagollapudi.wanderInn.model.Room;
import com.example.venkatagollapudi.wanderInn.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable String roomId) {
        Room room = roomService.getRoomById(roomId);
        if (room != null) {
            return new ResponseEntity<>(room, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room savedRoom = roomService.saveRoom(room);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable String roomId, @RequestBody Room room) {
        Room existingRoom = roomService.getRoomById(roomId);
        if (existingRoom != null) {
            room.setId(roomId);
            Room updatedRoom = roomService.updateRoom(room);
            return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable String roomId) {
        Room existingRoom = roomService.getRoomById(roomId);
        if (existingRoom != null) {
            roomService.deleteRoom(roomId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Room>> getRoomsByHotelId(@PathVariable String hotelId) {
        List<Room> rooms = roomService.getRoomsByHotelId(hotelId);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/type/{roomType}")
    public ResponseEntity<List<Room>> getRoomsByType(@PathVariable String roomType) {
        List<Room> rooms = roomService.getRoomsByRoomType(roomType);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Room>> getRoomsWithRatingGreaterThanOrEqualTo(@PathVariable String rating) {
        List<Room> rooms = roomService.getRoomsWithRatingGreaterThanOrEqualTo(rating);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/price/{minPrice}/{maxPrice}")
    public ResponseEntity<List<Room>> getRoomsInPriceRange(
            @PathVariable String minPrice,
            @PathVariable String maxPrice) {
        List<Room> rooms = roomService.getRoomsWithinPriceRange(minPrice, maxPrice);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/availability/{availability}")
    public ResponseEntity<List<Room>> getRoomsByAvailability(@PathVariable String availability) {
        List<Room> rooms = roomService.getRoomsByAvailability(availability);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/amenity/{amenity}")
    public ResponseEntity<List<Room>> getRoomsByAmenity(@PathVariable String amenity) {
        List<Room> rooms = roomService.getRoomsByAmenity(amenity);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/capacity/{capacity}")
    public ResponseEntity<List<Room>> getRoomsByCapacity(@PathVariable String capacity) {
        List<Room> rooms = roomService.getRoomsByCapacity(capacity);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    // Add more endpoints for other room-related queries if required
}
