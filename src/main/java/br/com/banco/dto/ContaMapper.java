package br.com.banco.dto;

import br.com.banco.entities.Conta;

public class ContaMapper {

    public static Conta fromDTO(ContaRequestDTO dto) {
        return new Conta(dto.getNomeResponsavel());
    }

    public static ContaResponseDTO fromEntity(Conta conta) {
        return new ContaResponseDTO(conta.getIdConta(), conta.getNomeResponsavel());
    }
}