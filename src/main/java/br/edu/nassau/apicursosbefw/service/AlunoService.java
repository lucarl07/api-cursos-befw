package br.edu.nassau.apicursosbefw.service;

import br.edu.nassau.apicursosbefw.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }
}
