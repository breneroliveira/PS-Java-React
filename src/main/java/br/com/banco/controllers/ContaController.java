package br.com.banco.controllers;

import br.com.banco.dto.ContaMapper;
import br.com.banco.dto.ContaResponseDTO;
import br.com.banco.entities.Conta;
import br.com.banco.services.ContaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(originPatterns = "*", origins = "*", allowedHeaders = "*")
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Page<ContaResponseDTO>> findAll(@PageableDefault Pageable pageable) throws Exception {

        return ResponseEntity.ok(contaService.findAll(pageable).map(ContaMapper::fromEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable long id) {
        try {
            Optional<Conta> conta = contaService.findById(id);

            if(conta.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe registro com ID " + id);
            else
                return ResponseEntity.status(HttpStatus.OK).body(conta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Conta conta) {
        try {
            contaService.save(conta);
            return ResponseEntity.status(HttpStatus.CREATED).body(conta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody Conta conta) {
        try {
            conta.setIdConta(id);
            contaService.update(conta, id);
            return ResponseEntity.status(HttpStatus.OK).body(conta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        try {
            contaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Registro com ID " + id + " deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}