package com.dio.live.controller;

import com.dio.live.model.TipoData;
import com.dio.live.service.CalendarioService;
import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo-data")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;
    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public ResponseEntity<TipoData> createTipoData(@RequestBody TipoData tipoData){

        TipoData tipoDataSalvo = tipoDataService.save(tipoData);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(tipoDataSalvo.getId_tipoData()).toUri();

        return ResponseEntity.created(location).body(tipoDataSalvo);
    }

    @GetMapping
    public ResponseEntity<List<TipoData>> getTipoDataList(){
        return ResponseEntity.ok(tipoDataService.getTipoData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoData> getTipoDataById(@PathVariable Long id) {
        Optional<TipoData> optionalTipoData = tipoDataService.getTipoDataById(id);
        if (optionalTipoData.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalTipoData.get());
    }

    @PutMapping
    public ResponseEntity<TipoData> updateTipoData(@RequestBody TipoData tipoData){
        Optional<TipoData> optionalTipoData = tipoDataService.getTipoDataById(tipoData.getId_tipoData());
        if (optionalTipoData.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        tipoData.setId_tipoData(optionalTipoData.get().getId_tipoData());
        tipoDataService.save(tipoData);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoData> deleteCalendario(@PathVariable Long id){
        Optional<TipoData> optionalTipoData = tipoDataService.getTipoDataById(id);
        if (optionalTipoData.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        tipoDataService.deleteTipoData(optionalTipoData.get().getId_tipoData());
        return ResponseEntity.noContent().build();
    }

}