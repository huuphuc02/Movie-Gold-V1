package dev.phc.movies.repository;

import dev.phc.movies.model.Movie;
import dev.phc.movies.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
