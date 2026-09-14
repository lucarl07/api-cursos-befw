package br.edu.nassau.apicursosbefw.repository;

import br.edu.nassau.apicursosbefw.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();

    private static Long contadorCursos = 1L;

    private Curso _buscarCursoPorId(Long id) { // Método local
        return cursos.stream()
            .filter(curso -> curso.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public Curso criarCurso(String nome, Integer cargaHoraria) {
        Curso novoCurso = new Curso(contadorCursos++, nome, cargaHoraria);
        cursos.add(novoCurso);
        return novoCurso;
    }

    public List<Curso> listarCursos() {
        return cursos;
    }

    public Curso buscarCursoPorId(Long id) {
        return _buscarCursoPorId(id);
    }

    public Curso atualizarCurso(Long id, String nome, Integer cargaHoraria) {
        Curso curso = this._buscarCursoPorId(id);
        if (curso == null) return null;

        curso.setNome(nome);
        curso.setCargaHoraria(cargaHoraria);

        return curso;
    }

    public boolean removerCurso(Long id) {
        return cursos.removeIf(curso -> curso.getId().equals(id));
    }
}
