package com.snailvoyager.springbooteatgo.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RestaurantTest {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant("Bab zip", "Seoul");
        assertThat(restaurant.getName()).isEqualTo("Bab zip");
        assertThat(restaurant.getAddress()).isEqualTo("Seoul");
    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant("Bab zip", "Seoul");
        assertThat(restaurant.getInformation()).isEqualTo("Bab zip in Seoul");
    }
}