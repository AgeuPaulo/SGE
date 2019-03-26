/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.dao;

import com.sge.dao.entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Ageeu
 */
public class UsuarioDAO extends GenericDAO<Usuario> {
    
    private EntityManager em = jUtil.getEM();
    
     public List<Usuario> listaUsuarios() {
        List<Usuario> usuarios = null;
        Query queryUsr = em.createQuery("select u from Usuario u", Usuario.class);
        usuarios = queryUsr.getResultList();
        return usuarios;
    }
     
     public Usuario checarUsuario(String login, String senha) {
        try {
            Usuario usuario = (Usuario) em
                    .createQuery(
                            "SELECT u from Usuario u where u.login = :login and u.senha = :senha")
                    .setParameter("login", login)
                    .setParameter("senha", senha).getSingleResult();

            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }
     
     public boolean confirmarSenha(String senha, String conf_senha){
        return senha.equals(conf_senha);
     }
}
