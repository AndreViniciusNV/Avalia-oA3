/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unifacs.a3_engsoftware.JAVA.TesteCaixaPreta;

import org.junit.jupiter.api.*;
import org.mockito.*;
import javax.swing.*;
import static org.mockito.Mockito.*;

import com.unifacs.a3_engsoftware.JAVA.view.ListaEventos;
import com.unifacs.a3_engsoftware.JAVA.Eventos.EventosController;
import com.unifacs.a3_engsoftware.JAVA.Usuario.Usuario;
import java.sql.SQLException;

/**
 *
 * @author alexl
 */
public class TesteIncricaoEvento {

    private ListaEventos listaEventos;
    private EventosController eventosControllerMock;

    @Mock
    private JTable jTableMock;

    @Mock
    private Usuario usuarioMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        eventosControllerMock = Mockito.mock(EventosController.class);
        listaEventos = new ListaEventos(usuarioMock);
        listaEventos.setjTableListaEventos(jTableMock);
    }

    @Test
    void testInscricaoEmEvento() throws SQLException {
        // Simulando um evento que o usuário pode se inscrever
        int codigoEvento = 1; // Simulando o código do evento
        when(jTableMock.getSelectedRow()).thenReturn(0); // Simulando a seleção de um evento
        when(jTableMock.getValueAt(0, 0)).thenReturn(codigoEvento); // Simulando o evento selecionado
        when(eventosControllerMock.verificarUsuario(usuarioMock.getCodUser(), codigoEvento)).thenReturn(true);

        // Verificando se a inscrição foi realizada corretamente
        verify(eventosControllerMock, times(1)).inscreverUsuario(usuarioMock.getCodUser(), codigoEvento);
        verify(listaEventos).atualizarTabela();
    }

    @Test
    void testVerificarInscricaoExistente() throws SQLException {
        int codigoEvento = 1; // Evento já inscrito
        when(jTableMock.getSelectedRow()).thenReturn(0); // Simulando a seleção do evento
        when(jTableMock.getValueAt(0, 0)).thenReturn(codigoEvento); // Evento selecionado
        when(eventosControllerMock.verificarUsuario(usuarioMock.getCodUser(), codigoEvento)).thenReturn(false); // Usuário já inscrito

        // Verificando se o sistema pergunta se o usuário quer cancelar a inscrição
        verify(eventosControllerMock).removerEvento(usuarioMock.getCodUser(), codigoEvento);
        verify(listaEventos).atualizarTabela();
    }

    @Test
    void testRemoverInscricao() throws SQLException {
        int codigoEvento = 1; // Evento no qual o usuário está inscrito
        when(jTableMock.getSelectedRow()).thenReturn(0); // Simulando a seleção do evento
        when(jTableMock.getValueAt(0, 0)).thenReturn(codigoEvento); // Evento selecionado
        when(eventosControllerMock.verificarUsuario(usuarioMock.getCodUser(), codigoEvento)).thenReturn(false); // Usuário já inscrito


        // Verificando se a inscrição foi removida
        verify(eventosControllerMock).removerEvento(usuarioMock.getCodUser(), codigoEvento);
        verify(listaEventos).atualizarTabela();
    }
}
