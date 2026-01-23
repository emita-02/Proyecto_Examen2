package com.empresa.producto.controller;

import com.empresa.producto.dto.ProductoDTO;
import com.empresa.producto.service.IProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indicador de la clase
@RequestMapping("/api/productos") //Ruta base
@CrossOrigin(origins = "*") //Permite consumir la API desde el frontend web
public class ProductoController {
    @Autowired
    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * GET
     * Listar todos los productos
     */
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarProductos(){
        return ResponseEntity.ok(productoService.listarTodos());
    }

    /**
     * GET
     * Obtener producto por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoID(@PathVariable Long id){
        return ResponseEntity.ok(productoService.obtenerPorId(id));
    }

    /**
     * POST
     * Crear un nuevo producto
     */
    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO){
        ProductoDTO nuevoProducto = productoService.guardarProducto(productoDTO);

        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    /**
     * PUT
     * Actualizar un producto por su id
     */
    @PutMapping("{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id, @Valid @RequestBody ProductoDTO productoDTO){
        return ResponseEntity.ok(productoService.actualizarProducto(id, productoDTO));
    }

    /**
     * DELETE
     * Eliminar un producto por su id
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        productoService.eliminarPrducto(id);
        return ResponseEntity.noContent().build();
    }

}
