package com.hello.ProdutosAPI.controller;

import com.hello.ProdutosAPI.model.Produto;
import com.hello.ProdutosAPI.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoCotroller {

    private ProdutoRepository produtoRepository;

    public ProdutoCotroller(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){

        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }
    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable("id") String id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? produto.get() : null;
    }
}
