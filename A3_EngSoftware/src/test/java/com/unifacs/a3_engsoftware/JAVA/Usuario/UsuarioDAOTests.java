package com.unifacs.a3_engsoftware.JAVA.Usuario;
import com.unifacs.a3_engsoftware.ConexaoBD.Conexao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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

        Conexao conexaoMock = mock(Conexao.class);
        when(conexaoMock.getConnection()).thenReturn(mockConnection);
    }

    @Test
    public void testLoginUsuarioComSucesso() throws SQLException {
        String usuario = "adminX";
        String senha = "admin";

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("senha")).thenReturn(senha);

        usuarioDAO.loginUsuario(usuario, senha);

        assertTrue(usuarioDAO.getAcesso(), "O usuário deve ter acesso com credenciais corretas.");
        assertTrue(usuarioDAO.getVfsenha(), "A senha deve ser verificada corretamente.");
        verify(mockConnection, times(1));
    }

    @Test
    public void testLoginUsuarioSenhaIncorreta() throws SQLException {
        String usuario = "admin";
        String senha = "admin123";

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("senha")).thenReturn("senha123");

        usuarioDAO.loginUsuario(usuario, senha);

        assertTrue(usuarioDAO.getAcesso(), "O usuário deve ser encontrado.");
        assertFalse(usuarioDAO.getVfsenha(), "A verificação da senha deve falhar.");
        verify(mockConnection, times(1));
    }
}