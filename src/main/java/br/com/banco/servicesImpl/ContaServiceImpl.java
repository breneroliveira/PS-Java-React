package br.com.banco.servicesImpl;

import br.com.banco.entities.Conta;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.services.ContaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService {

    private final ContaRepository contaRepository;

    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public Page<Conta> findAll(Pageable pageable) throws Exception {
        return this.contaRepository.findAll(pageable);
    }

    @Override
    public Optional<Conta> findById(long id) throws Exception {
        return this.contaRepository.findById(id);
    }

    @Override
    public Conta save(Conta conta) throws Exception {
        return this.contaRepository.save(conta);
    }

    @Override
    public Conta update(Conta conta, long id) throws Exception {
        if(!this.contaRepository.existsById(id))
            throw new Exception("Não existe registro com ID " + id);
        return this.contaRepository.save(conta);
    }

    @Override
    public void deleteById(long id) throws Exception {
        if(!this.contaRepository.existsById(id))
            throw new Exception("Não existe registro com ID " + id);
        this.contaRepository.deleteById(id);
    }
}