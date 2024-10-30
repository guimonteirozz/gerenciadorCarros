package com.gerenciador.gerenciadorcarros.services;

import com.gerenciador.gerenciadorcarros.entity.Carro;
import com.gerenciador.gerenciadorcarros.repository.CarroRepository;
import com.gerenciador.gerenciadorcarros.utils.QRCodeUtils;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public Carro salvarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarCarroPorId(Long id) {
        return carroRepository.findById(id);
    }

    public Carro editarCarro(Long id, Carro carroAtualizado) {
        carroAtualizado.setId(id);
        return carroRepository.save(carroAtualizado);
    }

    public void excluirCarro(Long id) {
        carroRepository.deleteById(id);
    }

    public void cadastrarCarro(String nome, String marca, String placa, int ano, String cidade, double preco) {

        // adiciona o carro no banco de dados logica
        Carro novoCarro = new Carro();
        novoCarro.setNome(nome);
        novoCarro.setMarca(marca);
        novoCarro.setPlaca(placa);
        novoCarro.setAno(ano);
        novoCarro.setCidade(cidade);
        novoCarro.setPreco(preco);

        // Gera o QR code com as informações do carro e salva no campo qrCode
        String conteudoQRCode = String.format("Nome: %s\nMarca: %s\nPlaca: %s\nAno: %d\nCidade: %s\nPreço: %.2f",
                nome, marca, placa, ano, cidade, preco);

        try {
            String qrCodeBase64 = QRCodeUtils.gerarQRCodeBase64(conteudoQRCode);
            novoCarro.setQrCode(qrCodeBase64);
        } catch (WriterException | IOException e) {
            System.err.println("Erro ao gerar QR Code: " + e.getMessage());
        }

        // Salva o carro com o QR code no banco de dados

        carroRepository.save(novoCarro);
    }

    public Carro getCarroById(Long id) {
        return carroRepository.findById(id).orElse(null);
    }

}
