/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.dao;

import com.sge.dao.entidades.Publico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ageeu
 */
public class PublicoDAO extends GenericDAO<Publico> {
    
    private EntityManager em = jUtil.getEM();
     public List<Publico> listaPublicos() {
        List<Publico> publicos = null;
        Query queryUsr = em.createQuery("select u from Publico u", Publico.class);
        publicos = queryUsr.getResultList();
        return publicos;
    }
}
