package br.edu.nassau.apicursosbefw.shared;

public class CursoDTOs {
    // NOTA: Eu sei que, no momento, a maioria dos records abaixo são redundantes, mas os diferenciei para fins
    // demonstrativos e de boas práticas... e de escalabilidade.

    public record CriarCursoRequest(String nome, Integer cargaHoraria) {};
    public record CriarCursoResponse(String nome, Integer cargaHoraria) {};

    public record ListarCursoResponse(String nome, Integer cargaHoraria) {}

    public record ListarCursoComIdResponse(Long id, String nome, Integer cargaHoraria) {}

    public record AtualizarCursoRequest(String nome, Integer cargaHoraria) {};
    public record AtualizarCursoResponse(Long id, String nome, Integer cargaHoraria) {};
}
