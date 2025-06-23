package io.github.cristianpenteado.crud_produtos.service;

import io.github.cristianpenteado.crud_produtos.dto.ProdutoCreateDTO;
import io.github.cristianpenteado.crud_produtos.model.Marca;
import io.github.cristianpenteado.crud_produtos.model.Produto;
import io.github.cristianpenteado.crud_produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final MarcaService marcaService;

    public ProdutoService(ProdutoRepository produtoRepository, MarcaService marcaService){
        this.produtoRepository = produtoRepository;
        this.marcaService = marcaService;
    }

    public Produto criarProduto(ProdutoCreateDTO produtodto){

        if(produtodto.getMarcaId() == null){
            throw new IllegalArgumentException("O Id da Marca é obrigatório");
        }
        Marca marca = marcaService.buscarMarcaPorId(produtodto.getMarcaId())
                .orElseThrow(()-> new RuntimeException("Msrca não encontrada com o Id: " + produtodto.getMarcaId()));

        Produto produto = new Produto();
        produto.setNome(produtodto.getNome());
        produto.setDescricao(produtodto.getDescricao());
        produto.setPreco(produtodto.getPreco());
        produto.setMarca(marca);
        return this.produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return this.produtoRepository.findAll();
    }
}
