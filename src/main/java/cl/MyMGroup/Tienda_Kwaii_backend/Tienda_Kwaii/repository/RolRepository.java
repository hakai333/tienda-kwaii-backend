package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.repository;

import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
    Rol findByNombre(String nombre);
}
