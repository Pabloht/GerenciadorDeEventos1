package service;

import DAO.EventoDAO;
import model.Evento;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class EventoService {

    private EventoDAO eventoDAO = new EventoDAO();

    
    // Para incluir um evento precisa somente disto ou mais coisas??
    
    public boolean incluirEvento(String nome, String local, Date dataInicio, Date dataFim, String conteudoEmail) {
        boolean retorno = false;
       
        Evento evento = new Evento(nome, local, dataInicio, dataFim, conteudoEmail);
        try {
            eventoDAO.incluirEvento(evento);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusão do evento... " + e);
        }
        return retorno;
    }

    public boolean alterarEvento(int id, String nome, String local, Date dataInicio, Date dataFim, String conteudoEmail) {
        boolean retorno = false;
        Evento evento = new Evento(id, nome, local, dataInicio, dataFim, conteudoEmail);
        try {
            eventoDAO.alterarEvento(evento);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na alteração do evento... " + e);
        }
        return retorno;
    }

    public void apagarEvento(int id) {
        try {
            eventoDAO.apagarEvento(retornarEvento(id));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao apagar o evento... " + e);
        }
    }

    public Evento retornarEvento(int id) {
        Evento evento = null;
        try {
            eventoDAO.retornarEvento(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro no retorno do evento... " + e);
        }
        return evento;
    }

    public ArrayList<Evento> listarEventos() {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        try {
            eventos = eventoDAO.listarEventos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na listagem de eventos... " + e);
        }
        return eventos;
    }
}
