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
import model.Evento;
import util.EntityManagerUtil;

/**
 *
 * @author PabloHenrique
 */
public class EventoDAO {
 private final EntityManager entityManager = EntityManagerUtil.getEntityManager();
    public EntityManager getEntityManager() {
        return entityManager;   
    }
    
    public String apagarEvento(Evento e){
		String retorno = "Evento apagado com sucesso";
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            getEntityManager().remove(e);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
           
        }
		
            return retorno;
		
	}
    public String alterarEvento(Evento e){
		String retorno = "Evento alterado com sucesso";
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            getEntityManager().merge(e);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            
        }
		
		return retorno;
	}
    public Evento retornarEvento(int id){
		
		
		Evento evento = null;
    try {
            evento = entityManager.find(Evento.class, id);
    } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
    }
            return evento;   
	}
    public ArrayList<Evento> listarEventos(){
		
        ArrayList<Evento> lista = new ArrayList<Evento>();   
        Query query = entityManager.createQuery("select e from Evento e");
        lista = (ArrayList<Evento>)    query.getResultList();
		
        return lista;
	}
	public String  incluirEvento(Evento e){
		String retorno = "Evento gravado com sucesso";
		
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            getEntityManager().persist(e);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            
        }
		
		return retorno;
		
	}
}
