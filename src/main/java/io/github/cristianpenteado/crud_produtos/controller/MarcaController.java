package io.github.cristianpenteado.crud_produtos.controller;

import io.github.cristianpenteado.crud_produtos.dto.MarcaRequestDTO;
import io.github.cristianpenteado.crud_produtos.dto.MarcaResponseDTO;
import io.github.cristianpenteado.crud_produtos.model.Marca;
import io.github.cristianpenteado.crud_produtos.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<MarcaResponseDTO> criar(@RequestBody @Valid MarcaRequestDTO marcadto){
       MarcaResponseDTO marca = marcaService.criarMarca(marcadto);
       return ResponseEntity.status(HttpStatus.CREATED).body(marca);
    }

    @GetMapping
    public ResponseEntity<Page<MarcaResponseDTO>> listar(Pageable pageable){
        Page<MarcaResponseDTO> marcaPage = marcaService.listarTodasMarcas(pageable);
        return ResponseEntity.ok(marcaPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaResponseDTO> atualizarMarca(@PathVariable UUID id, @RequestBody @Valid MarcaRequestDTO marcadto){
        MarcaResponseDTO marcaAtualizada = marcaService.atualizarMarca(id, marcadto);
        return ResponseEntity.ok(marcaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMarca(@PathVariable UUID id){
        marcaService.deletarMarca(id);
        return ResponseEntity.noContent().build();
    }

}
