package com.example.ApplicationChallenge.service;

import com.example.ApplicationChallenge.model.Equipo;
import com.example.ApplicationChallenge.repository.EquipoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EquipoServiceTest {

    @Mock
    private EquipoRepository equipoRepository;

    @InjectMocks
    private EquipoServiceImpl equipoService;

    @Test
    public void testFindAllEquipos(){
        Equipo equipo1 = new Equipo(1L, "Real Madrid", "La Liga", "España");
        Equipo equipo2 = new Equipo(2L, "FC Barcelona", "La Liga", "España");

        List<Equipo> equipos = Arrays.asList(equipo1,equipo2);
        when(equipoRepository.findAll()).thenReturn(equipos);

        List<Equipo> equiposResult = equipoService.findAllEquipos();

        assertNotNull(equiposResult);
        assertEquals(2, equiposResult.size());
        assertEquals(equipo1, equiposResult.get(0));
        assertEquals(equipo2, equiposResult.get(1));
    }
}
