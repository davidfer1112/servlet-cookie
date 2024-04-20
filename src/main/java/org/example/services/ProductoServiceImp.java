package org.example.services;

import org.example.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImp implements ProductoService{

    @Override
    public List<Producto> getAll() {
        return Arrays.asList(new Producto(1L, "Mause", "Periferico", 1000),
                new Producto(2L, "Teclado", "Periferico", 2000),
                new Producto(3L, "Monitor", "Accesorio", 3000),
                new Producto(4L, "CPU", "Componente", 4000),
                new Producto(5L, "Parlantes", "Periferico", 5000),
                new Producto(6L, "Impresora", "Accesorio", 6000),
                new Producto(7L, "Webcam", "Accesorio", 7000),
                new Producto(8L, "Microfono", "Accesorio", 8000),
                new Producto(9L, "Audifonos", "Accesorio", 9000));
    }

}
