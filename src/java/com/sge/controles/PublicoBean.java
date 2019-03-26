/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.controles;

import com.sge.dao.PublicoDAO;
import com.sge.dao.entidades.Publico;
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
@Named(value = "publicoBean")
@SessionScoped
public class PublicoBean implements Serializable {
    
 private Publico publico = new Publico();
    private List<Publico> lista;
    private PublicoDAO dao = new PublicoDAO();
    
    public PublicoBean() {
        this.lista = dao.listaPublicos();
    }
    
    public void salvarPublico() {
        this.dao.salvar(this.publico);
        this.lista = this.dao.listaPublicos();
        mensagem("Aviso", "Cadastro realizado com sucesso");
    }
    
    public void mensagem(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Publico getPublico() {
        return publico;
    }

    public void setPublico(Publico publico) {
        this.publico = publico;
    }

    public List<Publico> getLista() {
        return lista;
    }

    public void setLista(List<Publico> lista) {
        this.lista = lista;
    }
}
