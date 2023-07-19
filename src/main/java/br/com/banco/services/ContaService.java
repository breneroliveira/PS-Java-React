package br.com.banco.services;

import br.com.banco.entities.Conta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ContaService {

    Page<Conta> findAll(Pageable pageable) throws Exception;
    Optional<Conta> findById(long id) throws Exception;
    Conta save(Conta conta) throws Exception;
    Conta update(Conta conta, long id) throws Exception;
    void deleteById(long id) throws Exception;
}