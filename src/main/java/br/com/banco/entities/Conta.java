package br.com.banco.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long idConta;

    @Column(name = "nome_responsavel", length = 50, nullable = false)
    private String nomeResponsavel;

    public Conta() {

    }

    public Conta(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}