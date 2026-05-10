package com.example.videojuegosapi.repository;

import com.example.videojuegosapi.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {

}