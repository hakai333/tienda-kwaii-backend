package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.repository;

import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.EstadoPedido;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    // Lista de Todos los pedidos de un usuario especifico
    List<Pedido> findAllByUsuarioId(Long usuarioId);

    List<Pedido> findAllByEstado(EstadoPedido estadoPedido);
}
