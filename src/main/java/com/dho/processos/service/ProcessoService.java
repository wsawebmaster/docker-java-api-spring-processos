package com.dho.processos.service;

import com.dho.processos.exceptions.processo.ProcessoExistenteException;
import com.dho.processos.model.Processo;
import com.dho.processos.model.Reu;
import com.dho.processos.repository.ProcessoRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProcessoService {

    private final ProcessoRepository repository;

    ProcessoService(ProcessoRepository processoRepository) {
        this.repository = processoRepository;
    }

    // CADASTRAR UM PROCESSO
    public Processo createProcesso(Processo processo) {
        Optional<Processo> processoExistente = repository.findByNumero(processo.getNumero());

        if(processoExistente.isPresent()) {
            throw new ProcessoExistenteException("Processo já cadastrado anteriormente!");
        }
        return repository.save(processo);
    }

    // LISTAR TODOS OS PROCESSOS
    public List<Processo> getAllProcessos() {
        return repository.findAll(Sort.by("numero").ascending());
    }

    // LISTAR PROCESSO POR ID
    public Processo getProcessoById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Processo não encontrado"));
    }
    // ATUALIZAR PROCESSO
    public Processo updateProcesso(UUID id, Processo updatedProcesso) {

        Processo existingProcesso = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Processo não encontrado"));

        // Verifica se já existe um processo com o mesmo número, mas com um ID diferente
        Optional<Processo> processoComMesmoNumero = repository.findByNumero(updatedProcesso.getNumero());
        if (processoComMesmoNumero.isPresent() && !processoComMesmoNumero.get().getId().equals(id)) {
            throw new ProcessoExistenteException("Processo já cadastrado anteriormente!");
        }

        existingProcesso.setNumero(updatedProcesso.getNumero());

        return repository.save(existingProcesso);
    }
    // EXCLUIR PROCESSO
    @DeleteMapping("/{id}")
    public void deleteProcesso(@PathVariable UUID id) {
        Processo processo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Processo não encontrado"));
        repository.delete(processo);
    }

    // ADICIONAR RÉU A UM PROCESSO
    public Processo addReu(UUID processoId, Reu reu) {
        Processo processo = repository.findById(processoId)
                .orElseThrow(() -> new RuntimeException("Processo não encontrado"));
        reu.setProcesso(processo);
        processo.getReus().add(reu);
        return repository.save(processo);
    }
}
