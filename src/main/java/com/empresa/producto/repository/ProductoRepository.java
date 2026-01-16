package com.empresa.producto.repository;

import com.empresa.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    /**
     * No se necesita colocar código
     * JpaRepository trae: save(), findAll(), findById(), deleteById(), entre otros.
     */
}
