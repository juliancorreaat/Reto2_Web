package com.reto2.web.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.reto2.web.Model.Gadget;

public interface GadgetRepository extends MongoRepository<Gadget, Integer> {
    
    
}
