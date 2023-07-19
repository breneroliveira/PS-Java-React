package br.com.banco.servicesImpl;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.services.TransferenciaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaServiceImpl(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    @Override
    public Page<Transferencia> findAll(Pageable pageable) throws Exception {
        return this.transferenciaRepository.findAll(pageable);
    }

    @Override
    public Optional<Transferencia> findById(long id) throws Exception {
        return this.transferenciaRepository.findById(id);
    }

    @Override
    public Transferencia save(Transferencia transferencia) throws Exception {
        return this.transferenciaRepository.save(transferencia);
    }

    @Override
    public Transferencia update(Transferencia transferencia, long id) throws Exception {
        if(!this.transferenciaRepository.existsById(id))
            throw new Exception("Não existe registro com ID " + id);
        return this.transferenciaRepository.save(transferencia);
    }

    @Override
    public void deleteById(long id) throws Exception {
        if(!this.transferenciaRepository.existsById(id))
            throw new Exception("Não existe registro com ID " + id);
        this.transferenciaRepository.deleteById(id);
    }
}