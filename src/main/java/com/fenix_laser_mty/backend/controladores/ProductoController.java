package com.fenix_laser_mty.backend.controladores;

import com.fenix_laser_mty.backend.excepciones.ProductoNotFoundException;
import com.fenix_laser_mty.backend.modelos.Producto;
import com.fenix_laser_mty.backend.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*") //se habikita todo a nivel clase o metodos

public class ProductoController {

    private final ProductoServicio productoServicio;
    @Autowired
    public ProductoController ( ProductoServicio productoServicio){
        this.productoServicio=productoServicio;
    }

    //mapear getUsuarios (Se puede mejorar con ResponseEntity
    @GetMapping("/products")
    public List <Producto> findAll(){return productoServicio.getProductos();}

    @PostMapping ("/new-product")
    public ResponseEntity<Producto> saveUser (@RequestBody Producto newProduct){

        //no se hace validacion si nos compran la pagina si
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(productoServicio.createProducto(newProduct));

    }

    @DeleteMapping ("/delete-product/{id}")
    public ResponseEntity <Producto> deleteById (@PathVariable Integer id){

        try{
            productoServicio.deleteProducto(id);
            return ResponseEntity.noContent().build();
        }catch (ProductoNotFoundException e){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping ("/update-producto/{id}")
    public ResponseEntity <Producto> updateProduct (@RequestBody Producto producto, @PathVariable Integer id){

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(productoServicio.updateProducto(producto,id));
        }catch (ProductoNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }





}
