package io.github.cristianpenteado.crud_produtos.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    public Produto(){
    }

    public Produto(String nome, String descricao, BigDecimal preco, Marca marca) {
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

    public BigDecimal getPreco(){
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

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
