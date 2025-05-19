package com.hello.ProdutosAPI.repository;

import com.hello.ProdutosAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
