package com.nicolea.springboot.app.productos.controllers;

import com.nicolea.springboot.app.productos.models.entity.Producto;
import com.nicolea.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping(value="/listar")
    public List<Producto> listar(){
        return productoService.findAll();
    }

    @GetMapping(value = "/ver/{id}")
    public Producto detalle(@PathVariable("id") Long id) {
        return productoService.findById(id);
    }

}
