package com.fenix_laser_mty.backend.excepciones;

public class ProductoNotFoundException extends RuntimeException{

    public ProductoNotFoundException(Integer id) {
        super("Not found Producto with id: "+id);
    }

}
