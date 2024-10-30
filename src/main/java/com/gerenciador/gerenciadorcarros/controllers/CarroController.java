package com.gerenciador.gerenciadorcarros.controllers;

import com.gerenciador.gerenciadorcarros.entity.Carro;
import com.gerenciador.gerenciadorcarros.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @PostMapping("/cadastrar")
    public String cadastrarCarro(@RequestParam String nome, String marca, String placa, int ano, String cidade, double preco) {
        carroService.cadastrarCarro(nome, marca, placa, ano, cidade, preco);
        return "Carro cadastrado com sucesso!";
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros() {
        return ResponseEntity.ok(carroService.listarCarros());
    }

    @GetMapping("pegarDadosCarro/{id}")
    public ResponseEntity<Carro> buscarCarroPorId(@PathVariable Long id) {
        return carroService.buscarCarroPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("editarCarro/{id}")
    public ResponseEntity<?> editarCarro(@PathVariable Long id, @RequestBody Carro carro){
        // Verifica se o carro existe no banco de dados
        Optional<Carro> carroExistente = carroService.buscarCarroPorId(id);

        if (carroExistente.isPresent()) {
            // Se o carro existe, atualiza e retorna o carro atualizado
            Carro carroAtualizado = carroService.editarCarro(id, carro);
            return ResponseEntity.ok(carroAtualizado);
        } else {
            // Se o carro não for encontrado, retorna uma mensagem de erro
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado. Verifique o ID.");
        }
    }

    @DeleteMapping("deleteCarro/{id}")
    public ResponseEntity<Void> excluirCarro(@PathVariable Long id) {
        carroService.excluirCarro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<InputStreamResource> downloadCarroInfo(@PathVariable Long id) throws IOException {
        // Buscar o carro pelo ID
        Carro carro = carroService.getCarroById(id);

        // Verificar se o carro existe
        if (carro == null) {
            return ResponseEntity.notFound().build();
        }

        // Gerar o conteúdo do arquivo
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("Informações do Carro de ").append(carro.getNome()).append(":\n");
        conteudo.append("ID: ").append(carro.getId()).append("\n");
        conteudo.append("Dono: ").append(carro.getNome()).append("\n");
        conteudo.append("Marca: ").append(carro.getMarca()).append("\n");
        conteudo.append("Ano: ").append(carro.getAno()).append("\n");
        conteudo.append("Placa: ").append(carro.getPlaca()).append("\n");
        conteudo.append("Cidade: ").append(carro.getCidade()).append("\n");
        conteudo.append("Preço: ").append(carro.getPreco()).append("\n");

        // Salvar o conteúdo em um arquivo temporário
        File arquivoTemp = File.createTempFile("carro_" + carro.getId(), ".txt");
        try (FileWriter writer = new FileWriter(arquivoTemp)) {
            writer.write(conteudo.toString());
        }
        // Configurar o arquivo para download
        InputStreamResource resource = new InputStreamResource(new FileInputStream(arquivoTemp));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=carro_" + carro.getId() + ".txt")
                .contentType(MediaType.TEXT_PLAIN)
                .body(resource);
    }
}
