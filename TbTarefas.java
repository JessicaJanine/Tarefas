/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarefas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.metamodel.SingularAttribute;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Jéssica Janine
 */
@Entity
@Table(name = "tb_tarefas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTarefas.findAll", query = "SELECT t FROM TbTarefas t")
    , @NamedQuery(name = "TbTarefas.findByNumero", query = "SELECT t FROM TbTarefas t WHERE t.numero = :numero")
    , @NamedQuery(name = "TbTarefas.findByTitulo", query = "SELECT t FROM TbTarefas t WHERE t.titulo = :titulo")
    , @NamedQuery(name = "TbTarefas.findByDescricao", query = "SELECT t FROM TbTarefas t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "TbTarefas.findByDeadline", query = "SELECT t FROM TbTarefas t WHERE t.deadline = :deadline")
    , @NamedQuery(name = "TbTarefas.findBySituacao", query = "SELECT t FROM TbTarefas t WHERE t.situacao = :situacao")})
public class TbTarefas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Size(max = 50)
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "responsavel", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private TbFuncionarios responsavel;
    @JoinColumn(name = "prioridade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbPrioridades prioridade;

    public TbTarefas() {
    }

    public TbTarefas(Integer numero) {
        this.numero = numero;
    }

    public TbTarefas(Integer numero, String titulo, String descricao) {
        this.numero = numero;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public TbTarefas(SingularAttribute<VwTarefas, Integer> numero, String titulo, SingularAttribute<VwTarefas, String> descricao, String deadline, String situacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TbTarefas(int numero, String titulo, String descricao, String deadline, String situacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public TbFuncionarios getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(TbFuncionarios responsavel) {
        this.responsavel = responsavel;
    }

    public TbPrioridades getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(TbPrioridades prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTarefas)) {
            return false;
        }
        TbTarefas other = (TbTarefas) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarefas.TbTarefas[ numero=" + numero + " ]";
    }
    
}
