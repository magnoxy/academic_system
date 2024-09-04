package com.example.academic_system.controller;

import com.example.academic_system.model.Professor;
import com.example.academic_system.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public String getAllProfessores(Model model) {
        List<Professor> professores = professorService.findAll();
        model.addAttribute("professores", professores);
        return "professores/list";
    }

    @GetMapping("/new")
    public String createProfessorForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "professores/form";
    }

    @PostMapping
    public String saveProfessor(@ModelAttribute Professor professor) {
        professorService.save(professor);
        return "redirect:/professores";
    }

    @GetMapping("/edit/{id}")
    public String editProfessorForm(@PathVariable Long id, Model model) {
        Professor professor = professorService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid professor Id:" + id));
        model.addAttribute("professor", professor);
        return "professores/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professorService.delete(id);
        return "redirect:/professores";
    }
}
