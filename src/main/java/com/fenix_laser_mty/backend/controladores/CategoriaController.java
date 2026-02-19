package com.fenix_laser_mty.backend.controladores;

import com.fenix_laser_mty.backend.modelos.Categoria;
import com.fenix_laser_mty.backend.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepositorio;

    @GetMapping("/categorias")
    public List<Categoria> findAll() {
        return categoriaRepositorio.findAll();

    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaRepositorio.save(categoria));
    }
}