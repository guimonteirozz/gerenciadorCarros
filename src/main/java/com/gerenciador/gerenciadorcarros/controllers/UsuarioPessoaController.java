package com.gerenciador.gerenciadorcarros.controllers;

import com.gerenciador.gerenciadorcarros.entity.UsuarioPessoa;
import com.gerenciador.gerenciadorcarros.services.UsuarioPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario_pessoa")
public class UsuarioPessoaController {
    @Autowired
    private UsuarioPessoaService usuarioPessoaService;

    @PostMapping
    public ResponseEntity<UsuarioPessoa> cadastrarUsuario(@RequestBody UsuarioPessoa usuarioPessoa){
        UsuarioPessoa novoUsuarioPessoa = usuarioPessoaService.salvarUsuarioPessoa(usuarioPessoa);
        return ResponseEntity.ok(novoUsuarioPessoa);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioPessoa>> listarUsuariosPessoa(){
        return ResponseEntity.ok(usuarioPessoaService.listarUsuariosPessoa());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioPessoa> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioPessoaService.buscarUsuarioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public  ResponseEntity<UsuarioPessoa> editarUsuarioPessoa(@PathVariable Long id, @RequestBody UsuarioPessoa usuarioPessoa) {
        return ResponseEntity.ok(usuarioPessoaService.editarUsuarioPessoa(id, usuarioPessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuarioPessoa(@PathVariable Long id) {
        usuarioPessoaService.excluirUsuarioPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
