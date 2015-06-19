/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PabloHenrique
 */
//@Entity
//@Table(name = "TipoSessao")
public enum TipoSessao {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
            
    MINICURSO("Mini Curso"), PALESTRA("Palestra");
    
    private String descricao;

    private TipoSessao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    
}
