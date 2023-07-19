package br.com.banco.services;

import br.com.banco.entities.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TransferenciaService {

    Page<Transferencia> findAll(Pageable pageable) throws Exception;
    Optional<Transferencia> findById(long id) throws Exception;
    Transferencia save(Transferencia transferencia) throws Exception;
    Transferencia update(Transferencia transferencia, long id) throws Exception;
    void deleteById(long id) throws Exception;
}