package com.empresa.producto.service;

import com.empresa.producto.dto.ProductoDTO;
import com.empresa.producto.exception.ResourceNotFoundException;
import com.empresa.producto.mapper.ProductoMapper;
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
    public List<ProductoDTO> listarTodos() {
        return productoRepository.findAll().stream()
                .map(ProductoMapper::toDTO)
                .toList();
    }

    // Obtener producto por id
    @Override
    public ProductoDTO obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "El producto con id: " + id + " no existe."
                ));

        return ProductoMapper.toDTO(producto);
    }

    // Crear un nuevo producto
    @Override
    public ProductoDTO guardarProducto(ProductoDTO productoDTO) {
        Producto producto = ProductoMapper.toEntity(productoDTO);
        Producto guardado = productoRepository.save(producto);
        return ProductoMapper.toDTO(guardado);
    }


    //Actualziar producto
    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTOUpdate) {
        Producto productoExis = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "El producto con id: "+id+" no existe."
        ));

        //Buscar que el prodcuto exista
        if (productoExis == null){
            return null;
        }

        //Actualizar solo los campos que vienen con valor
        if (productoDTOUpdate.getNombre() != null){
            productoExis.setNombre(productoDTOUpdate.getNombre());
        }
        if (productoDTOUpdate.getDescripcion() != null){
            productoExis.setDescripcion(productoDTOUpdate.getDescripcion());
        }
        if (productoDTOUpdate.getPrecio() != null){
            productoExis.setPrecio(productoDTOUpdate.getPrecio());
        }
        if (productoDTOUpdate.getStock() != null){
            productoExis.setStock(productoDTOUpdate.getStock());
        }
        if (productoDTOUpdate.getCategoria() != null){
            productoExis.setCategoria(productoDTOUpdate.getCategoria());
        }

        //Guardar y retornar
        return ProductoMapper.toDTO(productoRepository.save(productoExis));

    }


    // Eliminar producto
    @Override
    public void eliminarPrducto(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "El producto con id: "+id+" no existe."));

        productoRepository.delete(producto);
    }


}
