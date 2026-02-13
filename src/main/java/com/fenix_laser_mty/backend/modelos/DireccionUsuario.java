package com.fenix_laser_mty.backend.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones_usuario")
public class DireccionUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long id_direccion;


    @ManyToOne
     @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero_externo")
    private String numero_externo;

    @Column(name = "numero_interno")
    private String numero_interno;

    @Column(name = "colonia")
    private String colonia;

    @Column(name = "codigo_postal")
    private String codigo_postal;

    @Column(name = "ciudad")
    private  String ciudad;



}
