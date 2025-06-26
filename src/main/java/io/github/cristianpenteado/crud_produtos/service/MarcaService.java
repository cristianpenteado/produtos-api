package io.github.cristianpenteado.crud_produtos.service;

import io.github.cristianpenteado.crud_produtos.dto.MarcaRequestDTO;
import io.github.cristianpenteado.crud_produtos.model.Marca;
import io.github.cristianpenteado.crud_produtos.repository.MarcaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
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

    public  Optional<Marca> buscarMarcaPorId(UUID id){
        return marcaRepository.findById(id);
    }

    public Optional<Marca> atualizarMarca(UUID id, MarcaRequestDTO marcadto){
        Optional<Marca> marcaExistenteOpcional = marcaRepository.findById(id);
        if (marcaExistenteOpcional.isPresent()){
            Marca marcaExistente = marcaExistenteOpcional.get();

            if(marcadto.getNome() != null && !marcadto.getNome().trim().isEmpty()){
                marcaExistente.setName(marcadto.getNome());
            }
            if(marcadto.getDescricao() != null && !marcadto.getDescricao().trim().isEmpty()){
                marcaExistente.setDescricao(marcadto.getDescricao());
            }
            Marca marcaSalva = marcaRepository.save(marcaExistente);

            return Optional.of(marcaSalva);

        } else {
            return Optional.empty();
        }
    }

    public void deletarMarca(UUID id){
        marcaRepository.deleteById(id);
    }
}
