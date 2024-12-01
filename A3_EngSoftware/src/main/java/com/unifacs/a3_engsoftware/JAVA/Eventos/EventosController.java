
package com.unifacs.a3_engsoftware.JAVA.Eventos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.unifacs.a3_engsoftware.ConexaoBD.Conexao;
import com.unifacs.a3_engsoftware.JAVA.view.ListaEventos;

/**
 *
 * @author 1272118088
 */
public class EventosController {
    
     public void ListarEventos(ListaEventos view) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        EventosDAO pesquisar = new EventosDAO();
        List<Eventos> listaDeEventos = pesquisar.buscarEventos();

        DefaultTableModel model = (DefaultTableModel) view.getjTableListaEventos().getModel();
        model.setNumRows(0);
        for (Eventos evento : listaDeEventos) {
            Object[] rowData = new Object[]{
                evento.getCodevento(),
                evento.getCategoria(), 
                evento.getEvento(),  
                evento.getEndereco(), 
                evento.getNumVagas(),
                evento.getNumVagasDisponiveis(),
            };

            model.addRow(rowData);
        }
    }
     
    public void inscreverUsuario(int usuario,int evento) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        EventosDAO inscrever = new EventosDAO();
       inscrever.inscreverUsuario(usuario, evento);
    }
    
    
    public boolean verificarUsuario(int usuario,int evento) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        EventosDAO inscrever = new EventosDAO();
        
        boolean valido;
        valido = inscrever.verificarInscricao(usuario, evento); 
        
        return valido;
    }
    
    public void removerEvento(int usuario, int evento) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        EventosDAO remover = new EventosDAO();
        remover.removerEvento(usuario, evento); // Chamando o método corretamente
    }
}



