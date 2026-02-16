package com.fenix_laser_mty.backend.repositorios;

import com.fenix_laser_mty.backend.modelos.Producto;
import com.fenix_laser_mty.backend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {


    List<Producto> findByCategoryId(Integer idCategoria);
    List<Producto> findByNameIgnoreCase(String nombre);
    // Búsqueda por rango de precio y que estén visibles
    List<Producto> findByPricecBetween(Double min);

//producto*, preecio*, etiquetas*
}
