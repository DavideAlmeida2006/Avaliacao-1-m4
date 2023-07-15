package br.com.tech4me.tech4pets.shared;
import java.util.List;

public record PetDto (String id, String nome, String raca, int anoNascimento, String vacinado, List<String> procedimentos) {
}


