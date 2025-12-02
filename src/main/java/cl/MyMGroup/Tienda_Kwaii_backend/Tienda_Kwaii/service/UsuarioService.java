package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.service;


import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.dto.UsuarioDto;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Rol;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Usuario;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //REGISTRO
    public String registro(Usuario usuario) {
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            return "El email ya esta registrado";
        }

        if(usuario.getRol() == null) {
            usuario.setRol(Rol.USUARIO);
        }

        usuario.setEmail(usuario.getEmail().trim().toLowerCase());
        usuarioRepository.save(usuario);
        return "Usuario registrado correctamente";
    }


    //INCIO DE SESION
    public Usuario login(String email, String contrasena) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email);

        if (optionalUsuario.isEmpty()) {
            return null; // usuario no encontrado
        }

        Usuario usuario = optionalUsuario.get();

        if (!usuario.getContrasena().equals(contrasena)) {
            return null; // contraseña incorrecta
        }

        return usuario; // login exitoso
    }


    //CRUD

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario editarUsuario(Long id, Usuario datos) {
        return usuarioRepository.findById(id).map(u -> {
            u.setNombre(datos.getNombre());
            u.setEmail(datos.getEmail());
            u.setRol(datos.getRol());
            return usuarioRepository.save(u);
        }).orElse(null);
    }

    public boolean eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) return false;
        usuarioRepository.deleteById(id);
        return true;
    }



}
