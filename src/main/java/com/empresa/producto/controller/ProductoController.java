package com.empresa.producto.controller;

import com.empresa.producto.model.Producto;
import com.empresa.producto.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indicador de la clase
@RequestMapping("/api/productos") //Ruta base
@CrossOrigin(origins = "*") //Permite consumir la API desde el frontend web
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    /**
     * GET
     * Listar todos los productos
     */
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){
        return ResponseEntity.ok(productoService.listarTodos());
    }

    /**
     * GET
     * Obtener producto por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoID(@PathVariable Long id){
        Producto producto = productoService.obtenerPorId(id);

        if (producto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(producto);
    }

    /**
     * POST
     * Crear un nuevo producto
     */
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@Valid @RequestBody Producto producto){
        Producto nuevoProducto = productoService.guardar(producto);

        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    /**
     * PUT
     * Actualizar un producto por su id
     */
    @PutMapping("{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @Valid @RequestBody Producto producto){
        Producto productoActualizado = productoService.actualizar(id, producto);

        if (productoActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productoActualizado);
    }

    /**
     * DELETE
     * Eliminar un producto por su id
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        Producto productoEliminado = productoService.obtenerPorId(id);

        if (productoEliminado == null){
            return ResponseEntity.notFound().build();
        }

        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
