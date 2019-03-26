/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.dao;

import com.sge.dao.entidades.Programacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ageeu
 */
public class ProgramacaoDAO extends GenericDAO<Programacao> {
    
    private EntityManager em = jUtil.getEM();
    
     public List<Programacao> listaProgramacoes() {
        List<Programacao> programacoes = null;
        Query queryUsr = em.createQuery("select u from Programacao u", Programacao.class);
        programacoes = queryUsr.getResultList();
        return programacoes;
     }
    }
