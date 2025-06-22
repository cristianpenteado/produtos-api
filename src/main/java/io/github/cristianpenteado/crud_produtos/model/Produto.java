package io.github.cristianpenteado.crud_produtos.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @Column
    private UUID id;

    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    public Produto(){
        this.id = UUID.randomUUID();
    }

    public Produto(String nome, String descricao, Double preco, Marca marca) {
        this();
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.marca = marca;
    }

    public UUID getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Double getPreco(){
        return this.preco;
    }

    public Marca getMarca(){
        return this.marca;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
