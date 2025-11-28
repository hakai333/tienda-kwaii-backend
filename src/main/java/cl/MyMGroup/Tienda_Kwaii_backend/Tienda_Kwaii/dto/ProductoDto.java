package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagenUrl;
    private String categoria;
    private Boolean activo = true;
}
