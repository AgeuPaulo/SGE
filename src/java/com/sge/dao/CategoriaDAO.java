/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.dao;

import com.sge.dao.entidades.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ageeu
 */
public class CategoriaDAO extends GenericDAO<Categoria> {
    
    private EntityManager em = jUtil.getEM();
    
     public List<Categoria> listaCategorias() {
        List<Categoria> categorias = null;
        Query queryUsr = em.createQuery("select u from Categoria u", Categoria.class);
        categorias = queryUsr.getResultList();
        return categorias;
    }
}
