package io.github.cristianpenteado.crud_produtos.controller;

import io.github.cristianpenteado.crud_produtos.dto.ProdutoRequestDTO;
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
    public ResponseEntity<Produto> criarProduto(@RequestBody @Valid ProdutoRequestDTO produtodto){

        try {
            Produto novoProduto = this.produtoService.criarProduto(produtodto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(null);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<Page<Produto>> listarProdutos(Pageable pageable){
        Page<Produto> produtosPage = this.produtoService.listarProdutos(pageable);
        return ResponseEntity.ok(produtosPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable UUID id, @RequestBody @Valid ProdutoRequestDTO produtodto){
        try {
            return produtoService.atualizarProduto(id, produtodto)
                    .map(produto -> ResponseEntity.ok(produto))
                    .orElseGet(()-> ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable UUID id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
