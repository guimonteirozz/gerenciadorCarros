package com.gerenciador.gerenciadorcarros.repository;

import com.gerenciador.gerenciadorcarros.entity.UsuarioPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPessoaRepository extends JpaRepository <UsuarioPessoa, Long>{

}
