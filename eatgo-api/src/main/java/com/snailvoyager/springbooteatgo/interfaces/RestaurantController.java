package com.snailvoyager.springbooteatgo.interfaces;

import com.snailvoyager.springbooteatgo.domain.Restaurant;
import com.snailvoyager.springbooteatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
//        List<Restaurant> restaurants = new ArrayList<>();
//
//        Restaurant restaurant = new Restaurant(1004L,"Bab zip", "Seoul");
//        Restaurant restaurant2 = new Restaurant(2001L, "Odysay", "Space");

//        restaurants.add(restaurant);
//        restaurants.add(restaurant2);

        return repository.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
}
