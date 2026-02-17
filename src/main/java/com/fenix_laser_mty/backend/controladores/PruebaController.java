package com.fenix_laser_mty.backend.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @GetMapping("/home")
    public String home() {
        return "Backend Fenix Láser corriendo 🔥";
    }
}