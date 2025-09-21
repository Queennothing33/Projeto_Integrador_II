package br.com.senac.projeto_integrador_ii.service;

import br.com.senac.projeto_integrador_ii.persistencia.Usuario;
import br.com.senac.projeto_integrador_ii.persistencia.UsuarioDB;

public class AuthService {

    private final UsuarioDB usuarioDB;

    public AuthService() {
        this.usuarioDB = new UsuarioDB();
    }

    public Usuario autenticar(String login, String senha) {
        return usuarioDB.buscarPorLoginESenha(login, senha);
    }

}
