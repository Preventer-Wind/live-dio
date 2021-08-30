package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaUsuarioService;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria-usuario")
public class CategoriaUsuarioController {

    CategoriaUsuarioService categoriaUsuarioService;
    UsuarioService usuarioService;

    @Autowired
    public CategoriaUsuarioController(CategoriaUsuarioService categoriaUsuarioService, UsuarioService usuarioService) {
        this.categoriaUsuarioService = categoriaUsuarioService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<CategoriaUsuario> create(@RequestBody CategoriaUsuario categoriaUsuario) {
        CategoriaUsuario categoriaUsuarioSalvo = categoriaUsuarioService.save(categoriaUsuario);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoriaUsuarioSalvo.getId_Cat_Usuario()).toUri();

        return ResponseEntity.created(location).body(categoriaUsuarioSalvo);
    }

    @PutMapping
    public ResponseEntity<CategoriaUsuario> update(@RequestBody CategoriaUsuario categoriaUsuario) {
        Optional<CategoriaUsuario> categoriaUsuarioOptional = categoriaUsuarioService.findById(categoriaUsuario.getId_Cat_Usuario());
        if (categoriaUsuarioOptional.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        categoriaUsuarioService.save(categoriaUsuario);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaUsuario> delete(@PathVariable Long id) {
        Optional<CategoriaUsuario> categoriaUsuarioOptional = categoriaUsuarioService.findById(id);
        if (categoriaUsuarioOptional.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        categoriaUsuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaUsuario> getById(@PathVariable Long id) {
        Optional<CategoriaUsuario> categoriaUsuarioOptional = categoriaUsuarioService.findById(id);
        if (categoriaUsuarioOptional.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(categoriaUsuarioOptional.get());
    }

    @GetMapping
    public ResponseEntity<List<CategoriaUsuario>> findAll() {
        return ResponseEntity.ok(categoriaUsuarioService.findAll());
    }
}