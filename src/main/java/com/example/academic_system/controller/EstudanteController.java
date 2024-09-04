package com.example.academic_system.controller;

import com.example.academic_system.model.Estudante;
import com.example.academic_system.service.EstudanteService;
import com.example.academic_system.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public String getAllEstudantes(Model model) {
        List<Estudante> estudantes = estudanteService.findAll();
        model.addAttribute("estudantes", estudantes);
        return "estudantes/list";
    }

    @GetMapping("/new")
    public String createEstudanteForm(Model model) {
        model.addAttribute("estudante", new Estudante());
        model.addAttribute("turmas", turmaService.findAll());
        return "estudantes/form";
    }

    @PostMapping
    public String saveEstudante(@ModelAttribute Estudante estudante) {
        estudanteService.save(estudante);
        return "redirect:/estudantes";
    }

    @GetMapping("/edit/{id}")
    public String editEstudanteForm(@PathVariable Long id, Model model) {
        Estudante estudante = estudanteService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid estudante Id:" + id));
        model.addAttribute("estudante", estudante);
        model.addAttribute("turmas", turmaService.findAll());
        return "estudantes/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEstudante(@PathVariable Long id) {
        estudanteService.delete(id);
        return "redirect:/estudantes";
    }
}
