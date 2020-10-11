package com.snailvoyager.springbooteatgo.domain;

import java.util.List;

public interface MenuItemRepository {
    List<MenuItem> findAllByRestaurantId(Long id);

    Restaurant findById(Long id);
}
