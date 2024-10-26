package com.gerenciador.gerenciadorcarros.repository;

import com.gerenciador.gerenciadorcarros.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository <Carro, Long>{
}
