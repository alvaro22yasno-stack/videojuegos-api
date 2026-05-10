package com.example.videojuegosapi.controller;

import com.example.videojuegosapi.model.Videojuego;
import com.example.videojuegosapi.service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Map;



@RestController



@RequestMapping("/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoService service;

    // GET
    @GetMapping
    public List<Videojuego> listar() {
        return service.obtenerTodos();
    }

    // GET POR ID
    @GetMapping("/{id}")
    public Optional<Videojuego> buscarPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }


    @GetMapping("/estadisticas")
    public Map<String, Object> estadisticas() {
        return service.obtenerEstadisticas();
    }



    // POST
    @PostMapping
    public Videojuego guardar(@Valid @RequestBody Videojuego videojuego) {
        return service.guardar(videojuego);
    }

    // PUT
    @PutMapping("/{id}")
    public Videojuego actualizar(@PathVariable Long id,
                                 @RequestBody Videojuego videojuego) {

        videojuego.setId(id);
        return service.guardar(videojuego);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return service.eliminar(id);
    }



}