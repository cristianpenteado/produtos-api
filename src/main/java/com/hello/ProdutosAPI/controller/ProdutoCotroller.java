package com.hello.ProdutosAPI.controller;

import com.hello.ProdutosAPI.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoCotroller {



    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        return produto;
    }
}
