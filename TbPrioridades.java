/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarefas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Jéssica Janine
 */
@Entity
@Table(name = "tb_prioridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPrioridades.findAll", query = "SELECT t FROM TbPrioridades t")
    , @NamedQuery(name = "TbPrioridades.findById", query = "SELECT t FROM TbPrioridades t WHERE t.id = :id")
    , @NamedQuery(name = "TbPrioridades.findByOrdemDePrioridade", query = "SELECT t FROM TbPrioridades t WHERE t.ordemDePrioridade = :ordemDePrioridade")})
public class TbPrioridades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ordem_de_prioridade")
    private String ordemDePrioridade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prioridade")
    private Collection<TbTarefas> tbTarefasCollection;

    public TbPrioridades() {
    }

    public TbPrioridades(Integer id) {
        this.id = id;
    }

    public TbPrioridades(Integer id, String ordemDePrioridade) {
        this.id = id;
        this.ordemDePrioridade = ordemDePrioridade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdemDePrioridade() {
        return ordemDePrioridade;
    }

    public void setOrdemDePrioridade(String ordemDePrioridade) {
        this.ordemDePrioridade = ordemDePrioridade;
    }

    @XmlTransient
    public Collection<TbTarefas> getTbTarefasCollection() {
        return tbTarefasCollection;
    }

    public void setTbTarefasCollection(Collection<TbTarefas> tbTarefasCollection) {
        this.tbTarefasCollection = tbTarefasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPrioridades)) {
            return false;
        }
        TbPrioridades other = (TbPrioridades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarefas.TbPrioridades[ id=" + id + " ]";
    }
    
}
