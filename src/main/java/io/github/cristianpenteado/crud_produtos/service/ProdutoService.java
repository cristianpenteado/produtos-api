package io.github.cristianpenteado.crud_produtos.service;

import io.github.cristianpenteado.crud_produtos.dto.ProdutoRequestDTO;
import io.github.cristianpenteado.crud_produtos.model.Marca;
import io.github.cristianpenteado.crud_produtos.model.Produto;
import io.github.cristianpenteado.crud_produtos.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final MarcaService marcaService;

    public ProdutoService(ProdutoRepository produtoRepository, MarcaService marcaService){
        this.produtoRepository = produtoRepository;
        this.marcaService = marcaService;
    }

    public Produto criarProduto(ProdutoRequestDTO produtodto){

        Marca marca = marcaService.buscarMarcaPorId(produtodto.getMarcaId())
                .orElseThrow(()-> new RuntimeException("Msrca não encontrada com o Id: " + produtodto.getMarcaId()));

        Produto produto = new Produto();
        produto.setNome(produtodto.getNome());
        produto.setDescricao(produtodto.getDescricao());
        produto.setPreco(produtodto.getPreco());
        produto.setMarca(marca);
        return this.produtoRepository.save(produto);
    }

    public Page<Produto> listarProdutos(Pageable pageable){
        return this.produtoRepository.findAll(pageable);
    }

    public Optional<Produto> atualizarProduto(UUID id, ProdutoRequestDTO produtodto){

        Optional<Produto> produtoExistenteOptional = produtoRepository.findById(id);
        if (produtoExistenteOptional.isPresent()){
            Produto produtoExistente = produtoExistenteOptional.get();

            if(produtodto.getNome() != null && !produtodto.getNome().trim().isEmpty()){
                produtoExistente.setNome(produtodto.getNome());
            }
            if(produtodto.getDescricao() != null && !produtodto.getDescricao().trim().isEmpty()){
                produtoExistente.setDescricao(produtodto.getDescricao());
            }
            if(produtodto.getPreco() != null && produtodto.getPreco().compareTo(BigDecimal.ZERO)>= 0){
                produtoExistente.setPreco(produtodto.getPreco());
            }
            if (produtodto.getMarcaId() != null){
                Marca marcaNova = marcaService.buscarMarcaPorId(produtodto.getMarcaId())
                        .orElseThrow(()->new RuntimeException("Nova marca não encontrada com o ID: "+ produtodto.getMarcaId()));
                produtoExistente.setMarca(marcaNova);
            }
            return Optional.of(produtoRepository.save(produtoExistente));

        } else {
            return Optional.empty();
        }
    }

    public void deletarProduto(UUID id){
        produtoRepository.deleteById(id);
    }
}
