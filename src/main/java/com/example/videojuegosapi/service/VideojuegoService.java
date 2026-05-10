package com.example.videojuegosapi.service;

import com.example.videojuegosapi.model.Videojuego;
import com.example.videojuegosapi.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository repository;

    // LISTAR
    public List<Videojuego> obtenerTodos() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Optional<Videojuego> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    // GUARDAR
    public Videojuego guardar(Videojuego videojuego) {
        return repository.save(videojuego);
    }

    // ELIMINAR
    public String eliminar(Long id) {
        repository.deleteById(id);
        return "Videojuego eliminado";
    }


    public Map<String, Object> obtenerEstadisticas() {

        List<Videojuego> juegos = repository.findAll();

        int total = juegos.size();

        double sumaPrecios = 0;
        int juegosPC = 0;

        for (Videojuego v : juegos) {

            sumaPrecios += v.getPrecio();

            if (v.getPlataforma().equalsIgnoreCase("PC")) {
                juegosPC++;
            }
        }

        double porcentajePC = 0;

        if (total > 0) {
            porcentajePC = (juegosPC * 100.0) / total;
        }

        Map<String, Object> estadisticas = new HashMap<>();

        estadisticas.put("totalVideojuegos", total);
        estadisticas.put("precioTotal", sumaPrecios);
        estadisticas.put("porcentajePC", porcentajePC);

        return estadisticas;
    }
}