package br.edu.nassau.apicursosbefw.controller;

import br.edu.nassau.apicursosbefw.dto.CursoDTOs;
import br.edu.nassau.apicursosbefw.model.Curso;
import br.edu.nassau.apicursosbefw.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Endpoint de teste:
    @GetMapping("/mensagem")
    public String mensagem(CursoService cursoService) {
        return cursoService.olaMundo();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDTOs.Exibir criarCurso(@RequestBody CursoDTOs.Criar criarCursoDto) {
        try {
            Curso novoCurso = cursoService.criarCurso(criarCursoDto.nome(), criarCursoDto.cargaHoraria());
            return new CursoDTOs.Exibir(novoCurso.getNome(), novoCurso.getCargaHoraria());
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public Curso buscarCursoPorId(@PathVariable Long id) {
        try {
            return cursoService.buscarCursoPorId(id);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Curso atualizarCurso(@PathVariable Long id, @RequestBody CursoDTOs.Atualizar atualizarCursoDto) {
        try {
            return cursoService.atualizarCurso(id, atualizarCursoDto.nome(), atualizarCursoDto.cargaHoraria());
        } catch (RuntimeException ex) {
            // Lógica primitiva para diferenciar os tipos de erros:
            String[] exMessage = ex.getMessage().split(" : ");
            int responseCode = Integer.parseInt(exMessage[0]);
            String errorMsg = exMessage[1];

            throw new ResponseStatusException(HttpStatusCode.valueOf(responseCode), errorMsg);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCurso(@PathVariable Long id) {
        try {
            cursoService.removerCurso(id);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
