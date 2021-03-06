/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Inscrito;
import model.Ministrante;
import model.Sessao;
import util.EntityManagerUtil;

/**
 *
 * @author PabloHenrique
 */
public class InscritoDAO {
    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    public String apagarInscrito(Inscrito i){
		String retorno = "Inscrito apagado com sucesso";
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            getEntityManager().remove(i);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
           
        }
		
            return retorno;
		
	}
    public String alterarInscrito(Inscrito i){
		String retorno = "Inscrito alterado com sucesso";
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            getEntityManager().merge(i);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            
        }
		
		return retorno;
	}
    public Inscrito retornarInscrito(int id){
		
		
		Inscrito inscrito = null;
    try {
            inscrito = entityManager.find(Inscrito.class, id);
    } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
    }
            return inscrito;   
	}
    public ArrayList<Inscrito> listarInscrito(){
		
		
		
    ArrayList<Inscrito> lista = new ArrayList<Inscrito>();   
    Query query = entityManager.createQuery("select i from Inscrito i");
    lista = (ArrayList<Inscrito>)    query.getResultList();
		
return lista;
	}
	public String  incluirInscrito(Inscrito i){
		String retorno = "Inscrito gravado com sucesso";
		
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            getEntityManager().persist(i);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            
        }
		
		return retorno;
		
	}
        
        public ArrayList<Inscrito> listarInscritosPorSessao(int id){
	
    ArrayList<Inscrito> lista = new ArrayList<Inscrito>();   
    Query query = entityManager.createNativeQuery("select si.idInscrito , si.Idsessao, i.nomeInscrito, i.cpfInscrito, i.emailInscrito, \n" +
                                                  "i.dataNascimentoInscrito, i.instituicaoInscrito, i.naturalidadeInscrito from\n" +
                                                  "inscrito as i inner join sessao_inscrito as si on si.idSessao = " + id + " \n" +
                                                  "where si.idInscrito = i.idInscrito;", Inscrito.class);
                
    lista = (ArrayList<Inscrito>)    query.getResultList();
		
return lista;  
	}
        
        
        public String apagarInscritoSessao(int id){
         		String retorno = "Inscrito apagado com sucesso";
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            Query query = entityManager.createNativeQuery("delete si from sessao_inscrito as si inner join inscrito i \n" +
                                                                    "on si.idInscrito = i.idInscrito \n" +
                                                                    "where si.idInscrito = " + id, Sessao.class);
            query.executeUpdate();
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
           
        }
            
            return retorno;
        }
}

