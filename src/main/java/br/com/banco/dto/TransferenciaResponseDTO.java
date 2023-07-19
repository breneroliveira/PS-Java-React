package br.com.banco.dto;

import br.com.banco.entities.Conta;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class TransferenciaResponseDTO {

    private Long id;
    private ZonedDateTime dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String nomeOperadorTransacao;
    private Conta conta;

    public TransferenciaResponseDTO(Long id, ZonedDateTime dataTransferencia, BigDecimal valor, String tipo, String nomeOperadorTransacao, Conta conta) {
        this.id = id;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.conta = conta;
    }

    public Long getId() {
        return id;
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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}