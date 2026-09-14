package br.edu.nassau.apicursosbefw.dto;

public class CursoDTOs {
    // NOTA: Eu sei que, no momento, todos os records abaixo são redundantes, mas os diferenciei para fins
    // demonstrativos e de boas práticas.
    public record Criar(String nome, Integer cargaHoraria) {};
    public record Atualizar(String nome, Integer cargaHoraria) {};
    public record Exibir(String nome, Integer cargaHoraria) {};
}
