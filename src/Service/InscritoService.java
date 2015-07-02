/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.InscritoDAO;
import model.Inscrito;
import model.Sessao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class InscritoService {
    private InscritoDAO inscritoDAO = new InscritoDAO();

    public boolean incluirInscrito(String nome, String cpf, String instituicao, String naturalidade, Date dataNascimento, String email) {
        boolean retorno = false;
        Inscrito inscrito = new Inscrito( nome, cpf, instituicao, naturalidade,dataNascimento, email);
        try {
            inscritoDAO.incluirInscrito(inscrito);
            retorno = true;
            JOptionPane.showMessageDialog(null, "Inscrito inserido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusão do inscrito... " + e);
        }
        return retorno;
    }

    public boolean alterarInscrito(int id, String nome, String cpf, String instituicao, String naturalidade, Date dataNascimento, String email) {
        boolean retorno = false;
        Inscrito inscrito = new Inscrito(id, nome, cpf, instituicao, naturalidade,dataNascimento, email);
        try {
            inscritoDAO.alterarInscrito(inscrito);
            retorno = true;
            JOptionPane.showMessageDialog(null, "Inscrito alterado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na alteração do inscrito... " + e);
        }
        return retorno;
    }

    public void apagarInscrito(int id) {
        try {
            inscritoDAO.apagarInscrito(retornarInscrito(id));
                    JOptionPane.showMessageDialog(null, "Inscrito apagado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao apagar o inscrito... " + e);
        }
    }

    public Inscrito retornarInscrito(int id) {
        Inscrito inscrito = null;
        try {
           inscrito = inscritoDAO.retornarInscrito(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro no retorno do inscrito... " + e);
        }
        return inscrito;
    }

    public ArrayList<Inscrito> listarInscrito() {
        ArrayList<Inscrito> inscritos = new ArrayList<Inscrito>();
        try {
            inscritos = inscritoDAO.listarInscrito();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na listagem dos inscritos... " + e);
        }
        return inscritos;
    }
}
