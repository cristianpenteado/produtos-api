package io.github.cristianpenteado.crud_produtos.service;

import io.github.cristianpenteado.crud_produtos.model.Marca;
import io.github.cristianpenteado.crud_produtos.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
