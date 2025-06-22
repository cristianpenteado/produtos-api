package io.github.cristianpenteado.crud_produtos.repository;

import io.github.cristianpenteado.crud_produtos.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarcaRepository extends JpaRepository<Marca, UUID> {
}
