package com.grupo3.msrentmerental.controllers;

import com.grupo3.msrentmerental.exceptions.RentalNotFoundException;
import com.grupo3.msrentmerental.models.Rental;
import com.grupo3.msrentmerental.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {
    private final RentalRepository rentalRepository;

    public RentalController( RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping("/rental/{user_id}")
    Rental getRental(@PathVariable Integer user_id){
        return rentalRepository.findById(user_id).orElseThrow(()-> new RentalNotFoundException("No se encontro una renta con el id: " + user_id));
    }

    @GetMapping("/rental")
    List<Rental> getRentalAll(){
        return rentalRepository.findAll();
    }

    @PostMapping("/rental")
    Rental newRental (@RequestBody Rental rental){
        return rentalRepository.save(rental);
    }

    @PutMapping("/rental/{user_id}")
    Rental updateIsActive (@PathVariable Integer user_id, @RequestBody Rental rental){
        rentalRepository.findById(user_id).orElseThrow(()-> new RentalNotFoundException("No se encontro una renta con el id: " + user_id));;
        return rentalRepository.save(rental);
    }
}
