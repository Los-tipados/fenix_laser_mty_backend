package com.fenix_laser_mty.backend.repositorios;

import com.fenix_laser_mty.backend.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Producto findByNombreProducto(String nombreProducto);

}
