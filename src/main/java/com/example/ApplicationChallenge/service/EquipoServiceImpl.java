package com.example.ApplicationChallenge.service;

import com.example.ApplicationChallenge.exception.NotFoundRequestException;
import com.example.ApplicationChallenge.model.Equipo;
import com.example.ApplicationChallenge.repository.EquipoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    @Override
    public List<Equipo> findAllEquipos() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo findEquipoById(Long id) {
        return equipoRepository.findById(id).orElseThrow(NotFoundRequestException::new);
    }

    @Override
    public List<Equipo> findEquiposByNombre(String nombre) {
        return equipoRepository.findByNombreContaining(nombre);
    }

    @Override
    public Equipo createEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public Equipo updateEquipo(Equipo equipo) {
        findEquipoById(equipo.getId());
        return equipoRepository.save(equipo);
    }

    @Override
    public void deleteEquipo(Long id) {
        findEquipoById(id);
        equipoRepository.deleteById(id);
    }
}
