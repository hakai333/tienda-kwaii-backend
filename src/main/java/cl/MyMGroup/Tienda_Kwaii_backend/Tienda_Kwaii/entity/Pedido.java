package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_pedido", nullable = false)
    private LocalDateTime fechaPedido = LocalDateTime.now();

    @Column(nullable = false)
    private Double precioTotal;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado = EstadoPedido.PENDIENTE;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
