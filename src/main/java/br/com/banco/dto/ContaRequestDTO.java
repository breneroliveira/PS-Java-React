package br.com.banco.dto;

public class ContaRequestDTO {

    private String nomeResponsavel;

    public ContaRequestDTO() {

    }

    public ContaRequestDTO(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}