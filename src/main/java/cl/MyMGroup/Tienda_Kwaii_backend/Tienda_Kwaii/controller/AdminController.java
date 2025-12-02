package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.controller;

import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Producto;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Usuario;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.service.ProductoService;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5174")
public class AdminController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProductoService productoService;



    //CRUD USUARIOS


    // LISTAR TODOS LOS USUARIOS
    @GetMapping("/usuarios")
    public ResponseEntity<?> listarUsuarios() {
        List<Usuario> lista = usuarioService.listarUsuarios();
        return ResponseEntity.ok(lista);
    }

    // EDITAR USUARIO (Nombre, Email, Rol)
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> editarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario datos
    ) {
        Usuario actualizado = usuarioService.editarUsuario(id, datos);
        if (actualizado == null) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", "Usuario no encontrado"));
        }
        return ResponseEntity.ok(actualizado);
    }

    // ELIMINAR USUARIO
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        boolean eliminado = usuarioService.eliminarUsuario(id);
        if (!eliminado) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", "No se pudo eliminar el usuario"));
        }
        return ResponseEntity.ok(Map.of("mensaje", "Usuario eliminado correctamente"));
    }



    // CRUD PRODUCTOS


    // LISTAR TODOS LOS PRODUCTOS
    @GetMapping("/productos")
    public ResponseEntity<?> listarProductos() {
        List<Producto> lista = productoService.listarProductos();
        return ResponseEntity.ok(lista);
    }

    // INGRESAR PRODUCTO
    @PostMapping("/productos")
    public ResponseEntity<?> crearProducto(@RequestBody Producto p) {
        Producto creado = productoService.crearProducto(p);
        return ResponseEntity.ok(creado);
    }

    // EDITAR PRODUCTO
    @PutMapping("/productos/{id}")
    public ResponseEntity<?> editarProducto(
            @PathVariable Long id,
            @RequestBody Producto datos
    ) {
        Producto actualizado = productoService.editarProducto(id, datos);
        if (actualizado == null) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", "Producto no encontrado"));
        }
        return ResponseEntity.ok(actualizado);
    }

    // ELIMINAR PRODUCTO
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        boolean eliminado = productoService.eliminarProducto(id);
        if (!eliminado) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", "No se pudo eliminar el producto"));
        }
        return ResponseEntity.ok(Map.of("mensaje", "Producto eliminado correctamente"));
    }



}
