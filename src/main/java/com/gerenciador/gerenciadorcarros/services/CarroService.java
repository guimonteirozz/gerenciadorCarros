package com.gerenciador.gerenciadorcarros.services;

import com.gerenciador.gerenciadorcarros.entity.Carro;
import com.gerenciador.gerenciadorcarros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
