package br.edu.nassau.apicursosbefw.controller;

import br.edu.nassau.apicursosbefw.service.CursoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/mensagem")
    public String mensagem(CursoService cursoService) {
        return cursoService.olaMundo();
    }
}
