package br.edu.nassau.apicursosbefw.service;

import br.edu.nassau.apicursosbefw.model.Curso;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {
    private List<Curso> cursos = new ArrayList<>();

    public String olaMundo() {
        return "Olá, mundo!";
    }

    public Curso criarCurso(String nome, Integer cargaHoraria) {
        if (nome.isBlank()) {
            throw new RuntimeException("O nome deve ter um valor não-vazio.");
        }

        if (cargaHoraria <= 0) {
            throw new RuntimeException("A carga horária deve ser maior do que 0 (zero).");
        }

        Curso novoCurso = new Curso(true, nome, cargaHoraria);
        cursos.add(novoCurso);
        return novoCurso;
    }

    public List<Curso> listarCursos() {
        return cursos;
    }

    public Curso buscarCursoPorId(Long id) {
        return cursos.stream()
            .filter(curso -> curso.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException(
                "Não foi encontrado nenhum usuário de ID " + id + "."
            ));
    }

    public Curso atualizarCurso(Long id, String nome, Integer cargaHoraria) {
        Curso curso = this.buscarCursoPorId(id);
        curso.setNome(nome);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    public void removerCurso(Long id) {
        boolean cursoFoiRemovido = cursos.removeIf(curso -> curso.getId().equals(id));

        if (!cursoFoiRemovido) {
            throw new RuntimeException(
                "Não foi encontrado nenhum usuário de ID " + id + "."
            );
        }
    }
}
