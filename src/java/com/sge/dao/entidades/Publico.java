/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.dao.entidades;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ageeu
 */
@Entity
@Table(name = "publicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publico.findAll", query = "SELECT p FROM Publico p")
    , @NamedQuery(name = "Publico.findByIdPublico", query = "SELECT p FROM Publico p WHERE p.idPublico = :idPublico")
    , @NamedQuery(name = "Publico.findByDescricao", query = "SELECT p FROM Publico p WHERE p.descricao = :descricao")})
public class Publico implements EntityBase {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPublico")
    private Collection<Evento> eventoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_publico")
    private Long idPublico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao")
    private String descricao;

    public Publico() {
    }

    public Publico(Long idPublico) {
        this.idPublico = idPublico;
    }

    public Publico(Long idPublico, String descricao) {
        this.idPublico = idPublico;
        this.descricao = descricao;
    }

    public Long getIdPublico() {
        return idPublico;
    }

    public void setIdPublico(Long idPublico) {
        this.idPublico = idPublico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublico != null ? idPublico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publico)) {
            return false;
        }
        Publico other = (Publico) object;
        return !((this.idPublico == null && other.idPublico != null) || (this.idPublico != null && !this.idPublico.equals(other.idPublico)));
    }

    @Override
    public String toString() {
        return "com.sergipeevent.dao.entidades.Publico[ idPublico=" + idPublico + " ]";
    }

    @Override
    public Long getId() {
    return idPublico;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }
    
}
