package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.repository;

import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
