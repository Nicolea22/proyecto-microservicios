package com.nicolea.springboot.app.item.models.services.impl;

import com.nicolea.springboot.app.item.clients.ProductRestClient;
import com.nicolea.springboot.app.item.models.Item;
import com.nicolea.springboot.app.item.models.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class ItemServiceFeign implements IItemService {

    @Autowired
    private ProductRestClient productRestClient;

    @Override
    public List<Item> findAll() {
        return productRestClient.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(productRestClient.detail(id), cantidad);
    }
}
