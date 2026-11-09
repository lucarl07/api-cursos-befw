package br.edu.nassau.apicursosbefw.repository;

import br.edu.nassau.apicursosbefw.model.Aluno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepository {
    public List<Aluno> alunos = new ArrayList<>();

    private static Long contadorAlunos = 1L;

    private Aluno _buscarAlunoPorId(Long id) {
        return alunos.stream()
            .filter(curso -> curso.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public Aluno buscarAlunoPorId(Long id) {
        return this._buscarAlunoPorId(id);
    }

    public List<Aluno> listarAlunos(Long id) {
        return alunos;
    }

    public Aluno criarAluno(String nome, String curso) {
        Aluno novoAluno = new Aluno(contadorAlunos++, nome, curso);
        alunos.add(novoAluno);
        return novoAluno;
    }

    public Aluno atualizarAluno(Long id, String nome, String curso) {
        Aluno aluno = this._buscarAlunoPorId(id);
        if (aluno == null) return null;

        aluno.setNome(nome);
        aluno.setCurso(curso);

        return aluno;
    }

    public boolean removerAluno(Long id) {
        return alunos.removeIf(aluno -> aluno.getId().equals(id));
    }
}
