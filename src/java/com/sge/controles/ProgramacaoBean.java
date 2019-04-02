/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.controles;

import com.sge.dao.ProgramacaoDAO;
import com.sge.dao.entidades.Evento;
import com.sge.dao.entidades.Programacao;
import com.sge.model.Iterador;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ageeu
 */
@Named(value = "programacaoBean")
@SessionScoped
public class ProgramacaoBean implements Serializable {

    private Programacao programacao = new Programacao();
    private List<Programacao> lista;
    private Evento evento = new Evento();
    private ProgramacaoDAO dao = new ProgramacaoDAO();

    public ProgramacaoBean() {
        this.lista = dao.listaProgramacoes();
    }

    public void cadastrarProgramacao() {
        this.programacao.setIdEvento(evento);
        if (validaData(this.programacao, this.programacao.getIdEvento())) {

            this.programacao.setHorario(this.programacao.getDataProg());
            this.dao.salvar(programacao);

            programacao = new Programacao();
            this.lista = this.dao.listaProgramacoes();
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "A data dessa programação é incorreta!",
                            "Erro no cadastro!"));
        }
    }

    private boolean validaData(Programacao p, Evento e) {
        return p.getDataProg().after(e.getAbertura()) && p.getDataProg().before(e.getEncerramento());
    }

    public List<Programacao> listaPorEvento(Evento ev) {

        this.lista = dao.listaProgramacoes();

        List<Programacao> listaPorEvento = new ArrayList<>();
        Iterador<Programacao> programacoes = new Iterador<>(this.lista);

        while (programacoes.hasNext()) {
            Programacao nova = (Programacao) programacoes.next();
            if (nova.getIdEvento().getIdEvento().equals(ev.getIdEvento())) {
                listaPorEvento.add(nova);
            }
        }

        return listaPorEvento;
    }

    public void excluirProgramacao() {
        dao.remover(programacao.getIdProg(), Programacao.class);

        this.lista = dao.listaProgramacoes();
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    public List<Programacao> getLista() {
        return lista;
    }

    public void setLista(List<Programacao> lista) {
        this.lista = lista;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

}
