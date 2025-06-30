package io.github.cristianpenteado.crud_produtos.service;

import io.github.cristianpenteado.crud_produtos.dto.MarcaRequestDTO;
import io.github.cristianpenteado.crud_produtos.dto.MarcaResponseDTO;
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

    public MarcaResponseDTO criarMarca(MarcaRequestDTO marcadto){
        Marca marca = new Marca();
        marca.setName(marcadto.getNome());
        marca.setDescricao(marcadto.getDescricao());

        Marca marcaSalva = marcaRepository.save(marca);

        return new MarcaResponseDTO(marcaSalva);
    }

    public Page<MarcaResponseDTO> listarTodasMarcas(Pageable pageable){
        return marcaRepository.findAll(pageable)
                .map(MarcaResponseDTO::new);
    }

    public  Marca buscarMarcaPorId(UUID id){
        return marcaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Marca com ID "+id+" não encontrada!"));
    }

    public MarcaResponseDTO atualizarMarca(UUID id, MarcaRequestDTO marcadto){

        Marca marcaExistente = marcaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Marca com ID "+ id +" não encontrada!"));;

            if(marcadto.getNome() != null && !marcadto.getNome().trim().isEmpty()){
                marcaExistente.setName(marcadto.getNome());
            }
            if(marcadto.getDescricao() != null && !marcadto.getDescricao().trim().isEmpty()){
                marcaExistente.setDescricao(marcadto.getDescricao());
            }
            Marca marcaAtualizada =  marcaRepository.save(marcaExistente);
            return new MarcaResponseDTO(marcaAtualizada);
    }

    public void deletarMarca(UUID id){
        if (!marcaRepository.existsById(id)){
            throw new ResourceNotFoundException("Marca com ID "+id+" não encontrada!");
        }
        marcaRepository.deleteById(id);
    }
}
