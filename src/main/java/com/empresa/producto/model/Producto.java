package com.empresa.producto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //Indica que la clase es JPA (convertirse en una tabla)
@Table(name = "productos") //Nombre de la tabla en la base de datos
public class Producto {
    /**
     * @Id indica que este atributo es la clave primaria
     * El ID se genera automaticamente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /***
     * Evita valores nulos o vacios
     * Define el tamaño del texto (Varchar en MySQL)
     */
    @NotBlank(message = "Ingresar el nombre.")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres.")
    private String nombre;

    /**
     * Campo opcional con limite de carateres
     */
    @Size(max = 150, message = "La descipción no puede tener más de 150 caracteres.")
    private String descripcion;

    /**
     * Evita que el precio sea nulo
     * Evita que el precio sea negativo
     */
    @NotNull(message = "Debe ingresar el precio del producto.")
    @DecimalMin(value = "0.01", message = "El precio no puede ser 0, ni negativo.")
    private Double precio;

    /**
     * Evita valores nulos
     * Controla que el stock no sea menor a 0
     */
    @NotNull(message = "Debe ingresar el stock del producto.")
    @Min(value = 0, message = "El stock no puede ser negativo.")
    private Integer stock;

    /**
     * Campo obligatorio para que haya una clasificacion del producto
     */
    @NotBlank(message = "Debe ingresar la categoria del producto.")
    private String categoria;


}
