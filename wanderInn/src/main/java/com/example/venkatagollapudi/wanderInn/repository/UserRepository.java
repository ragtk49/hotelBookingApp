package com.example.venkatagollapudi.wanderInn.repository;

import com.example.venkatagollapudi.wanderInn.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    // Get a user by their email
    User findByEmail(String email);

    // Get users by their role
    List<User> findByRole(String role);

    // Get users from a specific city or state
    List<User> findByCityOrState(String city, String state);
}
