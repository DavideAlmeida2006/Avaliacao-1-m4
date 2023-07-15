package br.com.tech4me.tech4pets.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4pets.shared.PetListagemDto;
import br.com.tech4me.tech4pets.shared.PetDto;

public interface PetService {
    List<PetListagemDto> obterTodos();
    Optional<PetDto> obterPorId(String id);
    PetDto cadastrar(PetDto dto);
    PetDto atualizarPorId(String id, PetDto dto);
    void excluirPorId(String id);
  
}
