package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.service;


import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


}
