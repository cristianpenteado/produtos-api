package io.github.cristianpenteado.crud_produtos.service;

import io.github.cristianpenteado.crud_produtos.dto.ProdutoRequestDTO;
import io.github.cristianpenteado.crud_produtos.dto.ProdutoResponseDTO;
import io.github.cristianpenteado.crud_produtos.exception.ResourceNotFoundException;
import io.github.cristianpenteado.crud_produtos.model.Marca;
import io.github.cristianpenteado.crud_produtos.model.Produto;
import io.github.cristianpenteado.crud_produtos.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtodto){

        Marca marca = marcaService.buscarMarcaPorId(produtodto.getMarcaId());

        Produto produto = new Produto();
        produto.setNome(produtodto.getNome());
        produto.setDescricao(produtodto.getDescricao());
        produto.setPreco(produtodto.getPreco());
        produto.setMarca(marca);
        Produto produtoSalvo =  this.produtoRepository.save(produto);
        return new ProdutoResponseDTO(produtoSalvo);
    }

    public Page<ProdutoResponseDTO> listarProdutos(Pageable pageable){
        Page<Produto> produtoPage = this.produtoRepository.findAll(pageable);
        return produtoPage.map(ProdutoResponseDTO::new);
    }

    public ProdutoResponseDTO atualizarProduto(UUID id, ProdutoRequestDTO produtodto){

        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Produto com ID "+id+" Não encontrado!"));

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
                Marca marcaNova = marcaService.buscarMarcaPorId(produtodto.getMarcaId());
                produtoExistente.setMarca(marcaNova);
            }
           Produto produtoResponse = produtoRepository.save(produtoExistente);
            return new ProdutoResponseDTO(produtoResponse);
    }

    public void deletarProduto(UUID id){
        if (!produtoRepository.existsById(id)){
            throw new ResourceNotFoundException("Produto com ID "+id+" não encontrado");
        }
        produtoRepository.deleteById(id);

    }
}
