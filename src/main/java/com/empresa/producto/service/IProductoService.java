package com.empresa.producto.service;

import com.empresa.producto.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {
    //Metodo para traer todos los productos
    public List<ProductoDTO> listarTodos();

    //Metodo para obtener producto por Id
    public ProductoDTO obtenerPorId(Long id);

    //Metodo para guardar productos
    public ProductoDTO guardarProducto(ProductoDTO productoDTO);

    //Metodo para actualizar producto
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTOUpdate);

    //Metodo para eliminar producto
    public void eliminarPrducto(Long id);

}
