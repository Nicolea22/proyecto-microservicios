package com.nicolea.springboot.app.item.controllers;

import com.nicolea.springboot.app.item.models.Item;
import com.nicolea.springboot.app.item.models.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private IItemService itemService;

    @GetMapping(value = "/listar")
    public List<Item> listar(){
        return itemService.findAll();
    }

    @GetMapping(value = "/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
        return itemService.findById(id, cantidad);
    }

}
