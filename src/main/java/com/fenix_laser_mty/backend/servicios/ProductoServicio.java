package com.fenix_laser_mty.backend.servicios;

import com.fenix_laser_mty.backend.excepciones.ProductoNotFoundException;
import com.fenix_laser_mty.backend.modelos.Producto;
import com.fenix_laser_mty.backend.repositorios.ProductoRepository;
import com.fenix_laser_mty.backend.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServicio(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //Metodo para recuperar todos los productos
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    //Metodo para crear nuevas instancias
    public Producto createProducto(Producto newProducto) {
        return productoRepository.save(newProducto);
    }

    //metodo abstracto a la realidad
    public Producto findByNombre(String nombreProducto) {
        return productoRepository.findByNombreProducto(nombreProducto);

    }

    public Producto findById(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    public void deleteProducto(Integer id) {

        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            throw new ProductoNotFoundException(id);
        }

    }

    public Producto updateProducto(Producto producto, Integer id) {
        return productoRepository.findById(id)
                .map(productoData -> {
                    productoData.setNombre(producto.getNombre());
                    productoData.setPrecio(producto.getPrecio());
                    productoData.setImagen(producto.getImagen());
                    productoData.setDescripcion(producto.getDescripcion());
                    productoData.setCategoria(producto.getCategoria());
                    productoData.setRating(producto.getRating());
                    productoData.setEtiquetas(producto.getEtiquetas());
                    productoData.setVisibleCatalogo(producto.getVisibleCatalogo());
                    productoData.setVisibleRecomendados(producto.getVisibleRecomendados());

                    return productoRepository.save(productoData);
                }).orElseThrow(() -> new ProductoNotFoundException(id));

    }





}
