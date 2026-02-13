package com.fenix_laser_mty.backend.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(columnDefinition = "TEXT")
    private String imagen;

    @Column(precision = 2, scale = 1)
    private Double rating;

    @Column(name = "visible_catalogo")
    private Boolean visibleCatalogo = true;

    @Column(name = "visible_recomendados")
    private Boolean visibleRecomendados = false;

    // Muchos productos → una categoría
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    // Muchos productos ↔ muchas etiquetas
    @ManyToMany
    @JoinTable(
            name = "producto_etiqueta",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_etiqueta")
    )
    private List<Etiqueta> etiquetas;

    // Un producto → muchas imágenes
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenProducto> imagenes;

    // Detalles de pedidos (NO se exponen en JSON)
    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<PedidoDetalle> pedidoDetalles;

    public Producto() {
    }

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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
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

    public List<ImagenProducto> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenProducto> imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return idProducto != null && idProducto.equals(producto.idProducto);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", rating=" + rating +
                ", visibleCatalogo=" + visibleCatalogo +
                ", visibleRecomendados=" + visibleRecomendados +
                '}';
    }

}
