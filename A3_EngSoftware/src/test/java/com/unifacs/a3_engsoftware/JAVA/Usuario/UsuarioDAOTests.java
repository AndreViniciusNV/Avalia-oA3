package com.unifacs.a3_engsoftware.JAVA.Usuario;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.unifacs.a3_engsoftware.ConexaoBD.Conexao;

public class UsuarioDAOTests {

    private UsuarioDAO usuarioDAO;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws SQLException {
        usuarioDAO = new UsuarioDAO();
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Simula o método Conexao.getConnection() para retornar uma conexão mockada
        Conexao conexaoMock = mock(Conexao.class);
        when(conexaoMock.getConnection()).thenReturn(mockConnection);
    }


    @Test
    public void testCadastrarUsuario() throws SQLException {
        // Configuração do mock para o método cadastrarUsuario
        Usuario usuario = new Usuario("teste", "Nome Teste", "email@teste.com", "teste");
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        usuarioDAO.cadastrarUsuario(usuario);

        // Verifica se o PreparedStatement foi executado
        verify(mockPreparedStatement, times(1)).execute();
        verify(mockConnection, times(1)).close();
    }


    @Test
    public void testLoginUsuarioComSucesso() throws SQLException {
        // Configuração do mock para o método loginUsuario
        String usuario = "admin";
        String senha = "admin";

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true); // Simula que encontrou o usuário no banco
        when(mockResultSet.getString("senha")).thenReturn(senha); // Senha correta

        usuarioDAO.loginUsuario(usuario, senha);

        // Verifica se as variáveis foram definidas corretamente
        assertTrue(usuarioDAO.getAcesso());
        assertTrue(usuarioDAO.getVfsenha());
        verify(mockConnection, times(1)).close();
    }


    @Test
    public void testLoginUsuarioSenhaIncorreta() throws SQLException {
        // Configuração do mock para o método loginUsuario com senha incorreta
        String usuario = "admin";
        String senha = "senhaErrada";

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true); // Simula que encontrou o usuário no banco
        when(mockResultSet.getString("senha")).thenReturn("senha123"); // Senha incorreta

        usuarioDAO.loginUsuario(usuario, senha);

        // Verifica se as variáveis foram definidas corretamente
        assertTrue(usuarioDAO.getAcesso());
        assertFalse(usuarioDAO.getVfsenha());
        verify(mockConnection, times(1)).close();
    }


    @Test
    public void testLoginUsuarioNaoEncontrado() throws SQLException {
        // Configuração do mock para o método loginUsuario sem encontrar o usuário
        String usuario = "usuarioNaoExistente";
        String senha = "senha123";

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false); // Simula que o usuário não foi encontrado

        usuarioDAO.loginUsuario(usuario, senha);

        // Verifica se as variáveis foram definidas corretamente
        assertFalse(usuarioDAO.getAcesso());
        verify(mockConnection, times(1)).close();
    }
}