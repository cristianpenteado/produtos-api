package io.github.cristianpenteado.crud_produtos.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoRequestDTO {

    @NotBlank(message = "o nome do produto é obrigatório!")
    private String nome;

    @NotBlank(message = "A descrição do produto é obrigatória!")
    private String descricao;

    @NotNull(message = "O preço do produto é obrigatório!")
    @DecimalMin(value = "0.0", inclusive = true, message = "O preço não pode ser negativo!")
    private BigDecimal preco;

    @NotNull(message = "o ID da marca é obrigatório!")
    private UUID marcaId;

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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public UUID getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(UUID marcaId) {
        this.marcaId = marcaId;
    }
}
