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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author PabloHenrique
 */
@Entity
@Table(name = "Inscrito")
 
public class Inscrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInscrito")
    private int id;
    @Column(name = "nomeInscrito")
    private String nome;
    @Column(name = "cpfInscrito")
    private String cpf;
    @Column(name = "instituicaoInscrito")
    private String instituicao;
    @Column(name = "naturalidadeInscrito")
    private String naturalidade;
    @Column(name = "dataNascimentoInscrito")
    private Date dataNascimento;
    @Column(name = "emailInscrito")
    private String email;
    @Column(name = "sessao")
    @ManyToMany(mappedBy = "inscritos", cascade = CascadeType.ALL)
    private List<Sessao> sessao;

    public Inscrito(String nome, String cpf, String instituicao, String naturalidade, Date dataNascimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.instituicao = instituicao;
        this.naturalidade = naturalidade;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }
    public Inscrito(int id, String nome, String cpf, String instituicao, String naturalidade, Date dataNascimento, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.instituicao = instituicao;
        this.naturalidade = naturalidade;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public Inscrito() {
    }

    
    
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the Instituicao
     */
    public String getInstituicao() {
        return instituicao;
    }

    /**
     * @param Instituicao the Instituicao to set
     */
    public void setInstituicao(String Instituicao) {
        this.instituicao = Instituicao;
    }

    /**
     * @return the naturalidade
     */
    public String getNaturalidade() {
        return naturalidade;
    }

    /**
     * @param naturalidade the naturalidade to set
     */
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
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
     * @return the sessao
     */
    public List<Sessao> getSessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setSessao(List<Sessao> sessao) {
        this.sessao = sessao;
    }
}
