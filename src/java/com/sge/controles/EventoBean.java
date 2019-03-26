/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.controles;

import com.sge.dao.EventoDAO;
import com.sge.dao.entidades.Categoria;
import com.sge.dao.entidades.Evento;
import com.sge.dao.entidades.Publico;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ageeu
 */
@Named(value = "eventoBean")
@RequestScoped
public class EventoBean {

    private Evento evento = new Evento();
    private Categoria categoria = new Categoria();
    private Publico publico = new Publico();
    private List<Evento> lista;
    private EventoDAO dao = new EventoDAO();

    public EventoBean() {
        this.lista = dao.listaEventos();
    }

    public Evento getEvento() {
        return evento;
    }

    public void cadastrarEvento() {
        evento.setIdCategoria(categoria);
        evento.setIdPublico(publico);

        dao.salvar(evento);

        this.evento = new Evento();
        this.categoria = new Categoria();
        this.publico = new Publico();

        this.lista = dao.listaEventos();

        mensagem("Aviso", "Cadastro realizado com sucesso");
    }

    public void mensagem(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Publico getPublico() {
        return publico;
    }

    public void setPublico(Publico publico) {
        this.publico = publico;
    }

    public List<Evento> getLista() {
        return lista;
    }

    public void setLista(List<Evento> lista) {
        this.lista = lista;
    }

}
