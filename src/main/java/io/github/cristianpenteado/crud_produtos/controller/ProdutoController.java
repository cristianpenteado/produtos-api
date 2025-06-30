package io.github.cristianpenteado.crud_produtos.controller;

import io.github.cristianpenteado.crud_produtos.dto.ProdutoRequestDTO;
import io.github.cristianpenteado.crud_produtos.dto.ProdutoResponseDTO;
import io.github.cristianpenteado.crud_produtos.model.Produto;
import io.github.cristianpenteado.crud_produtos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping()
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@RequestBody @Valid ProdutoRequestDTO produtodto){
        ProdutoResponseDTO novoProduto = this.produtoService.criarProduto(produtodto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);

    }

    @GetMapping()
    public ResponseEntity<Page<ProdutoResponseDTO>> listarProdutos(Pageable pageable){
        Page<ProdutoResponseDTO> produtosPage = this.produtoService.listarProdutos(pageable);
        return ResponseEntity.ok(produtosPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable UUID id, @RequestBody @Valid ProdutoRequestDTO produtodto){
        ProdutoResponseDTO produtoResponseDTO = produtoService.atualizarProduto(id, produtodto);
        return ResponseEntity.ok(produtoResponseDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
