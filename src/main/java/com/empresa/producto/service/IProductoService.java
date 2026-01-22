package com.empresa.producto.service;

import com.empresa.producto.model.Producto;

import java.util.List;

public interface IProductoService {
    //Metodo para traer todos los productos
    public List<Producto> listarTodos();

    //Metodo para obtener producto por Id
    public Producto obtenerPorId(Long id);

    //Metodo para guardar productos
    public Producto guardarProducto(Producto producto);

    //Metodo para actualizar producto
    public Producto actualizarProducto(Long id, Producto productoActualizado);

    //Metodo para eliminar producto
    public void eliminarPrducto(Long id);

}
