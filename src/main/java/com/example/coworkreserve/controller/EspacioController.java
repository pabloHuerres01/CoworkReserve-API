package com.example.coworkreserve.controller;

import com.example.coworkreserve.model.Espacio;
import com.example.coworkreserve.repository.EspacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espacios")
public class EspacioController {

    @Autowired
    private EspacioRepository espacioRepository;

    // Obtener todos los espacios
    @GetMapping
    public List<Espacio> getAllEspacios() {
        return espacioRepository.findAll();
    }

    // Obtener un espacio por ID
    @GetMapping("/{id}")
    public Espacio getEspacioById(@PathVariable Long id) {
        return espacioRepository.findById(id).orElse(null);
    }

    // Crear un nuevo espacio
    @PostMapping
    public Espacio createEspacio(@RequestBody Espacio espacio) {
        return espacioRepository.save(espacio);
    }

    // Actualizar un espacio
    @PutMapping("/{id}")
    public Espacio updateEspacio(@PathVariable Long id, @RequestBody Espacio espacioDetails) {
        Espacio espacio = espacioRepository.findById(id).orElse(null);
        if (espacio != null) {
            espacio.setNombre(espacioDetails.getNombre());
            espacio.setCapacidad(espacioDetails.getCapacidad());
            espacio.setUbicacion(espacioDetails.getUbicacion());
            return espacioRepository.save(espacio);
        }
        return null;
    }

    // Eliminar un espacio
    @DeleteMapping("/{id}")
    public void deleteEspacio(@PathVariable Long id) {
        espacioRepository.deleteById(id);
    }
}
