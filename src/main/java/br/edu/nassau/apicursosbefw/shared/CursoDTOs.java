package br.edu.nassau.apicursosbefw.shared;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CursoDTOs {
    // NOTA: Eu sei que, no momento, a maioria dos records abaixo são redundantes, mas os diferenciei para fins
    // demonstrativos e de boas práticas... e de escalabilidade.

    public record CriarCursoRequest(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotNull(message = "Carga horária é obrigatória")
        @Positive(message = "Carga horária deve ser maior que zero")
        Integer cargaHoraria
    ) {};
    public record CriarCursoResponse(String nome, Integer cargaHoraria) {};

    public record ListarCursoResponse(String nome, Integer cargaHoraria) {}

    public record ListarCursoComIdResponse(Long id, String nome, Integer cargaHoraria) {}

    public record AtualizarCursoRequest(
        @NotBlank(message = "O nome deve ter um valor não vazio.")
        String nome,

        @Min(value = 1L, message = "A carga horária deve ser maior do que 0 (zero).")
        Integer cargaHoraria
    ) {};
    public record AtualizarCursoResponse(Long id, String nome, Integer cargaHoraria) {};
}
