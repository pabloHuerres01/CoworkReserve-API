package com.example.coworkreserve.repository;

import com.example.coworkreserve.model.Espacio;
import com.example.coworkreserve.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    boolean existsByEspacioAndFechaInicioBeforeAndFechaFinAfter(
            Espacio espacio, LocalDateTime fechaFin, LocalDateTime fechaInicio);
}
