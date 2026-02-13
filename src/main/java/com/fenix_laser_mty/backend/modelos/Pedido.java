package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table (name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_pedido", unique = true)
    private Integer idPedido;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "id_usuario")
    private Integer idUsuario;

    @Column (name = "total", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double total;

    @Column (name = "estado")
    private String estado;

    @Column (name = "fecha", columnDefinition = "DATETIME")
    private LocalDateTime fecha;

    @Column (name = "direccion_envio", nullable = false)
    private String direccionEnvio;

    public Pedido(Integer idPedido, Integer idUsuario, Double total, String estado, LocalDateTime fecha, String direccionEnvio) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.total = total;
        this.estado = estado;
        this.fecha = fecha;
        this.direccionEnvio = direccionEnvio;
    }

    public Pedido() {
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", idUsuario=" + idUsuario +
                ", total=" + total +
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                ", direccionEnvio='" + direccionEnvio + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pedido pedido)) return false;
        return Objects.equals(idPedido, pedido.idPedido) && Objects.equals(idUsuario, pedido.idUsuario) && Objects.equals(total, pedido.total) && Objects.equals(estado, pedido.estado) && Objects.equals(fecha, pedido.fecha) && Objects.equals(direccionEnvio, pedido.direccionEnvio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idUsuario, total, estado, fecha, direccionEnvio);
    }
}
