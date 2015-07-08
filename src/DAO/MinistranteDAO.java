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
import model.Ministrante;
import model.Sessao;
import util.EntityManagerUtil;

/**
 *
 * @author PabloHenrique
 */
public class MinistranteDAO {
 private final EntityManager entityManager = EntityManagerUtil.getEntityManager();
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    public String apagarMinistrante(Ministrante m){
		String retorno = "Ministrante apagado com sucesso";
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            getEntityManager().remove(m);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
           
        }
		
            return retorno;
		
	}
    public String alterarMinistrante(Ministrante i){
		String retorno = "Ministrante alterado com sucesso";
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
    public Ministrante retornarMinistrante(int id){
		
		
		Ministrante ministrante = null;
    try {
            ministrante = entityManager.find(Ministrante.class, id);
    } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
    }
            return ministrante;   
	}
    public ArrayList<Ministrante> listarMinistrantes(){
		
		
		
    ArrayList<Ministrante> lista = new ArrayList<Ministrante>();   
    Query query = entityManager.createQuery("select m from Ministrante m");
    lista = (ArrayList<Ministrante>)    query.getResultList();
		
return lista;
	}
    
      public ArrayList<Ministrante> listarMinistrantesPorSessao(int id){
	
    ArrayList<Ministrante> lista = new ArrayList<Ministrante>();   
    Query query = entityManager.createNativeQuery("select m.idMinistrante, m.nomeMinistrante, "
            + "m.telefoneMinistrante, m.emailMinistrante, m.curriculoMinistrante from ministrante as m "
            + "inner join sessao_ministrante as sm on sm.idSessao = "+ id + " where sm.idMinistrante = m.idMinistrante;", Ministrante.class);
                
    lista = (ArrayList<Ministrante>)    query.getResultList();
		
return lista;  
	}
    
    
	public String  incluirMinistrante(Ministrante i){
		String retorno = "Ministrante gravado com sucesso";
		
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
        
        public String apagarMinistranteSessao(int id){
         		String retorno = "Ministrante apagado com sucesso";
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            Query query = entityManager.createNativeQuery("delete sm from sessao_ministrante as sm  inner join ministrante m\n" +
                                                                    "on sm.idMinistrante = m.idMinistrante\n" +
                                                                    "where sm.idMinistrante = " + id, Sessao.class);
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
