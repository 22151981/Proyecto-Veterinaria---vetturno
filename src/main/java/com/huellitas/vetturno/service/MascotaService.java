package com.huellitas.vetturno.service;

import com.huellitas.vetturno.dto.MascotaDTO;
import com.huellitas.vetturno.dto.MascotaRequest;
import com.huellitas.vetturno.model.Mascota;
import com.huellitas.vetturno.model.Propietario;
import com.huellitas.vetturno.repository.MascotaRepository;
import com.huellitas.vetturno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;

    public MascotaService(MascotaRepository mascotaRepository, PropietarioRepository propietarioRepository) {
        this.mascotaRepository = mascotaRepository;
        this.propietarioRepository = propietarioRepository;
    }

    @Transactional
    public MascotaDTO crear(MascotaRequest request) {
        Propietario propietario = propietarioRepository.findById(request.getPropietarioId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe un propietario con id " + request.getPropietarioId()));

        Mascota mascota = new Mascota(
                request.getNombre(),
                request.getEspecie(),
                request.getRaza(),
                propietario
        );
        return toDTO(mascotaRepository.save(mascota));
    }

    @Transactional(readOnly = true)
    public List<MascotaDTO> listarTodas() {
        return mascotaRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    private MascotaDTO toDTO(Mascota mascota) {
        return new MascotaDTO(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getEspecie(),
                mascota.getRaza(),
                mascota.getPropietario().getId(),
                mascota.getPropietario().getNombre()
        );
    }
}
