package com.nicolea.springboot.app.item.models.services;

import com.nicolea.springboot.app.item.models.Item;

import java.util.List;

public interface IItemService {

    List<Item> findAll();
    Item findById(Long id, Integer cantidad);

}
