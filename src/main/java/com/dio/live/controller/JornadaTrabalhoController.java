package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    JornadaService jornadaService;
    UsuarioService usuarioService;

    @Autowired
    public JornadaTrabalhoController(JornadaService jornadaService, UsuarioService usuarioService) {
        this.jornadaService = jornadaService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<JornadaTrabalho> create(@RequestBody JornadaTrabalho jornadaTrabalho) {
        JornadaTrabalho jornadaTrabalhoSalva = jornadaService.save(jornadaTrabalho);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(jornadaTrabalhoSalva.getId_Jornada_Trabalho()).toUri();

        return ResponseEntity.created(location).body(jornadaTrabalhoSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> getById(@PathVariable Long id) {
        Optional<JornadaTrabalho> jornadaTrabalhoOptional = jornadaService.findById(id);
        if (!jornadaTrabalhoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(jornadaTrabalhoOptional.get());
    }

    @GetMapping
    public ResponseEntity<List<JornadaTrabalho>> getAll() {
        return ResponseEntity.ok(jornadaService.findAll());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> delete(@PathVariable Long id) {
        Optional<JornadaTrabalho> jornadaTrabalhoOptional = jornadaService.findById(id);
        if (!jornadaTrabalhoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        jornadaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<JornadaTrabalho> update(@RequestBody JornadaTrabalho jornadaTrabalho) {
        Optional<JornadaTrabalho> jornadaTrabalhoOptional = jornadaService.findById(jornadaTrabalho.getId_Jornada_Trabalho());
        if (!jornadaTrabalhoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        jornadaService.save(jornadaTrabalho);
        return ResponseEntity.noContent().build();
    }
}