/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.dao;

import com.sge.dao.entidades.Evento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ageeu
 */
public class EventoDAO extends GenericDAO<Evento> {
    private EntityManager em = jUtil.getEM();
    
     public List<Evento> listaEventos() {
        List<Evento> eventos = null;
        Query queryUsr = em.createQuery("select u from Evento u", Evento.class);
        eventos = queryUsr.getResultList();
        return eventos;
    }
}
