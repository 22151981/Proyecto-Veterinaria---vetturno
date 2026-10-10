package com.huellitas.vetturno.service;

import com.huellitas.vetturno.dto.VeterinarioDTO;
import com.huellitas.vetturno.dto.VeterinarioRequest;
import com.huellitas.vetturno.model.Veterinario;
import com.huellitas.vetturno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    @Transactional
    public VeterinarioDTO crear(VeterinarioRequest request) {
        Veterinario veterinario = new Veterinario(request.getNombre(), request.getEspecialidad());
        return toDTO(veterinarioRepository.save(veterinario));
    }

    @Transactional(readOnly = true)
    public List<VeterinarioDTO> listarTodos() {
        return veterinarioRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    private VeterinarioDTO toDTO(Veterinario veterinario) {
        return new VeterinarioDTO(
                veterinario.getId(),
                veterinario.getNombre(),
                veterinario.getEspecialidad()
        );
    }
}
