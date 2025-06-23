package io.github.cristianpenteado.crud_produtos.controller;

import io.github.cristianpenteado.crud_produtos.model.Marca;
import io.github.cristianpenteado.crud_produtos.service.MarcaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService){
        this.marcaService = marcaService;
    }

    @PostMapping
    public Marca criar(@RequestBody Marca marca){
        return marcaService.criarMarca(marca);
    }
    @GetMapping
    public List<Marca> listar(){
        return marcaService.listarTodasMarcas();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizarMarca(@PathVariable UUID id, @RequestBody Marca marca){
        Optional<Marca> marcaAtualizadaOpcional = marcaService.atualizarMarca(id, marca);
        if(marcaAtualizadaOpcional.isPresent()){
            Marca marcaRetornada = marcaAtualizadaOpcional.get();
            return ResponseEntity.ok(marcaRetornada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
