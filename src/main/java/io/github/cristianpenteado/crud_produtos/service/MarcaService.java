package io.github.cristianpenteado.crud_produtos.service;

import io.github.cristianpenteado.crud_produtos.model.Marca;
import io.github.cristianpenteado.crud_produtos.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository){
        this.marcaRepository = marcaRepository;
    }

    public Marca criarMarca(Marca marca){
        return marcaRepository.save(marca);
    }

    public List<Marca> listarTodasMarcas(){
        return marcaRepository.findAll();
    }

    public  Optional<Marca> buscarMarcaPorId(UUID id){
        return marcaRepository.findById(id);
    }

    public Optional<Marca> atualizarMarca(UUID id, Marca marcaAtualizada){
        Optional<Marca> marcaExistenteOpcional = marcaRepository.findById(id);
        if (marcaExistenteOpcional.isPresent()){
            Marca marcaExistente = marcaExistenteOpcional.get();

            if(marcaAtualizada.getName() != null && !marcaAtualizada.getName().trim().isEmpty()){
                marcaExistente.setName(marcaAtualizada.getName());
            }
            if(marcaAtualizada.getDescricao() != null && !marcaAtualizada.getDescricao().trim().isEmpty()){
                marcaExistente.setDescricao(marcaAtualizada.getDescricao());
            }
            Marca marcaSalva = marcaRepository.save(marcaAtualizada);

            return Optional.of(marcaSalva);

        } else {
            return Optional.empty();
        }
    }
}
