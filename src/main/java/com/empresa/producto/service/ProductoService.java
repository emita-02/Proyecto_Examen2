package com.empresa.producto.service;

import com.empresa.producto.exception.ResourceNotFoundException;
import com.empresa.producto.model.Producto;
import com.empresa.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    // Obtener producto por id
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El prodcuto con id: "+id+" no existe."));
    }

    // Crear un nuevo producto
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    /**
     * Actualizar un producto existente con excepciones personalizadas
     * @param id
     * @param productoActualizado
     * @return
     */
    public Producto actualizar(Long id, Producto productoActualizado) {
        Producto productoExistente = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "El producto con id: "+id+" no existe."
        ));

        productoExistente.setNombre(productoActualizado.getNombre());
        productoExistente.setDescripcion(productoActualizado.getDescripcion());
        productoExistente.setPrecio(productoActualizado.getPrecio());
        productoExistente.setStock(productoActualizado.getStock());
        productoExistente.setCategoria(productoActualizado.getCategoria());

        return productoRepository.save(productoExistente);
    }

    // Eliminar producto
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "El producto con id: "+id+" no existe."));

        productoRepository.delete(producto);
    }

}
