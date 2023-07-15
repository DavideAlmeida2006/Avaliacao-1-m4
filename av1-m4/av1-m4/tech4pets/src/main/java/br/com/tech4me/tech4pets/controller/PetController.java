package br.com.tech4me.tech4pets.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4pets.service.PetService;
import br.com.tech4me.tech4pets.shared.PetDto;
import br.com.tech4me.tech4pets.shared.PetListagemDto;



@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService servico;
    
    @GetMapping
    private ResponseEntity<List<PetListagemDto>> obterPets() {
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PetDto> obterPorId(@PathVariable String id) {
        Optional<PetDto> pet = servico.obterPorId(id);

        if (pet.isPresent()) {
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<PetDto> cadastrarPet(@RequestBody PetDto pet) {
        return new ResponseEntity<>(servico.cadastrar(pet), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirPetPorId(@PathVariable String id) {
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<PetDto> atualizarPet(@PathVariable String id, @RequestBody PetDto pet) {
        PetDto petAtualizado = servico.atualizarPorId(id, pet);

        if (petAtualizado != null) {
            return new ResponseEntity<>(petAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


