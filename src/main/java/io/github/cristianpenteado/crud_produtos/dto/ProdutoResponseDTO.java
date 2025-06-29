package io.github.cristianpenteado.crud_produtos.dto;

import io.github.cristianpenteado.crud_produtos.model.Produto;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoResponseDTO {
    private UUID id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private MarcaResponseDTO marca;

    public ProdutoResponseDTO(){}

    public ProdutoResponseDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.marca = new MarcaResponseDTO(produto.getMarca());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public MarcaResponseDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaResponseDTO marca) {
        this.marca = marca;
    }
}
