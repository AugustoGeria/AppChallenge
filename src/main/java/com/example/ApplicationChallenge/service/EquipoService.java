package com.example.ApplicationChallenge.service;

import com.example.ApplicationChallenge.model.Equipo;

import java.util.List;

public interface EquipoService {
    List<Equipo> findAllEquipos();

    Equipo findEquipoById(Long id);

    List<Equipo> findEquiposByNombre(String nombre);

    Equipo createEquipo(Equipo equipo);

    Equipo updateEquipo(Equipo equipo);

    void deleteEquipo(Long id);
}
