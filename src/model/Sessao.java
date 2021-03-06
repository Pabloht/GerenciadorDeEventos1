/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PabloHenrique
 */
@Entity
@Table(name = "Sessao")
public class Sessao {

    public Sessao() {
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSessao")
    private int id;
    @Column(name = "dataSessao")
    private Date data;
    
    
    @Column(name = "horaFimSessao")
    private Date horaFim;
    @Column(name = "horaInicioSessao")
    private Date horaInicio;
    
    @Column(name = "localSessao")
    private String local;
    @Column(name = "nomeSessao")
    private String nome;
    @Column(name = "numeroMaximoSessao")
    private int numeroMaximo;
    
    
    
    @ManyToMany
    @JoinTable(name="sessao_ministrante", 
      joinColumns=@JoinColumn(name="idsessao"),
      inverseJoinColumns=@JoinColumn(name="idministrante"))
    @Column(name = "inscritoSessao")
       private List<Ministrante> ministrantes;
    
    @ManyToOne
    @JoinColumn(name = "evento_Sessao")
    private Evento evento;
    
    public TipoSessao getTipoSessao() {
        return tipoSessao;
    }
@Enumerated(EnumType.STRING)
    @Column(name="tipo_sessao", nullable = false, length = 20)
    private TipoSessao tipoSessao;

    @ManyToMany 
    @JoinTable(name="sessao_inscrito", 
    joinColumns=@JoinColumn(name="idSessao"),
    inverseJoinColumns=@JoinColumn(name="idInscrito"))
    @Column(name = "inscritoSessao")
    private List<Inscrito> inscritos;

    public Sessao(Date data, Date horaFim, Date horaInicio, String local, String nome, int numeroMaximo, Evento evento, TipoSessao tipoSessao) {
        this.data = data;
        this.horaFim = horaFim;
        this.horaInicio = horaInicio;
        this.local = local;
        this.nome = nome;
        this.numeroMaximo = numeroMaximo;
        this.evento = evento;
        this.tipoSessao = tipoSessao;
    }
    public Sessao(Date data, Date horaFim, Date horaInicio, String local, String nome, int numeroMaximo, Evento evento, TipoSessao tipoSessao, List<Ministrante> ministrantes, List<Inscrito> inscritos) {
        this.data = data;
        this.inscritos = inscritos;
        this.horaFim = horaFim;
        this.horaInicio = horaInicio;
        this.local = local;
        this.nome = nome;
        this.numeroMaximo = numeroMaximo;
        this.evento = evento;
        this.tipoSessao = tipoSessao;
        this.ministrantes = ministrantes;
    }

    
    public Sessao(int id, Date data, Date horaFim, Date horaInicio, String local, String nome, int numeroMaximo, Evento evento, TipoSessao tipoSessao,List<Inscrito> inscrito, List<Ministrante> ministrante) {
        this.id = id;
        this.data = data;
        this.horaFim = horaFim;
        this.horaInicio = horaInicio;
        this.local = local;
        this.nome = nome;
        this.numeroMaximo = numeroMaximo;
        this.evento = evento;
        this.tipoSessao = tipoSessao;
        this.inscritos = inscrito;
        this.ministrantes = ministrante;
    }
    /**
     * @return the data
     */
    
    
    
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * @return the horaFim
     */
    public Date getHoraFim() {
        return horaFim;
    }

    /**
     * @param horaFim the horaFim to set
     */
    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * @return the horaInicio
     */
    public Date getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
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

    public List<Inscrito> getInscritos() {
        return inscritos;
    }

    /**
     * @return the inscrito
     */
    public void setInscritos(List<Inscrito> inscritos) {
        this.inscritos = inscritos;
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

    /**
     * @return the numeroMaximo
     */
    public int getNumeroMaximo() {
        return numeroMaximo;
    }

    /**
     * @param numeroMaximo the numeroMaximo to set
     */
    public void setNumeroMaximo(int numeroMaximo) {
        this.numeroMaximo = numeroMaximo;
    }

    /**
     * @return the ministrante
     */
    public List<Ministrante> getMinistrante() {
        return ministrantes;
    }

    /**
     * @param ministrante the ministrante to set
     */
    public void setMinistrante(List<Ministrante> ministrante) {
        this.ministrantes = ministrante;
    }

    /**
     * @return the tipoSessao
     */
    

    /**
     * @param tipoSessao the tipoSessao to set
     */
    public void setTipoSessao(TipoSessao tipoSessao) {
        this.tipoSessao = tipoSessao;
    }
}
