package com.fenix_laser_mty.backend.repositorios;

import com.fenix_laser_mty.backend.modelos.Categoria;
import com.fenix_laser_mty.backend.modelos.Producto;
import com.fenix_laser_mty.backend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria, Integer> {

    Categoria findByCategory(String username);

}
