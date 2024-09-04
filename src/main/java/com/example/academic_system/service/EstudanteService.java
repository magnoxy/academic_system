package com.example.academic_system.service;

import com.example.academic_system.model.Estudante;
import com.example.academic_system.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;
  

    public Estudante save(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public List<Estudante> findAll() {
        return estudanteRepository.findAll();
    }
    

    public Optional<Estudante> findById(Long id) {
        return estudanteRepository.findById(id);
    }

    public Estudante update(Long id, Estudante estudanteDetails) {
        Estudante estudante = estudanteRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudante not found"));
        estudante.setNome(estudanteDetails.getNome());
        estudante.setEmail(estudanteDetails.getEmail());
        return estudanteRepository.save(estudante);
    }

    public void delete(Long id) {
        Estudante estudante = estudanteRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudante not found"));
        estudanteRepository.delete(estudante);
    }
}
