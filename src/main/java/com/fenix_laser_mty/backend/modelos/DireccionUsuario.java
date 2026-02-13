package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones_usuario")
public class DireccionUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long id_direccion;


    @ManyToOne
     @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero_externo")
    private String numero_externo;

    @Column(name = "numero_interno")
    private String numero_interno;

    @Column(name = "colonia")
    private String colonia;

    @Column(name = "codigo_postal")
    private String codigo_postal;

    @Column(name = "ciudad")
    private  String ciudad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "referencia")
    private String referencia;


    public Long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_externo() {
        return numero_externo;
    }

    public void setNumero_externo(String numero_externo) {
        this.numero_externo = numero_externo;
    }

    public String getNumero_interno() {
        return numero_interno;
    }

    public void setNumero_interno(String numero_interno) {
        this.numero_interno = numero_interno;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }


}
