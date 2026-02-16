package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "direcciones_usuario")
public class DireccionesUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDireccion")
    private Long idDireccion;


    @ManyToOne
     @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "calle", nullable = false, length = 100)
    private String calle;

    @Column(name = "numero_externo", nullable = false, length = 10)
    private String numero_externo;

    @Column(name = "numero_interno", length = 10)
    private String numero_interno;

    @Column(name = "colonia", nullable = false, length = 100)
    private String colonia;

    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigo_postal;

    @Column(name = "ciudad", nullable = false, length = 50)
    private  String ciudad;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "referencia")
    private String referencia;


    public Long getidDireccion() {
        return idDireccion;
    }

    public void setidDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
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

    @Override
    public String toString() {
        return "DireccionUsuario{" +
                "idDireccion=" + idDireccion +
                ", usuario=" + usuario +
                ", calle='" + calle + '\'' +
                ", numero_externo='" + numero_externo + '\'' +
                ", numero_interno='" + numero_interno + '\'' +
                ", colonia='" + colonia + '\'' +
                ", codigo_postal='" + codigo_postal + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", referencia='" + referencia + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DireccionesUsuario that)) return false;
        return Objects.equals(idDireccion, that.idDireccion) && Objects.equals(usuario, that.usuario) && Objects.equals(calle, that.calle) && Objects.equals(numero_externo, that.numero_externo) && Objects.equals(numero_interno, that.numero_interno) && Objects.equals(colonia, that.colonia) && Objects.equals(codigo_postal, that.codigo_postal) && Objects.equals(ciudad, that.ciudad) && Objects.equals(estado, that.estado) && Objects.equals(referencia, that.referencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDireccion, usuario, calle, numero_externo, numero_interno, colonia, codigo_postal, ciudad, estado, referencia);
    }
    
}
