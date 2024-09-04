package com.example.academic_system.controller;

import com.example.academic_system.model.Turma;
import com.example.academic_system.service.EstudanteService;
import com.example.academic_system.service.ProfessorService;
import com.example.academic_system.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private ProfessorService professorService;
    
    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public String getAllTurmas(Model model) {
        List<Turma> turmas = turmaService.findAll();
        model.addAttribute("turmas", turmas);
        return "turmas/list";
    }

    @GetMapping("/new")
    public String createTurmaForm(Model model) {
        model.addAttribute("turma", new Turma());
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("todosEstudantes", estudanteService.findAll());
        return "turmas/form";
    }

    @GetMapping("/edit/{id}")
    public String editTurmaForm(@PathVariable Long id, Model model) {
        Turma turma = turmaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid turma Id:" + id));
        model.addAttribute("turma", turma);
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("todosEstudantes", estudanteService.findAll());
        return "turmas/form";
    }

    @PostMapping
    public String saveTurma(@ModelAttribute Turma turma) {
        turmaService.save(turma);
        return "redirect:/turmas";
    }


    @GetMapping("/delete/{id}")
    public String deleteTurma(@PathVariable Long id) {
        turmaService.delete(id);
        return "redirect:/turmas";
    }
}
