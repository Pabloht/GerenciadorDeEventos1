/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PabloHenrique
 */
@Entity
@Table(name = "Evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvento")
    private int id;
    @Column(name = "localEvento")
    private String local;
    @Column(name = "nomeEvento")
    private String nome;
    @Column(name = "conteudoEmailEvento")
    private String conteudoEmail;
    @Column(name = "dataInicioEvento")
    private Date dataInicio;
    @Column(name = "dataFimEvento")
    private Date dataFim;
    
    @OneToMany (mappedBy="evento" , targetEntity=Sessao.class)
    private List<Sessao> sessao;

    public Evento() {
    }
    
    
    
    public Evento(int id, String nome, String local, Date dataInicio, Date dataFim, String conteudoEmail) {
        this.id = id;
        this.local = local;
        this.nome = nome;
        this.conteudoEmail = conteudoEmail;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Evento(String nome, String local, Date dataInicio, Date dataFim, String conteudoEmail) {
        
        this.local = local;
        this.nome = nome;
        this.conteudoEmail = conteudoEmail;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    

    
    

    /**
     * @return the conteudoEmail
     */
    public String getConteudoEmail() {
        return conteudoEmail;
    }

    /**
     * @param conteudoEmail the conteudoEmail to set
     */
    public void setConteudoEmail(String conteudoEmail) {
        this.conteudoEmail = conteudoEmail;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
