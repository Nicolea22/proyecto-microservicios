package com.nicolea.springboot.app.item.clients;

import com.nicolea.springboot.app.item.models.Producto;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "service-products")
public interface ProductRestClient {

    @GetMapping(value = "/listar")
    List<Producto> list();

    @GetMapping(value = "/ver/{id}")
    Producto detail(@PathVariable("id") Long id);

}
