package com.dho.processos.controller;

import com.dho.processos.model.Processo;
import com.dho.processos.model.Reu;
import com.dho.processos.service.ProcessoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/processos")
public class ProcessoController {

    private final ProcessoService service;

    ProcessoController(ProcessoService processoService) {
        this.service = processoService;
    }

    // CADASTRAR UM PROCESSO
    @PostMapping()
    public Processo createProcesso(@RequestBody Processo processo) {
        return service.createProcesso(processo);
    }

    // LISTAR TODOS OS PROCESSOS
    @GetMapping()
    public List<Processo> getAll() {
        return service.getAllProcessos();
    }

    // LISTAR PROCESSO POR ID
    @GetMapping("/{id}")
    public Processo getProcessoById(@PathVariable UUID id) {
        return service.getProcessoById(id);
    }

    // ATUALIZAR PROCESSO
    @PutMapping("/{id}")
    public Processo updateProcesso(@PathVariable UUID id, @RequestBody Processo updatedProcesso) {
        return service.updateProcesso(id, updatedProcesso);
    }

    // EXCLUIR PROCESSO
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProcesso(@PathVariable UUID id) {
        try {
            service.deleteProcesso(id);
            String mensagem = "Processo de ID " + id.toString() + " excluído com sucesso!";
            return ResponseEntity.ok(mensagem);
        } catch (RuntimeException e) {
            String errorMessage = "ID informado não foi encontrado na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    // ADICIONAR RÉU A UM PROCESSO
    @PostMapping("/{id}/reus")
    public Processo addReu(@PathVariable UUID id, @RequestBody Reu reu) {
        return service.addReu(id, reu);
    }
}
