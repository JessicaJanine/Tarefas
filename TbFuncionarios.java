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
@Table(name = "tb_funcionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFuncionarios.findAll", query = "SELECT t FROM TbFuncionarios t")
    , @NamedQuery(name = "TbFuncionarios.findByIdFuncionario", query = "SELECT t FROM TbFuncionarios t WHERE t.idFuncionario = :idFuncionario")
    , @NamedQuery(name = "TbFuncionarios.findByNome", query = "SELECT t FROM TbFuncionarios t WHERE t.nome = :nome")
    , @NamedQuery(name = "TbFuncionarios.findByCargo", query = "SELECT t FROM TbFuncionarios t WHERE t.cargo = :cargo")})
public class TbFuncionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "cargo")
    private String cargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsavel")
    private Collection<TbTarefas> tbTarefasCollection;

    public TbFuncionarios() {
    }

    public TbFuncionarios(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFuncionarios)) {
            return false;
        }
        TbFuncionarios other = (TbFuncionarios) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarefas.TbFuncionarios[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
