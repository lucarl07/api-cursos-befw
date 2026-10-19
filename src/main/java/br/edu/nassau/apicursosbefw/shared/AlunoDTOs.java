package br.edu.nassau.apicursosbefw.shared;

import jakarta.validation.constraints.NotBlank;

public class AlunoDTOs {
    public record CriarAlunoRequest(
        @NotBlank(message = "O nome do aluno não pode ser vazio.")
        String nome,

        @NotBlank(message = "O curso do aluno não pode ser vazio.")
        String curso
    ) {}
    public record CriarAlunoResponse(String nome, String curso) {}

    public record ListarAlunoResponse(String nome, String curso) {}

    public record ListarAlunoComIdResponse() {}

    public record AtualizarAlunoRequest(
        @NotBlank(message = "O nome do aluno não pode ser vazio.")
        String nome,

        @NotBlank(message = "O curso do aluno não pode ser vazio.")
        String curso
    ) {}
}
