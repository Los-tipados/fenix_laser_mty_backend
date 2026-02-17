package com.fenix_laser_mty.backend;

public class UsuarioNotFoundException extends  RuntimeException{

    public UsuarioNotFoundException(Integer id) {
        super("Not found User with id: "+id);
    }

}
