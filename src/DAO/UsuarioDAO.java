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
import model.Usuario;
import util.EntityManagerUtil;

/**
 *
 * @author PabloHenrique
 */
public class UsuarioDAO {
    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    public String apagarUsuario(Usuario u){
		String retorno = "Usuario apagado com sucesso";
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            getEntityManager().remove(u);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
           
        }
		
            return retorno;
		
	}
    public String alterarUsuario(Usuario u){
		String retorno = "Usuario alterado com sucesso";
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            getEntityManager().merge(u);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            
        }
		
		return retorno;
	}
    public Usuario retornarUsuario(int id){
		
		
		Usuario usuario = null;
    try {
            usuario = entityManager.find(Usuario.class, id);
    } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
    }
            return usuario;   
	}
    public ArrayList<Usuario> listarUsuarios(){
		
		
		
    ArrayList<Usuario> lista = new ArrayList<Usuario>();   
    Query query = entityManager.createQuery("select u from Usuario u");
    lista = (ArrayList<Usuario>)    query.getResultList();
		
return lista;
	}
	public String  incluirUsuario(Usuario u){
		String retorno = "Usuario gravado com sucesso";
		
		EntityTransaction tx = getEntityManager().getTransaction();
		 
        try {
            tx.begin();
            getEntityManager().persist(u);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            
        }
		
		return retorno;
		
	}
}
