package br.edu.nassau.apicursosbefw.model;

public class Curso {
    private Long id;
    private String nome;
    private Integer cargaHoraria;

    private static Long contadorCursos = 1L;

    private void _setIdToNextNumber() {
        this.id = contadorCursos++;
    }

    public Curso() {
        _setIdToNextNumber();
    }

    public Curso(boolean autogenerateId, String nome, Integer cargaHoraria) {
        if (autogenerateId) {
            _setIdToNextNumber();
        }
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
