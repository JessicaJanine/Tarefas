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
 * @author adrie
 */
@Entity
@Table(name = "tb_tarefa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTarefa.findAll", query = "SELECT t FROM TbTarefa t")
    , @NamedQuery(name = "TbTarefa.findByNumero", query = "SELECT t FROM TbTarefa t WHERE t.numero = :numero")
    , @NamedQuery(name = "TbTarefa.findByTitulo", query = "SELECT t FROM TbTarefa t WHERE t.titulo = :titulo")
    , @NamedQuery(name = "TbTarefa.findByDescricao", query = "SELECT t FROM TbTarefa t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "TbTarefa.findByResponsavel", query = "SELECT t FROM TbTarefa t WHERE t.responsavel = :responsavel")
    , @NamedQuery(name = "TbTarefa.findByPrioridade", query = "SELECT t FROM TbTarefa t WHERE t.prioridade = :prioridade")
    , @NamedQuery(name = "TbTarefa.findByDeadline", query = "SELECT t FROM TbTarefa t WHERE t.deadline = :deadline")
    , @NamedQuery(name = "TbTarefa.findBySituacao", query = "SELECT t FROM TbTarefa t WHERE t.situacao = :situacao")})
public class TbTarefa implements Serializable {

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
    @Size(max = 100)
    @Column(name = "responsavel")
    private String responsavel;
    @Size(max = 50)
    @Column(name = "prioridade")
    private String prioridade;
    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Size(max = 50)
    @Column(name = "situacao")
    private String situacao;

    public TbTarefa() {
    }

    public TbTarefa(Integer numero) {
        this.numero = numero;
    }

    public TbTarefa(Integer numero, String titulo, String descricao) {
        this.numero = numero;
        this.titulo = titulo;
        this.descricao = descricao;
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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTarefa)) {
            return false;
        }
        TbTarefa other = (TbTarefa) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conexao.TbTarefa[ numero=" + numero + " ]";
    }
    
}
