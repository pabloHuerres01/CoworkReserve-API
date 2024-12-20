package com.example.coworkreserve.controller;

import com.example.coworkreserve.model.Reserva;
import com.example.coworkreserve.repository.ReservaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;


import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createReserva(@Valid @RequestBody Reserva reserva) {
        if (!reserva.isFechaFinValida()) {
            return ResponseEntity.badRequest().body("La fecha de fin debe ser posterior a la fecha de inicio.");
        }

        boolean conflict = reservaRepository.existsByEspacioAndFechaInicioBeforeAndFechaFinAfter(
                reserva.getEspacio(), reserva.getFechaFin(), reserva.getFechaInicio());
        if (conflict) {
            return ResponseEntity.badRequest().body("El espacio ya está reservado en ese rango de fechas.");
        }

        return ResponseEntity.ok(reservaRepository.save(reserva));
    }
}
