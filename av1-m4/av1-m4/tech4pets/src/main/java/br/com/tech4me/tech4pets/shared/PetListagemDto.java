package br.com.tech4me.tech4pets.shared;

import java.util.List;




public record PetListagemDto (String id,String nome,List<String> procedimentos) {
    
}
