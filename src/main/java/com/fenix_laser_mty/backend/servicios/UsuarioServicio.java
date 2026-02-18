package com.fenix_laser_mty.backend.servicios;

import com.fenix_laser_mty.backend.excepciones.UsuarioNotFoundException;
import com.fenix_laser_mty.backend.modelos.Usuario;
import com.fenix_laser_mty.backend.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServicio(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Metodo para recuperar a todos los usuarios

    public List<Usuario> getUsuarios(){

        //metodo abstracto
        return usuarioRepository.findAll();
    }

    //Metodo para crear nuevas instancias
    public Usuario createUsuario(Usuario newUsuario){
        //encriptando password del usuario
        // ojito   String ecryptedPassword= passwordEncoder.encode((newUsuario.getPassword()));
        //   newUsuario.setPassword(ecryptedPassword);

        return usuarioRepository.save(newUsuario);

    }

    public Usuario findByCorreo(String userName){
        return usuarioRepository.findByCorreo(userName);
    }

    public  Usuario findById(Integer id){
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id ));

    }

    //metodo para eliminar instancias
    public void deletUsuario(Integer id){

        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }else{
            throw new UsuarioNotFoundException(id);
        }

    }

    public Usuario updateUsuario(Usuario usuario, Integer id){

        return usuarioRepository.findById(id)
                .map(usuarioData ->{
                    usuarioData.setNombre(usuario.getNombre());
                    usuarioData.setCorreo(usuario.getCorreo());
                    usuarioData.setTelefono(usuario.getTelefono());
                    usuarioData.setPassword(usuario.getPassword());

                    return  usuarioRepository.save(usuarioData);

                }).orElseThrow(()-> new UsuarioNotFoundException(id));

    }



    
    
}
