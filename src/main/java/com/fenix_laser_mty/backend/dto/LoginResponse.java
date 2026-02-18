package com.fenix_laser_mty.backend.dto;

public class LoginResponse {

        private Integer idUsuario;
        private String nombre;
        private String correo;
        private String rol;
        private boolean authenticated;

        public LoginResponse(Integer idUsuario, String nombre, String correo, String rol, boolean authenticated) {
            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.correo = correo;
            this.rol = rol;
            this.authenticated = authenticated;
        }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
