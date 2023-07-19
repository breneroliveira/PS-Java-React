package br.com.banco.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class TransferenciaRequestDTO {

    private ZonedDateTime dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String nomeOperadorTransacao;

    public TransferenciaRequestDTO() {

    }

    public TransferenciaRequestDTO(ZonedDateTime dataTransferencia, BigDecimal valor, String tipo, String nomeOperadorTransacao) {
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }

    public ZonedDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(ZonedDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeOperadorTransacao() {
        return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }
}