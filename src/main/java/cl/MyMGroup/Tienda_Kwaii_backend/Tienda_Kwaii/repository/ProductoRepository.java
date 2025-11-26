package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.repository;

import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Producto;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Rol;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.TipoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    List<Producto> findAllByActivoTrue();

    // Buscar Producto por su Categoria y si esta activo
    List<Producto> findAllByCategoriaIdAndActivoTrue(Long categoriaId);

    // Buscar Producto por su Tipo de Venta
    List<Producto> findAllByTipoVentaAndActivoTrue(TipoVenta tipoVenta);
}
