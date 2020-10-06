package com.cgm.bike.controller;

import com.cgm.bike.model.Bike;
import com.cgm.bike.repository.BikeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

    @Autowired
    private BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> list() {
        //List<Bike> bikes = new ArrayList<>();

        return bikeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createBike(@RequestBody Bike bikeEntity){
        bikeRepository.save(bikeEntity);
    }

    @GetMapping("/{id}")
    public Bike getBike(@PathVariable("id") Long id){
        return bikeRepository.getOne(id);
    }
}
