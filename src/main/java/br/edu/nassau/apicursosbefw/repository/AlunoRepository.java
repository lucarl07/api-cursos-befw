package br.edu.nassau.apicursosbefw.repository;

import br.edu.nassau.apicursosbefw.model.Aluno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepository {
    public List<Aluno> alunos = new ArrayList<>();

    private static Long contadorAlunos = 1L;
}
