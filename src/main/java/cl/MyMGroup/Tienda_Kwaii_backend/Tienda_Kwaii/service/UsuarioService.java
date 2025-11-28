package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.service;


import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.dto.UsuarioDto;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Usuario;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //REGISTRO
    public String registro(UsuarioDto usuarioDto) {
        if(usuarioRepository.findByEmail(usuarioDto.getEmail()).isPresent()){
            return "El email ya esta registrado";
        }
        Usuario usuario = new Usuario(usuarioDto.getNombre(), usuarioDto.getApellido(), usuarioDto.getEmail(), usuarioDto.getContrasena());
        usuarioRepository.save(usuario);
        return "Usuario registrado";
    }


}
