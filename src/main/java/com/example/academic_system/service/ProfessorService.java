package com.example.academic_system.service;

import com.example.academic_system.model.Professor;
import com.example.academic_system.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor update(Long id, Professor professorDetails) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor not found"));
        professor.setNome(professorDetails.getNome());
        professor.setEmail(professorDetails.getEmail());
        return professorRepository.save(professor);
    }

    public void delete(Long id) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor not found"));
        professorRepository.delete(professor);
    }
}
