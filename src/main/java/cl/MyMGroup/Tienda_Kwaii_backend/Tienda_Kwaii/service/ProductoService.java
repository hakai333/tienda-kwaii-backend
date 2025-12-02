package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.service;

import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.entity.Producto;
import cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto crearProducto(Producto p) {
        return productoRepository.save(p);
    }

    public Producto editarProducto(Long id, Producto datos) {
        return productoRepository.findById(id).map(prod -> {
            prod.setNombre(datos.getNombre());
            prod.setPrecio(datos.getPrecio());
            prod.setStock(datos.getStock());
            prod.setImagenUrl(datos.getImagenUrl());
            prod.setDescripcion(datos.getDescripcion());
            return productoRepository.save(prod);
        }).orElse(null);
    }

    public boolean eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) return false;
        productoRepository.deleteById(id);
        return true;
    }
}
