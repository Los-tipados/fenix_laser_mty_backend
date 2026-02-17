package com.fenix_laser_mty.backend.controladores;

import com.fenix_laser_mty.backend.excepciones.UsuarioNotFoundException;
import com.fenix_laser_mty.backend.modelos.Usuario;
import com.fenix_laser_mty.backend.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1")
@CrossOrigin(origins = "*") //se habikita todo a nivel clase o metodos
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;
    @Autowired
    public UsuarioController (UsuarioServicio usuarioServicio){ this.usuarioServicio=usuarioServicio;}

    //maper getUsuarios
    @GetMapping("/users")
    public List <Usuario> findAll(){ return usuarioServicio.getUsuarios();}

    @PostMapping ("/new-user/")
    //manejamos los estados
    public ResponseEntity <Usuario> saveUser (@RequestBody Usuario newUser){

        Usuario usuarioByCorreo=usuarioServicio.findByCorreo(newUser.getCorreo());
        Usuario usuarioById=usuarioServicio.findById(newUser.getIdUsuario());

        if (usuarioById != null || usuarioByCorreo!=null){
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{

            return  ResponseEntity.status(HttpStatus.CREATED)
                    .body(usuarioServicio.createUsuario(newUser));
        }
    }

    //permite poder tomar distintos valores de id
    @GetMapping("/user/{id}")
    public ResponseEntity<Usuario> findById (@PathVariable Integer id){
        try {
            return ResponseEntity.ok(usuarioServicio.findById(id));
        } catch (UsuarioNotFoundException e) {
            // opcion 1 return ResponseEntity.notFound().build();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //Mapear delete User 204 y 404
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Usuario> deleteById(@PathVariable Integer id){

        try{
            usuarioServicio.deletUsuario(id);
            return ResponseEntity.noContent().build();

        }catch (UsuarioNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //Recuperar el cuerpo
    @PutMapping ("/update-user/{id}")
    public ResponseEntity<Usuario> updateUser (@RequestBody Usuario usuario, @PathVariable Integer id){

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body((usuarioServicio.updateUsuario(usuario, id)));
        }catch (UsuarioNotFoundException e){
            return ResponseEntity.notFound().build();
        }


    }

}
