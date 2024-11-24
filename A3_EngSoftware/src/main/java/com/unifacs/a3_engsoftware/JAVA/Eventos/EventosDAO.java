package com.unifacs.a3_engsoftware.JAVA.Eventos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unifacs.a3_engsoftware.ConexaoBD.Conexao;

/**
 *
 * @author 1272118088
 */
public class EventosDAO {

    public List<Eventos> buscarEventos() throws SQLException {
        List<Eventos> listaDeEventos = new ArrayList<>();

        Connection conexao = new Conexao().getConnection();

        try {
            String sql = "select a.codevento, a.evento, a.endereco, a.descricao, a.numvagas, b.codcategoria, b.categoria, (select (a.numvagas - (count(b.id))) \n"
                    + "from eventosInscritos b\n"
                    + "where a.codevento = b.codevento) as vagasdisponiveis\n"
                    + "from eventos a, categorias b\n"
                    + "where a.codcategoria = b.codcategoria";

            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int codevento = resultSet.getInt("codevento");
                        String evento = resultSet.getString("evento");
                        String endereco = resultSet.getString("endereco");
                        String descricao = resultSet.getString("descricao");
                        int numvagas = resultSet.getInt("numvagas");
                        int codcategoria = resultSet.getInt("codcategoria");
                        String categoria = resultSet.getString("categoria");
                        int vagasdisponiveis = resultSet.getInt("vagasdisponiveis");

                        Eventos eventos = new Eventos(codevento, evento, endereco, descricao, numvagas, codcategoria, categoria, vagasdisponiveis);

                        listaDeEventos.add(eventos);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeEventos;
    }
    

    public void inscreverUsuario(int codigoUsuario, int codigoEvento) throws SQLException {
        Connection conexao = new Conexao().getConnection();

        try {
            String sql = "INSERT INTO eventosInscritos (codEvento, codUser) VALUES (" + codigoEvento + "," + codigoUsuario + ");";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Não foi possível inscrever no evento. Detalhes: " + e.getMessage());
        }
    }
    

    public boolean verificarInscricao(int codigoUsuario, int codigoEvento) throws SQLException {
        Connection conexao = new Conexao().getConnection();

        try {
            String sql = "SELECT COUNT(*) AS total FROM eventosInscritos WHERE codUser = " + codigoUsuario + " AND codEvento =" + codigoEvento + ";";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                if(resultSet.getInt("total") > 0){
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao verificar inscrição. Detalhes: " + e.getMessage());
        }
        return false;
    }
    
}
