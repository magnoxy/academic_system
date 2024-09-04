package com.example.academic_system.service;

import com.example.academic_system.model.Turma;
import com.example.academic_system.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> findById(Long id) {
        return turmaRepository.findById(id);
    }

    public Turma update(Long id, Turma turmaDetails) {
        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new RuntimeException("Turma not found"));
        turma.setNome(turmaDetails.getNome());
        turma.setProfessor(turmaDetails.getProfessor());
        turma.setEstudantes(turmaDetails.getEstudantes());
        return turmaRepository.save(turma);
    }

    public void delete(Long id) {
        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new RuntimeException("Turma not found"));
        turmaRepository.delete(turma);
    }
}
