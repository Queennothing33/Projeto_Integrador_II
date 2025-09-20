package br.com.senac.projeto_integrador_ii.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDB {
        public static Usuario validarUsuarioSeguro(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null;
                      
        try {
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador_db", "root", "Het1981!");
        PreparedStatement statement = conexao.prepareStatement(sql);
                                  
        statement.setString(1, usuario.getLogin());
        statement.setString(2, usuario.getSenha());
        ResultSet rs = statement.executeQuery();
                      
        while (rs.next()) {
            usuarioEncontrado = new Usuario();
            usuarioEncontrado.setId(rs.getInt("id"));
            usuarioEncontrado.setLogin(rs.getString("login"));
            usuarioEncontrado.setSenha(rs.getString("senha"));
            usuarioEncontrado.setTipo(rs.getString("tipo"));
                        }
            } catch (SQLException ex) {
                System.out.println("Sintaxe de comando invalida");
             }                 
            return usuarioEncontrado;
             }  
}
