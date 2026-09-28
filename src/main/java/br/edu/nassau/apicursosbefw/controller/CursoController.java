package br.edu.nassau.apicursosbefw.controller;

import br.edu.nassau.apicursosbefw.shared.CursoDTOs.*;
import br.edu.nassau.apicursosbefw.model.Curso;
import br.edu.nassau.apicursosbefw.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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
    public CriarCursoResponse criarCurso(@Valid @RequestBody CriarCursoRequest criarCursoDto) {
        try {
            Curso novoCurso = cursoService.criarCurso(
                criarCursoDto.nome(), criarCursoDto.cargaHoraria()
            );

            return new CriarCursoResponse(novoCurso.getNome(), novoCurso.getCargaHoraria());
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping
    public List<ListarCursoResponse> listarCursos() {
        List<ListarCursoResponse> cursos = new ArrayList<>();

        cursoService.listarCursos().forEach(
            curso -> cursos.add(
                new ListarCursoResponse(curso.getNome(), curso.getCargaHoraria())
            )
        );

        return cursos;
    }

    @GetMapping("/{id}")
    public ListarCursoComIdResponse buscarCursoPorId(@PathVariable Long id) {
        try {
            Curso curso = cursoService.buscarCursoPorId(id);

            return new ListarCursoComIdResponse(
                curso.getId(), curso.getNome(), curso.getCargaHoraria()
            );
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public AtualizarCursoResponse atualizarCurso(
        @PathVariable Long id, @RequestBody AtualizarCursoRequest atualizarCursoDto
    ) {
        try {
            Curso curso = cursoService.atualizarCurso(
                id, atualizarCursoDto.nome(), atualizarCursoDto.cargaHoraria()
            );

            return new AtualizarCursoResponse(
                curso.getId(), curso.getNome(), curso.getCargaHoraria()
            );
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
