package com.fenix_laser_mty.backend.controladores;


import com.fenix_laser_mty.backend.dto.LoginRequest;
import com.fenix_laser_mty.backend.dto.LoginResponse;
import com.fenix_laser_mty.backend.dto.RecuRequest;
import com.fenix_laser_mty.backend.modelos.Usuario;
import com.fenix_laser_mty.backend.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class AuthController {

@Autowired
    private UsuarioServicio usuarioServicio ;

@PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest){

    //metodo para buscar el correo
    Usuario user = usuarioServicio.findByCorreo(loginRequest.getCorreo());

    //en caso de que user sea null
    if (user==null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: El usuario no existe");
    }

    //validacion de password
    if (!user.getPassword().equals(loginRequest.getPassword())){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Error: Credenciales incorrectas.");
    }

    LoginResponse response = new LoginResponse(
            user.getIdUsuario(),
            user.getNombre(),
            user.getCorreo(),
            user.getRol(),
            true
    );
   return ResponseEntity.ok(response);
}

@PutMapping ("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody RecuRequest request){

// Llamamos al service que devuelve Usuario o null
    Usuario usuarioActualizado = usuarioServicio.updatePassword(
            request.getCorreo(),
            request.getPassword()
    );

    // 2. Si es null, el correo no existía
    if (usuarioActualizado == null) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Error: No se encontró ningún usuario registrado con el correo: " + request.getCorreo());
    }

    // 3. Si todo salió bien
    return ResponseEntity.ok("¡Éxito! La contraseña ha sido actualizada correctamente.");

}

}
