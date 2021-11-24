package com.grupo3.msrentmerental.repositories;

import com.grupo3.msrentmerental.models.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentalRepository extends MongoRepository <Rental, Integer>{
}
