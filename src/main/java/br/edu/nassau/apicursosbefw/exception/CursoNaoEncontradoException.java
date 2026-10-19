package br.edu.nassau.apicursosbefw.exception;

public class CursoNaoEncontradoException extends RuntimeException {
    public CursoNaoEncontradoException(Long id) {
        super("Curso de ID " + id + "não encontrado.");
    }
}
