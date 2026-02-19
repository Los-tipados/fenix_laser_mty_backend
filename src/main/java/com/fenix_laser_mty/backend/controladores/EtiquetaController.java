package com.fenix_laser_mty.backend.controladores;

import com.fenix_laser_mty.backend.modelos.Etiqueta;
import com.fenix_laser_mty.backend.repositorios.EtiquetaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class EtiquetaController {

    @Autowired
    private EtiquetaRepositorio etiquetaRepositorio;

    @GetMapping("/etiquetas")
    public List<Etiqueta> findAll() {
        return etiquetaRepositorio.findAll();
    }

    @PostMapping("/etiquetas")
    public ResponseEntity<Etiqueta> save(@RequestBody Etiqueta etiqueta) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(etiquetaRepositorio.save(etiqueta));
    }

}