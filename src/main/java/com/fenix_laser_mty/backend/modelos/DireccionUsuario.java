package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "direccion_usuario")
public class DireccionUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long id_direccion;
    


}
