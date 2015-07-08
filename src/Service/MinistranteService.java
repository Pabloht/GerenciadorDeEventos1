package service;

import DAO.MinistranteDAO;
import model.Ministrante;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MinistranteService {

    private MinistranteDAO ministranteDAO = new MinistranteDAO();

    public boolean incluirMinistrante(String nome, String telefone, String email, String curriculo) {
        boolean retorno = false;
        Ministrante ministrante = new Ministrante(nome, telefone, email, curriculo);
        try {
            ministranteDAO.incluirMinistrante(ministrante);
            retorno = true;
            JOptionPane.showMessageDialog(null, "Ministrante cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusão do ministrante... " + e);
        }
        return retorno;
    }

    public boolean alterarMinistrante(int id, String nome, String telefone, String email, String curriculo) {
        boolean retorno = false;
        Ministrante ministrante = new Ministrante(id, nome, telefone, email, curriculo);
        try {
            ministranteDAO.alterarMinistrante(ministrante);
            retorno = true;
            JOptionPane.showMessageDialog(null, "Ministrante alterado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na alteração do ministrante... " + e);
        }
        return retorno;
    }

    public void apagarMinistrante(int id) {
        try {
            ministranteDAO.apagarMinistrante(retornarMinistrante(id));
            JOptionPane.showMessageDialog(null, "Ministrante apagado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao apagar o ministrante... " + e);
        }
    }

    public Ministrante retornarMinistrante(int id) {
        Ministrante ministrante = null;
        try {
           ministrante =  ministranteDAO.retornarMinistrante(id);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro no retorno do ministrante... " + e);
        }
        return ministrante;
    }
public ArrayList<Ministrante> listarMinistrantePorSessao(int id) {
     ArrayList<Ministrante> ministrantes = new ArrayList<Ministrante>();
    try {
            ministrantes = ministranteDAO.listarMinistrantesPorSessao(id);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na listagem de ministrantes por Sessao... " + e);
        }
        return ministrantes;
    
}
        
    public ArrayList<Ministrante> listarMinistrante() {
        ArrayList<Ministrante> ministrantes = new ArrayList<Ministrante>();
        try {
            ministrantes = ministranteDAO.listarMinistrantes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na listagem de ministrantes... " + e);
        }
        return ministrantes;
    }
    
    public void apagarMinistrantePorSessao(int id) {
        try {
            ministranteDAO.apagarMinistranteSessao(id);
            JOptionPane.showMessageDialog(null, "Ministrante apagado da Sessão com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao apagar o ministrante... " + e);
        }
    }
}
