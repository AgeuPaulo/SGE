/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.controles;

import com.sge.dao.UsuarioDAO;
import com.sge.dao.entidades.Usuario;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ageeu
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private Usuario logado = new Usuario();
    private Usuario novoUsuario = new Usuario();
    private List<Usuario> lista;
    private UsuarioDAO userdao = new UsuarioDAO();

    public UsuarioBean() {
        this.lista = userdao.listaUsuarios();
    }

    public String cadastrarUsuario() {
        Usuario u = new Usuario(novoUsuario.getLogin(), novoUsuario.getSenha(), novoUsuario.getCargo());
            this.userdao.salvar(u);
            this.lista = userdao.listaUsuarios();
            
            novoUsuario = new Usuario();
            
            return "dashboard";
    }

    public String logar() {
        setLogado(userdao.checarUsuario(getLogado().getLogin(), getLogado().getSenha()));
        if (getLogado() == null) {
            setLogado(new Usuario());
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
            return null;
        } else {
            return "dashboard";
        }
    }

    public String logout() {
        this.logado = new Usuario();
        return "login";
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
    
    public Usuario getLogado() {
        return logado;
    }

    public void setLogado(Usuario logado) {
        this.logado = logado;
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }
}
