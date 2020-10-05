package com.snailvoyager.springbooteatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepository() {
        restaurants.add(new Restaurant(1004L, "Bab zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seroul"));
    }

    public List<Restaurant> findAll(){
        return restaurants;
    }

    public Restaurant findById(Long id) {
        return restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
