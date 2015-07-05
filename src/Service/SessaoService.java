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
            JOptionPane.showMessageDialog(null, "Sessão " + nome + " cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusão da sessão... " + e);
        }
        return retorno;
    }
    
    public boolean incluirMinistrante(String nome, String local, TipoSessao tipoSessao, Date horaInicio,Date horaFim, Date data,int numeroMaximo, Evento evento, List<Ministrante> ministrantes, List<Inscrito> inscritos) {
        boolean retorno = false;
        Sessao sessao = new Sessao(data, horaFim, horaInicio, local, nome, numeroMaximo, evento, tipoSessao, ministrantes, inscritos);
        try {
            sessaoDAO.incluirSessao(sessao);
            retorno = true;
            JOptionPane.showMessageDialog(null, "Deu certo!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o ministrante na sessao : " + e);
        }
        
        
        return retorno;
    }
    
    public boolean alterarSessao(int id, String nome, String local, TipoSessao tipoSessao, Date horaInicio,Date horaFim, Date data,int numeroMaximo, Evento evento, List<Inscrito> inscrito, List<Ministrante> ministrante) {
        boolean retorno = false;
        Sessao sessao = new Sessao(id, data, horaFim, horaInicio, local, nome, numeroMaximo, evento, tipoSessao, inscrito, ministrante);
        try {
            sessaoDAO.alterarSessao(sessao);
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
            JOptionPane.showMessageDialog(null, "Sessao Apagada Com Sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao apagar a sessão... " + e);
        }
    }

    public Sessao retornarSessao(int id) {
        Sessao sessao = null;
        try {
           sessao = sessaoDAO.retornarSessao(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro no retorno da sessão... " + e);
        }
        return sessao;
    }

    public ArrayList<Sessao> listarSessao(int id) {
        ArrayList<Sessao> sessao = new ArrayList<Sessao>();
        try {
            sessao = sessaoDAO.listarSessao(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na listagem de sessões... " + e);
        }
        return sessao;
    }

}
