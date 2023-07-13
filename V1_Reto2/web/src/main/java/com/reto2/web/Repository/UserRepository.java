package com.reto2.web.Repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.reto2.web.Model.User;

public interface UserRepository extends MongoRepository<User, Integer>{
    
    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByEmailAndPassword(String email, String password);
}
