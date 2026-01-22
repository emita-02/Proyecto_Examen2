package com.empresa.producto.service;

import com.empresa.producto.exception.ResourceNotFoundException;
import com.empresa.producto.model.Producto;
import com.empresa.producto.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private final IProductoRepository productoRepository;

    public ProductoService(IProductoRepository personRepository){
        this.productoRepository = personRepository;
    }

    // Obtener todos los productos
    @Override
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    // Obtener producto por id
    @Override
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El prodcuto con id: "+id+" no existe."));
    }

    // Crear un nuevo producto
    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }


    //Actualziar producto
    @Override
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Producto productoExis = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "El producto con id: "+id+" no existe."
        ));

        //Buscar que el prodcuto exista
        if (productoExis == null){
            return null;
        }

        //Actualizar solo los campos que vienen con valor
        if (productoActualizado.getNombre() != null){
            productoExis.setNombre(productoActualizado.getNombre());
        }
        if (productoActualizado.getDescripcion() != null){
            productoExis.setDescripcion(productoActualizado.getDescripcion());
        }
        if (productoActualizado.getPrecio() != null){
            productoExis.setPrecio(productoActualizado.getPrecio());
        }
        if (productoActualizado.getStock() != null){
            productoExis.setStock(productoActualizado.getStock());
        }
        if (productoActualizado.getCategoria() != null){
            productoExis.setCategoria(productoActualizado.getCategoria());
        }

        //Guardar y retornar
        return productoRepository.save(productoExis);

    }


    // Eliminar producto
    @Override
    public void eliminarPrducto(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "El producto con id: "+id+" no existe."));

        productoRepository.delete(producto);
    }


}
