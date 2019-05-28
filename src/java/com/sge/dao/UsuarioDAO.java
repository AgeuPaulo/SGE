/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.dao;

import com.google.gson.Gson;
import com.sge.dao.entidades.Usuario;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
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
    private List<Usuario> listaUsuario = null;
    private Gson gson;
    
     public List<Usuario> listaUsuarios() {
        List<Usuario> usuarios = null;
        Query queryUsr = em.createQuery("select u from Usuario u", Usuario.class);
        usuarios = queryUsr.getResultList();
        return usuarios;
    }
     
     public Usuario checarUsuario(String login, String senha) {
        try {
            gson = new Gson();
            Client client = Client.create();
            WebResource webResource = client.resource("http://35.193.227.229/SODT-WEBSERVER/");

            listaUsuario = gson.fromJson(webResource.path("usuarios").get(String.class), List.class);

            for (Usuario user : listaUsuario) {
                if (user.getLogin().equals(login)) {
                    if (user.getSenha().equals(senha)) {
                        return user;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }
            return null;

        } catch (NoResultException e) {
            return null;
        }
    }
     
     public boolean confirmarSenha(String senha, String conf_senha){
        return senha.equals(conf_senha);
     }
}
