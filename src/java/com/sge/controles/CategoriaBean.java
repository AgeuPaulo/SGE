/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.controles;

import com.sge.dao.CategoriaDAO;
import com.sge.dao.entidades.Categoria;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ageeu
 */
@Named(value = "categoriaBean")
@SessionScoped
public class CategoriaBean implements Serializable {

    private Categoria categoria = new Categoria();
    private List<Categoria> lista;
    private CategoriaDAO dao = new CategoriaDAO();

    public CategoriaBean() {
        this.lista = dao.listaCategorias();
    }
    
    public void salvarCategoria() {
        this.dao.salvar(this.categoria);
        this.lista = this.dao.listaCategorias();
        mensagem("Aviso", "Cadastro realizado com sucesso");
    }
    
    public void mensagem(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getLista() {
        return lista;
    }

    public void setLista(List<Categoria> lista) {
        this.lista = lista;
    }
}
