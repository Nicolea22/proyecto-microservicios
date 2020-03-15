package com.nicolea.springboot.app.productos.models.repository;

import com.nicolea.springboot.app.productos.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
