package com.fenix_laser_mty.backend.dto;

public class RecuRequest {

    private String correo;
    private String password;

    public RecuRequest() {}

    public RecuRequest(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
