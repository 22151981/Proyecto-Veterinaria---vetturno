package com.huellitas.vetturno.service;

import com.huellitas.vetturno.dto.PropietarioDTO;
import com.huellitas.vetturno.dto.PropietarioRequest;
import com.huellitas.vetturno.model.Propietario;
import com.huellitas.vetturno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    @Transactional
    public PropietarioDTO crear(PropietarioRequest request) {
        Propietario propietario = new Propietario(
                request.getNombre(),
                request.getTelefono(),
                request.getEmail()
        );
        return toDTO(propietarioRepository.save(propietario));
    }

    @Transactional(readOnly = true)
    public List<PropietarioDTO> listarTodos() {
        return propietarioRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    private PropietarioDTO toDTO(Propietario propietario) {
        return new PropietarioDTO(
                propietario.getId(),
                propietario.getNombre(),
                propietario.getTelefono(),
                propietario.getEmail()
        );
    }
}
