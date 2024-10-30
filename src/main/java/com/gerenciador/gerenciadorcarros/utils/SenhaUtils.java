package com.gerenciador.gerenciadorcarros.utils; // ajuste o pacote conforme necessário

import org.mindrot.jbcrypt.BCrypt;

public class SenhaUtils {

    // Metodo para criptografar a senha
    public static String criptografarSenha(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

//    // Metodo para verificar a senha
//    public static boolean verificarSenha(String senha, String senhaCriptografada) {
//        return BCrypt.checkpw(senha, senhaCriptografada);
//    }

}
