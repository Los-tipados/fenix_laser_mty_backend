package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "pedido_detalle")
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_detalle", nullable = false)
    private Integer idDetalle;

    @OneToOne
    @JoinColumn (name = "id_pedido")
    private Integer idPedido;

    @ManyToOne
    @JoinColumn (name = "id_producto")
    private Integer idProducto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double precioUnitario;

    public PedidoDetalle(Integer idDetalle, Integer idPedido, Integer idProducto, Integer cantidad, Double precioUnitario) {
        this.idDetalle = idDetalle;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public PedidoDetalle() {
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }


    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "PedidoDetalle{" +
                "idDetalle=" + idDetalle +
                ", idPedido=" + idPedido +
                ", idProducto=" + idProducto +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PedidoDetalle that)) return false;
        return Objects.equals(idDetalle, that.idDetalle) && Objects.equals(idPedido, that.idPedido) && Objects.equals(idProducto, that.idProducto) && Objects.equals(cantidad, that.cantidad) && Objects.equals(precioUnitario, that.precioUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDetalle, idPedido, idProducto, cantidad, precioUnitario);
    }
}
