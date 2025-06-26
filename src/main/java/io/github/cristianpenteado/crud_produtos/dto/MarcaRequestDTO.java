package io.github.cristianpenteado.crud_produtos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MarcaRequestDTO {

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 2, max = 50, message = "O nome da marca deve ter entre 2 e 50 caracteres!")
    private String nome;

    @NotBlank(message = "A descrição não pode ser vazia!")
    @Size(min = 5, max = 255, message = "A descrição da marca deve ter entre 5 a 255 caracteres!")
    private String descricao;

    public MarcaRequestDTO() {
    }

    public MarcaRequestDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
