package com.huellitas.vetturno.repository;

import com.huellitas.vetturno.model.Cita;
import com.huellitas.vetturno.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    // Detecta si un veterinario ya tiene una cita en ese horario exacto
    boolean existsByVeterinarioAndFechaHora(Veterinario veterinario, LocalDateTime fechaHora);

    // Consulta agenda filtrada por veterinario
    List<Cita> findByVeterinarioId(Long veterinarioId);
}