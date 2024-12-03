/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unifacs.a3_engsoftware.JAVA.TesteCaixaBranca;

/**
 *
 * @author alex.santos
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.unifacs.a3_engsoftware.JAVA.Usuario.Usuario;
import com.unifacs.a3_engsoftware.JAVA.Usuario.UsuarioDAO;
import java.sql.SQLException;

public class UsuarioTest {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario user;

    @Test
    public void testLoginValido() throws SQLException {
        String usuario = "admin";
        String senha = "admin";

        usuarioDAO.loginUsuario(usuario, senha);

        assertTrue(usuarioDAO.getAcesso());
        assertTrue(usuarioDAO.getVfsenha());
    }

    @Test
    public void testUsuarioIncorreto() throws SQLException {
        String usuario = "admin1";
        String senha = "admin";

        usuarioDAO.loginUsuario(usuario, senha);

        assertFalse(usuarioDAO.getAcesso());
        assertFalse(usuarioDAO.getVfsenha());
    }

    @Test
    public void testSenhaIncorreta() throws SQLException {
        String usuario = "admin";
        String senha = "admin123";

        usuarioDAO.loginUsuario(usuario, senha);

        assertTrue(usuarioDAO.getAcesso());
        assertFalse(usuarioDAO.getVfsenha());
    }

    @Test
    public void testUsuarioNulo() throws SQLException {
        String usuario = null;
        String senha = "admin";

        usuarioDAO.loginUsuario(usuario, senha);

        assertFalse(usuarioDAO.getAcesso());
        assertFalse(usuarioDAO.getVfsenha());
    }

    @Test
    public void testSenhaNula() throws SQLException {
        String usuario = "admin";
        String senha = null;

        usuarioDAO.loginUsuario(usuario, senha);

        assertTrue(usuarioDAO.getAcesso());
        assertFalse(usuarioDAO.getVfsenha());
    }

    @Test
    public void testUsuarioESenhaNulos() throws SQLException {
        String usuario = null;
        String senha = null;

        usuarioDAO.loginUsuario(usuario, senha);

        assertFalse(usuarioDAO.getAcesso());
        assertFalse(usuarioDAO.getVfsenha());
    }

    @Test
    public void testCadastroValido() {
        user = new Usuario("usuario1", "João Silva", "joao@email.com", "senha123");
        
        boolean valido  = user.validarCadastro();
        
        assertTrue(valido);
    }
    
    @Test
    public void testUsuarioVazio(){
        user = new Usuario("", "João Silva", "joao@email.com", "senha123");
        
        boolean valido  = user.validarCadastro();
        
        assertFalse(valido);
    }
    
    @Test
    public void testNomeVazio() {
        user = new Usuario("usuario1", "", "joao@email.com", "senha123");
        
        boolean valido  = user.validarCadastro();
        
        assertFalse(valido);
    }
    
    @Test
    public void testEmailInvalido() {
        user = new Usuario("usuario1", "João Silva", "", "senha123");
        
        boolean valido  = user.validarCadastro();
        
        assertFalse(valido);
    }
    
    @Test
    public void testSenhaCurta() {
        user = new Usuario("usuario1", "João Silva", "joao@email.com", "123");
        
        boolean valido  = user.validarCadastro();
        
        assertFalse(valido);
    }
    
    @Test
    public void testValoresNulos() {
        user = new Usuario(null, null, null, null);
        
        boolean valido  = user.validarCadastro();
        
        assertFalse(valido);
    }
    
    @Test
    public void testSenhaMinimaValida() {
        user = new Usuario("usuario2", "Maria Souza", "maria@email.com", "123456");
        
        boolean valido  = user.validarCadastro();
        
        assertTrue(valido);
    }
}
