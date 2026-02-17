package com.fenix_laser_mty.backend.repositorios;

import com.fenix_laser_mty.backend.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
