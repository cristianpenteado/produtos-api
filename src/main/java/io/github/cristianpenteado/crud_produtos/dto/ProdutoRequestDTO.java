package io.github.cristianpenteado.crud_produtos.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoRequestDTO {
    private String nome;
    private String descricao;
    private BigDecimal preco;
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
