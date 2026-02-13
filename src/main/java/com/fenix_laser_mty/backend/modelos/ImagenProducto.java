package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "imagenes_producto")
public class ImagenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Integer idImagen;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private  Producto producto;

    public ImagenProducto(Integer idImagen, String url, Producto producto) {
        this.idImagen = idImagen;
        this.url = url;
        this.producto = producto;
    }

    public ImagenProducto() {
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ImagenProducto{" +
                "idImagen=" + idImagen +
                ", url='" + url + '\'' +
                ", producto=" + producto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImagenProducto that)) return false;
        return Objects.equals(idImagen, that.idImagen) && Objects.equals(url, that.url) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImagen, url, producto);
    }
}
