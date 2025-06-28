package io.github.cristianpenteado.crud_produtos.service;

import io.github.cristianpenteado.crud_produtos.dto.MarcaRequestDTO;
import io.github.cristianpenteado.crud_produtos.exception.ResourceNotFoundException;
import io.github.cristianpenteado.crud_produtos.model.Marca;
import io.github.cristianpenteado.crud_produtos.repository.MarcaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository){
        this.marcaRepository = marcaRepository;
    }

    public Marca criarMarca(MarcaRequestDTO marcadto){
        Marca marca = new Marca();
        marca.setName(marcadto.getNome());
        marca.setDescricao(marcadto.getDescricao());
        return marcaRepository.save(marca);
    }

    public Page<Marca> listarTodasMarcas(Pageable pageable){
        return marcaRepository.findAll(pageable);
    }

    public  Marca buscarMarcaPorId(UUID id){
        return marcaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Marca com ID "+id+" não encontrada!"));
    }

    public Marca atualizarMarca(UUID id, MarcaRequestDTO marcadto){

        Marca marcaExistente = marcaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Marca com ID "+ id +" não encontrada!"));;

            if(marcadto.getNome() != null && !marcadto.getNome().trim().isEmpty()){
                marcaExistente.setName(marcadto.getNome());
            }
            if(marcadto.getDescricao() != null && !marcadto.getDescricao().trim().isEmpty()){
                marcaExistente.setDescricao(marcadto.getDescricao());
            }
            return marcaRepository.save(marcaExistente);
    }

    public void deletarMarca(UUID id){
        marcaRepository.deleteById(id);
    }
}
