package br.com.banco.dto;

import br.com.banco.entities.Transferencia;

public class TransferenciaMapper {

    public static Transferencia fromDTO(TransferenciaRequestDTO dto) {
        return new Transferencia(dto.getDataTransferencia(), dto.getValor(),
                                 dto.getTipo(), dto.getNomeOperadorTransacao());
    }

    public static TransferenciaResponseDTO fromEntity(Transferencia transferencia) {
        return new TransferenciaResponseDTO(transferencia.getId(), transferencia.getDataTransferencia(),
                                            transferencia.getValor(), transferencia.getTipo(),
                                            transferencia.getNomeOperadorTransacao(), transferencia.getConta());
    }
}