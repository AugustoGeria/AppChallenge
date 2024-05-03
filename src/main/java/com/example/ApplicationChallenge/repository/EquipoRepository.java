package com.example.ApplicationChallenge.repository;

import com.example.ApplicationChallenge.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    List<Equipo> findByNombreContaining(String nombre);
}
