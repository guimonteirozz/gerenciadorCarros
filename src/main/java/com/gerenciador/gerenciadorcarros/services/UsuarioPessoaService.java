package com.gerenciador.gerenciadorcarros.services;

import com.gerenciador.gerenciadorcarros.entity.UsuarioPessoa;
import com.gerenciador.gerenciadorcarros.repository.UsuarioPessoaRepository;
import com.gerenciador.gerenciadorcarros.utils.SenhaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioPessoaService {
    @Autowired
    private UsuarioPessoaRepository usuarioPessoaRepository;

    public UsuarioPessoa salvarUsuarioPessoa(UsuarioPessoa usuarioPessoa){
        return usuarioPessoaRepository.save(usuarioPessoa);
    }

    public List<UsuarioPessoa> listarUsuariosPessoa(){
        return usuarioPessoaRepository.findAll();
    }

    public Optional<UsuarioPessoa> buscarUsuarioPorId(Long id){
        return usuarioPessoaRepository.findById(id);
    }

    public UsuarioPessoa editarUsuarioPessoa(Long id, UsuarioPessoa usuarioAtualizado){
        usuarioAtualizado.setId(id);
        return usuarioPessoaRepository.save(usuarioAtualizado);
    }

    public void excluirUsuarioPessoa(Long id){
        usuarioPessoaRepository.deleteById(id);
    }

    public void cadastrarUsuario(String nome, String senha, String email, String telefone, String nomePessoa) {
        // Criptografar a senha antes de armazená-la
        String senhaCriptografada = SenhaUtils.criptografarSenha(senha);

        // Aqui você adicionaria a lógica para salvar o usuário no banco de dados
        UsuarioPessoa novoUsuario = new UsuarioPessoa();
        novoUsuario.setNomeUsuario(nome);
        novoUsuario.setSenha(senhaCriptografada);
        novoUsuario.setEmail(email);
        novoUsuario.setTelefone(telefone);
        novoUsuario.setNomePessoa(nomePessoa);

        // Salvar novoUsuario no banco de dados usando seu repositório
        usuarioPessoaRepository.save(novoUsuario);
    }
}
