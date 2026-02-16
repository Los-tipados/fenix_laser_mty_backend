package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long idPago;
    @OneToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Long idPedido;
    @Column(name = "metodo", nullable = false, length = 50)
    private String metodoPago;
    @Column(name = "monto",nullable = false, columnDefinition = "Decimal(10, 2)")
    private Double monto;
    @Column(name = "estado", length = 30)
    private String estado;
    @Column(name = "fecha", columnDefinition = "DATETIME")
    private LocalDateTime fecha;

    public Pago(){

    }

    public Pago(Long idPago, Long idPedido, String metodoPago, Double monto, String estado, LocalDateTime fecha) {
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Long getIdPago() {
        return idPago;
    }


    public Long getIdPedido() {
        return idPedido;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pago pago)) return false;
        return Objects.equals(idPago, pago.idPago) && Objects.equals(idPedido, pago.idPedido) && Objects.equals(metodoPago, pago.metodoPago) && Objects.equals(monto, pago.monto) && Objects.equals(estado, pago.estado) && Objects.equals(fecha, pago.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPago, idPedido, metodoPago, monto, estado, fecha);
    }

    @Override
    public String toString() {
        return "Pago{" +
                "idPago=" + idPago +
                ", idPedido=" + idPedido +
                ", metodoPago='" + metodoPago + '\'' +
                ", monto=" + monto +
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
