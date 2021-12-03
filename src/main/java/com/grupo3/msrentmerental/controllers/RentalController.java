package com.grupo3.msrentmerental.controllers;

import com.grupo3.msrentmerental.exceptions.RentalNotFoundException;
import com.grupo3.msrentmerental.models.Rental;
import com.grupo3.msrentmerental.repositories.RentalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {
    private final RentalRepository rentalRepository;

    public RentalController( RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping("/rental/{id}")
    Rental getRental(@PathVariable String id){
        return rentalRepository.findById(id).orElseThrow(()-> new RentalNotFoundException("No se encontro una renta con el id: " + id));
    }

    @GetMapping("/rental")
    List<Rental> getRentalAll(){
        return rentalRepository.findAll();
    }

    @PostMapping("/rental")
    Rental newRental (@RequestBody Rental rental){
        return rentalRepository.save(rental);
    }

    @PutMapping("/rental/{id}")
    Rental cancelRental (@PathVariable String id, @RequestBody Rental rental){
        Rental rentalData = rentalRepository.findById(id).orElseThrow(()-> new RentalNotFoundException("No se encontro una renta con el id: " + id));;

        rentalData.setId(id);
        rentalData.setUser_id(rental.getUser_id() != null ? rental.getUser_id() : rentalData.getUser_id());
        rentalData.setDate_start(rental.getDate_start() != null ? rental.getDate_start() : rentalData.getDate_start());
        rentalData.setDate_finish(rental.getDate_finish() != null ? rental.getDate_finish() : rentalData.getDate_finish());
        rentalData.setIs_active(rental.getIs_active() != null ? rental.getIs_active() : rentalData.getIs_active());
        rentalData.setVehicle_id(rental.getVehicle_id() != null ? rental.getVehicle_id() : rentalData.getVehicle_id());

        return rentalRepository.save(rentalData);
    }
}
