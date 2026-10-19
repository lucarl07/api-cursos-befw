package br.edu.nassau.apicursosbefw.controller;

import br.edu.nassau.apicursosbefw.service.AlunoService;
import br.edu.nassau.apicursosbefw.shared.AlunoDTOs.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public CriarAlunoResponse criarAluno(@Valid @RequestBody CriarAlunoRequest criarAlunoDto) {
        // ...
    }

    @GetMapping
    public List<ListarAlunoResponse> listarAlunos() {
        // ...
    }

    @GetMapping("/{id}")
    public ListarAlunoComIdResponse buscarAlunoPorId() {
        // ...
    }
}
