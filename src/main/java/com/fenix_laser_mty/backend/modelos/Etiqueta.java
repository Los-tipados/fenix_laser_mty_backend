package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "etiquetas")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etiqueta", nullable = false)
    private Integer idEtiqueta;

    @Column(name = "nombre", nullable = false)
    private String nombreEtiqueta;

    public Etiqueta(Integer idEtiqueta, String nombreEtiqueta) {
        this.idEtiqueta = idEtiqueta;
        this.nombreEtiqueta = nombreEtiqueta;
    }

    public Etiqueta() {
    }

    public Integer getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Integer idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                "idEtiqueta=" + idEtiqueta +
                ", nombreEtiqueta='" + nombreEtiqueta + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Etiqueta etiqueta)) return false;
        return Objects.equals(idEtiqueta, etiqueta.idEtiqueta) && Objects.equals(nombreEtiqueta, etiqueta.nombreEtiqueta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEtiqueta, nombreEtiqueta);
    }
}
