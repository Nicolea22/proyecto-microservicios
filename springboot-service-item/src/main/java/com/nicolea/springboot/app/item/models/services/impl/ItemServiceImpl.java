package com.nicolea.springboot.app.item.models.services.impl;

import com.nicolea.springboot.app.item.models.Item;
import com.nicolea.springboot.app.item.models.Producto;
import com.nicolea.springboot.app.item.models.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private RestTemplate restClient;

    @Override
    public List<Item> findAll() {
        List<Producto> products = Arrays.asList(restClient.getForObject("http://localhost:8001/listar", Producto[].class));
        return products.stream().map(p-> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer amount) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Producto product = restClient.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
        return new Item(product, amount);
    }
}
