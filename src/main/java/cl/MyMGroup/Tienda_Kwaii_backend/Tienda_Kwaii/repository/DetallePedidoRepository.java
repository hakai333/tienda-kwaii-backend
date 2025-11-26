package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.repository;

import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {

    List<DetallePedido> findAllByPedidoId(Long pedidoId);

}
