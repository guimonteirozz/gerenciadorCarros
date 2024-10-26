package com.gerenciador.gerenciadorcarros.controllers;

import com.gerenciador.gerenciadorcarros.entity.Carro;
import com.gerenciador.gerenciadorcarros.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody Carro carro) {
        Carro novoCarro = carroService.salvarCarro(carro);
        return ResponseEntity.ok(novoCarro);
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros() {
        return ResponseEntity.ok(carroService.listarCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarCarroPorId(@PathVariable Long id) {
        return carroService.buscarCarroPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> editarCarro(@PathVariable Long id, @RequestBody Carro carro) {
        return ResponseEntity.ok(carroService.editarCarro(id, carro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCarro(@PathVariable Long id) {
        carroService.excluirCarro(id);
        return ResponseEntity.noContent().build();
    }
}
