package com.example.academic_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.academic_system.model.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante , Long>{

}
