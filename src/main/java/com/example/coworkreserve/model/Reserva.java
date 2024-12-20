package com.example.coworkreserve.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El usuario es obligatorio.")
    @ManyToOne
    private Usuario usuario;

    @NotNull(message = "El espacio es obligatorio.")
    @ManyToOne
    private Espacio espacio;

    @NotNull(message = "La fecha de inicio es obligatoria.")
    @FutureOrPresent(message = "La fecha de inicio debe ser en el presente o futuro.")
    private LocalDateTime fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria.")
    private LocalDateTime fechaFin;

    // Validación personalizada en el modelo (no puede ser anterior a la fecha de inicio)
    public boolean isFechaFinValida() {
        return fechaFin != null && fechaInicio != null && fechaFin.isAfter(fechaInicio);
    }

    // Getters y setters...

    // Getters y Setters
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }
}
