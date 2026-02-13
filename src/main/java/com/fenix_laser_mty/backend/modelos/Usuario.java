package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name ="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_usuario")
    private Integer idUsuario;

    @Column (name = "id_nombre")
    private String nombre;

    @Column (name="correo", unique = true, length = 100)
    private String correo;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column (name= "password", nullable = false, length = 255)
    private String password;

    @Column (name ="rol", length = 20)
    private  String rol="cliente";

    @Column (name ="fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro= LocalDateTime.now();



}
