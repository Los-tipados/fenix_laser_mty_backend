package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "etiquetas")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etiqueta")
    private Integer idEtiqueta;

    @Column(name = "nombre")
    private String nombre_etiqueta;

    public Etiqueta(Integer idEtiqueta, String nombre_etiqueta) {
        this.idEtiqueta = idEtiqueta;
        this.nombre_etiqueta = nombre_etiqueta;
    }

    public Etiqueta() {
    }

    public Integer getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Integer idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getNombre_etiqueta() {
        return nombre_etiqueta;
    }

    public void setNombre_etiqueta(String nombre_etiqueta) {
        this.nombre_etiqueta = nombre_etiqueta;
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                "idEtiqueta=" + idEtiqueta +
                ", nombre_etiqueta='" + nombre_etiqueta + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Etiqueta etiqueta)) return false;
        return Objects.equals(idEtiqueta, etiqueta.idEtiqueta) && Objects.equals(nombre_etiqueta, etiqueta.nombre_etiqueta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEtiqueta, nombre_etiqueta);
    }
}
