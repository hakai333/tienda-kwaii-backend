package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.controller;

import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Usuario;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5174")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> registro(@RequestBody Usuario usuario) {
        usuario.setEmail(usuario.getEmail().trim().toLowerCase());
        String mensaje = usuarioService.registro(usuario);

        if(mensaje.equals("El email ya esta registrado")){
            return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje",mensaje));
        }
        return ResponseEntity.ok(Collections.singletonMap("mensaje",mensaje));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String contrasena = credentials.get("contrasena");

        Usuario usuario = usuarioService.login(email, contrasena); // devuelve Usuario o null

        if (usuario != null) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Login exitoso");
            response.put("rol", usuario.getRol().toString()); // <-- aquí agregamos el rol
            response.put("email", usuario.getEmail());
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401)
                .body(Collections.singletonMap("mensaje", "Usuario o contraseña incorrectos"));
    }




}
