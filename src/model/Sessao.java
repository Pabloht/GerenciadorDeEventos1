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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSessao")
    private int id;
    @Column(name = "dataSessao")
    private Date data;
    @Column(name = "eventoSessao")
    private Evento evento;
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
    @Column(name = "ministranteSessao")
    private List<Ministrante> ministrante;
    @ManyToOne
    @JoinColumn(name="tipoSessao_idSessao")
    private TipoSessao tipoSessao;
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name="sessao_inscrito", 
    joinColumns=@JoinColumn(name="idInscrito"),
    inverseJoinColumns=@JoinColumn(name="idSessao"))
    @Column(name = "inscritoSessao")
    private List<Inscrito> inscrito;
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

    /**
     * @return the inscrito
     */
    public List<Inscrito> getInscrito() {
        return inscrito;
    }

    /**
     * @param inscrito the inscrito to set
     */
    public void setInscrito(List<Inscrito> inscrito) {
        this.inscrito = inscrito;
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
        return ministrante;
    }

    /**
     * @param ministrante the ministrante to set
     */
    public void setMinistrante(List<Ministrante> ministrante) {
        this.ministrante = ministrante;
    }

    /**
     * @return the tipoSessao
     */
    public TipoSessao getTipoSessao() {
        return tipoSessao;
    }

    /**
     * @param tipoSessao the tipoSessao to set
     */
    public void setTipoSessao(TipoSessao tipoSessao) {
        this.tipoSessao = tipoSessao;
    }
}
