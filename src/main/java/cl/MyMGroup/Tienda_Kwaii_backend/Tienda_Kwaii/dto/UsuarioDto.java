package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
}
