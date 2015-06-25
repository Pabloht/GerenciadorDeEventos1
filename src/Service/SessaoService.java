/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.SessaoDAO;
import model.Evento;
import model.Inscrito;
import model.Ministrante;
import model.Sessao;
import model.TipoSessao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class SessaoService {

    private SessaoDAO sessaoDAO = new SessaoDAO();

    public boolean incluirSessao(String nome, String local, TipoSessao tipoSessao, Date horaInicio,Date horaFim, Date data,int numeroMaximo, Evento evento) {
        boolean retorno = false;
        Sessao sessao = new Sessao(data, horaFim, horaInicio, local, nome, numeroMaximo, evento, tipoSessao);
        try {
          sessaoDAO.incluirSessao(sessao);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusão da sessão... " + e);
        }
        return retorno;
    }

    public boolean alterarSessao(Date data, Evento evento, Date horaFim, Date horaInicio, int id, String local, String nome, int numeroMaximo, TipoSessao tipoSessao, List<Inscrito> inscrito, List<Ministrante> ministrante) {
        boolean retorno = false;
        //Sessao sessao = new Sessao(data, evento, horaFim, horaInicio, id, local, nome, numeroMaximo, tipoSessao, inscrito, ministrante);
        try {
//            sessaoDAO.alterarSessao(sessao);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na alteração da sessão... " + e);
        }
        return retorno;
    }

    public void apagarSessao(int id) {
        try {
            sessaoDAO.apagarSessao(retornarSessao(id));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao apagar a sessão... " + e);
        }
    }

    public Sessao retornarSessao(int id) {
        Sessao sessao = null;
        try {
            sessaoDAO.retornarSessao(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro no retorno da sessão... " + e);
        }
        return sessao;
    }

    public ArrayList<Sessao> listarSessao() {
        ArrayList<Sessao> sessao = new ArrayList<Sessao>();
        try {
            sessao = sessaoDAO.listarSessao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na listagem de sessões... " + e);
        }
        return sessao;
    }

}
