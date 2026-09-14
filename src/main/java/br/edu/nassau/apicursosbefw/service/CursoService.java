package br.edu.nassau.apicursosbefw.service;

import br.edu.nassau.apicursosbefw.model.Curso;
import br.edu.nassau.apicursosbefw.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    // Serviço de teste:
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

        return repository.criarCurso(nome, cargaHoraria);
    }

    public List<Curso> listarCursos() {
        return repository.listarCursos();
    }

    public Curso buscarCursoPorId(Long id) {
        Curso curso = repository.buscarCursoPorId(id);

        if (curso == null) {
            throw new RuntimeException("Não foi encontrado nenhum usuário de ID " + id + ".");
        }

        return curso;
    }

    public Curso atualizarCurso(Long id, String nome, Integer cargaHoraria) {
        Curso curso = repository.atualizarCurso(id, nome, cargaHoraria);

        if (curso == null) {
            throw new RuntimeException("Não foi encontrado nenhum usuário de ID " + id + ".");
        }

        return curso;
    }

    public void removerCurso(Long id) {
        boolean cursoFoiRemovido = repository.removerCurso(id);

        if (!cursoFoiRemovido) {
            throw new RuntimeException("Não foi encontrado nenhum usuário de ID " + id + ".");
        }
    }
}
