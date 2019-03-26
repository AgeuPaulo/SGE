/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.dao.entidades;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ageeu
 */
@Entity
@Table(name = "programacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programacao.findAll", query = "SELECT p FROM Programacao p")
    , @NamedQuery(name = "Programacao.findByIdProg", query = "SELECT p FROM Programacao p WHERE p.idProg = :idProg")
    , @NamedQuery(name = "Programacao.findByTipo", query = "SELECT p FROM Programacao p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Programacao.findByDataProg", query = "SELECT p FROM Programacao p WHERE p.dataProg = :dataProg")
    , @NamedQuery(name = "Programacao.findByHorario", query = "SELECT p FROM Programacao p WHERE p.horario = :horario")
    , @NamedQuery(name = "Programacao.findByResponsavel", query = "SELECT p FROM Programacao p WHERE p.responsavel = :responsavel")
    , @NamedQuery(name = "Programacao.findByTipoLocal", query = "SELECT p FROM Programacao p WHERE p.tipoLocal = :tipoLocal")
    , @NamedQuery(name = "Programacao.findByLocalEvento", query = "SELECT p FROM Programacao p WHERE p.localEvento = :localEvento")})
public class Programacao implements EntityBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prog")
    private Long idProg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_prog")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Date horario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "responsavel")
    private String responsavel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_local")
    private String tipoLocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "local_evento")
    private String localEvento;
    @JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
    @ManyToOne(optional = false)
    private Evento idEvento;

    public Programacao() {
    }

    public Programacao(Long idProg) {
        this.idProg = idProg;
    }

    public Programacao(Long idProg, String tipo, String descricao, Date dataProg, Date horario, String responsavel, String tipoLocal, String localEvento) {
        this.idProg = idProg;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataProg = dataProg;
        this.horario = horario;
        this.responsavel = responsavel;
        this.tipoLocal = tipoLocal;
        this.localEvento = localEvento;
    }

    public Long getIdProg() {
        return idProg;
    }

    public void setIdProg(Long idProg) {
        this.idProg = idProg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataProg() {
        return dataProg;
    }

    public void setDataProg(Date dataProg) {
        this.dataProg = dataProg;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
         int result = 1;
         result = prime * result + ((idProg == null) ? 0 : idProg.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof Programacao)) {
            return false;
        }

        if (obj == this) {
            return true;
        }
        Programacao programacao = (Programacao) obj;
        
        return (this.idProg != null && this.idProg.equals(programacao.idProg));
    }

    @Override
    public String toString() {
        return "com.sergipeevent.dao.entidades.Programacao[ idProg=" + idProg + " ]";
    }

    @Override
    public Long getId() {
        return idProg;
    }

}
