package io.github.cristianpenteado.crud_produtos.repository;

import io.github.cristianpenteado.crud_produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
