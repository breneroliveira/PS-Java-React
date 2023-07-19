package br.com.banco.controllers;

import br.com.banco.dto.TransferenciaResponseDTO;
import br.com.banco.dto.TransferenciaMapper;
import br.com.banco.entities.Transferencia;
import br.com.banco.services.TransferenciaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(originPatterns = "*", origins = "*", allowedHeaders = "*")
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Page<TransferenciaResponseDTO>> findAll(@PageableDefault Pageable pageable) throws Exception {

        return ResponseEntity.ok(transferenciaService.findAll(pageable).map(TransferenciaMapper::fromEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable long id) {
        try {
            Optional<Transferencia> transferencia = transferenciaService.findById(id);

            if(transferencia.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe registro com ID " + id);
            else
                return ResponseEntity.status(HttpStatus.OK).body(transferencia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Transferencia transferencia) {
        try {
            transferenciaService.save(transferencia);
            return ResponseEntity.status(HttpStatus.CREATED).body(transferencia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody Transferencia transferencia) {
        try {
            transferencia.setId(id);
            transferenciaService.update(transferencia, id);
            return ResponseEntity.status(HttpStatus.OK).body(transferencia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        try {
            transferenciaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Registro com ID " + id + " deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}