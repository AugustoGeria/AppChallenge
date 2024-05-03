package com.example.ApplicationChallenge.controller;


import com.example.ApplicationChallenge.model.Equipo;
import com.example.ApplicationChallenge.service.EquipoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
@AllArgsConstructor
public class EquipoController {

    private final EquipoService equipoService;

    @GetMapping
    public ResponseEntity<List<Equipo>> findAllEquipos() {
        var equipos = equipoService.findAllEquipos();
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> findEquipoById(@PathVariable("id") Long id) {
        var equipo = equipoService.findEquipoById(id);
        return new ResponseEntity<>(equipo, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Equipo>> findEquiposByNombre(@RequestParam("nombre") String nombre) {
        var equipos = equipoService.findEquiposByNombre(nombre);
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Equipo> createEquipo(@Valid @RequestBody Equipo equipo) {
        var newEquipo = equipoService.createEquipo(equipo);
        return new ResponseEntity<>(newEquipo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable("id") Long id, @Valid @RequestBody Equipo equipo) {
        equipo.setId(id);
        var updateEquipo = equipoService.updateEquipo(equipo);
        return new ResponseEntity<>(updateEquipo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable("id") Long id) {
        equipoService.deleteEquipo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
