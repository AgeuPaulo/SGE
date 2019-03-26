/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.dao.entidades;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ageeu
 */
@Entity
@Table(name = "eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento")
    , @NamedQuery(name = "Evento.findByDescricao", query = "SELECT e FROM Evento e WHERE e.descricao = :descricao")
    , @NamedQuery(name = "Evento.findByMaximo", query = "SELECT e FROM Evento e WHERE e.maximo = :maximo")
    , @NamedQuery(name = "Evento.findByMinimo", query = "SELECT e FROM Evento e WHERE e.minimo = :minimo")
    , @NamedQuery(name = "Evento.findByQtdSalas", query = "SELECT e FROM Evento e WHERE e.qtdSalas = :qtdSalas")
    , @NamedQuery(name = "Evento.findByClassificao", query = "SELECT e FROM Evento e WHERE e.classificao = :classificao")
    , @NamedQuery(name = "Evento.findByAbertura", query = "SELECT e FROM Evento e WHERE e.abertura = :abertura")
    , @NamedQuery(name = "Evento.findByEncerramento", query = "SELECT e FROM Evento e WHERE e.encerramento = :encerramento")})
public class Evento implements EntityBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evento")
    private Long idEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maximo")
    private int maximo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minimo")
    private int minimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtd_salas")
    private int qtdSalas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "classificao")
    private String classificao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abertura")
    @Temporal(TemporalType.DATE)
    private Date abertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "encerramento")
    @Temporal(TemporalType.DATE)
    private Date encerramento;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "id_publico", referencedColumnName = "id_publico")
    @ManyToOne(optional = false)
    private Publico idPublico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvento")
    private Collection<Programacao> programacaoCollection;

    public Evento() {
    }

    public Evento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Evento(Long idEvento, String descricao, int maximo, int minimo, int qtdSalas, String classificao, Date abertura, Date encerramento) {
        this.idEvento = idEvento;
        this.descricao = descricao;
        this.maximo = maximo;
        this.minimo = minimo;
        this.qtdSalas = qtdSalas;
        this.classificao = classificao;
        this.abertura = abertura;
        this.encerramento = encerramento;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getQtdSalas() {
        return qtdSalas;
    }

    public void setQtdSalas(int qtdSalas) {
        this.qtdSalas = qtdSalas;
    }

    public String getClassificao() {
        return classificao;
    }

    public void setClassificao(String classificao) {
        this.classificao = classificao;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getEncerramento() {
        return encerramento;
    }

    public void setEncerramento(Date encerramento) {
        this.encerramento = encerramento;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Publico getIdPublico() {
        return idPublico;
    }

    public void setIdPublico(Publico idPublico) {
        this.idPublico = idPublico;
    }

    @XmlTransient
    public Collection<Programacao> getProgramacaoCollection() {
        return programacaoCollection;
    }

    public void setProgramacaoCollection(Collection<Programacao> programacaoCollection) {
        this.programacaoCollection = programacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        return !((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento)));
    }

    @Override
    public String toString() {
        return "com.sergipeevent.dao.entidades.Evento[ idEvento=" + idEvento + " ]";
    }

    @Override
    public Long getId() {
        return idEvento;
    }

}
