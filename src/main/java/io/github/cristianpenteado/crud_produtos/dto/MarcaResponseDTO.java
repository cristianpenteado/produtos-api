package io.github.cristianpenteado.crud_produtos.dto;

import io.github.cristianpenteado.crud_produtos.model.Marca;

import java.util.UUID;

public record MarcaResponseDTO(UUID id, String nome) {
    public MarcaResponseDTO(Marca marca){
        this(marca.getId(), marca.getName());
    }
}
