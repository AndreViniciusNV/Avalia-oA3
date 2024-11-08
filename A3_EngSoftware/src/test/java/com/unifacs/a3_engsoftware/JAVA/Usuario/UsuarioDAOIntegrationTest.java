/* package com.unifacs.a3_engsoftware.JAVA.Usuario;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioDAOIntegrationTest {

    private UsuarioDAO usuarioDAO;
    private Connection connection;

    @BeforeEach
    public void setUp() throws SQLException {
        usuarioDAO = new UsuarioDAO();
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

        Statement statement = connection.createStatement();
        String createTableSql = "CREATE TABLE usuarios (" +
                "usuario VARCHAR(255) PRIMARY KEY, " +
                "nome VARCHAR(255), " +
                "email VARCHAR(255), " +
                "senha VARCHAR(255)" +
                ")";
        statement.execute(createTableSql);
        statement.close();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void testCadastrarUsuario() throws SQLException {
        Usuario usuario = new Usuario("usuario1", "Nome Teste", "email@teste.com", "senha123");
        usuarioDAO.cadastrarUsuario(usuario);

        usuarioDAO.loginUsuario("usuario1", "senha123");

        assertTrue(usuarioDAO.getAcesso(), "O usuário deve ter acesso após o cadastro.");
        assertTrue(usuarioDAO.getVfsenha(), "A senha deve ser verificada corretamente.");
    }

    @Test
    public void testLoginUsuarioNaoEncontrado() throws SQLException {
        usuarioDAO.loginUsuario("usuarioNaoExistente", "senha123");

        assertFalse(usuarioDAO.getAcesso(), "Usuário não existente não deve ter acesso.");
    }
} */