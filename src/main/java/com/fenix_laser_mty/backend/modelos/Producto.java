package com.fenix_laser_mty.backend.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column
    private String imagen;

    @Column(precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(name = "visible_catalogo")
    private Boolean visibleCatalogo = true;

    @Column(name = "visible_recomendados")
    private Boolean visibleRecomendados = false;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "producto_etiqueta",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_etiqueta")
    )
    private List<Etiqueta> etiquetas;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenProducto> imagenes;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<PedidoDetalle> pedidoDetalles;

    public Producto() {}

    public Producto(String nombre, String descripcion, BigDecimal precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Boolean getVisibleCatalogo() {
        return visibleCatalogo;
    }

    public void setVisibleCatalogo(Boolean visibleCatalogo) {
        this.visibleCatalogo = visibleCatalogo;
    }

    public Boolean getVisibleRecomendados() {
        return visibleRecomendados;
    }

    public void setVisibleRecomendados(Boolean visibleRecomendados) {
        this.visibleRecomendados = visibleRecomendados;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(idProducto, producto.idProducto) && Objects.equals(nombre, producto.nombre) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(precio, producto.precio) && Objects.equals(imagen, producto.imagen) && Objects.equals(rating, producto.rating) && Objects.equals(visibleCatalogo, producto.visibleCatalogo) && Objects.equals(visibleRecomendados, producto.visibleRecomendados) && Objects.equals(categoria, producto.categoria) && Objects.equals(etiquetas, producto.etiquetas) && Objects.equals(imagenes, producto.imagenes) && Objects.equals(pedidoDetalles, producto.pedidoDetalles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nombre, descripcion, precio, imagen, rating, visibleCatalogo, visibleRecomendados, categoria, etiquetas, imagenes, pedidoDetalles);
    }
}

