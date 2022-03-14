/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarefas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jéssica Janine
 */
@Entity
@Table(name = "vw_tarefas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwTarefas.findAll", query = "SELECT v FROM VwTarefas v")
    , @NamedQuery(name = "VwTarefas.findByNumero", query = "SELECT v FROM VwTarefas v WHERE v.numero = :numero")
    , @NamedQuery(name = "VwTarefas.findByTitulo", query = "SELECT v FROM VwTarefas v WHERE v.titulo = :titulo")
    , @NamedQuery(name = "VwTarefas.findByDescricao", query = "SELECT v FROM VwTarefas v WHERE v.descricao = :descricao")
    , @NamedQuery(name = "VwTarefas.findByDeadline", query = "SELECT v FROM VwTarefas v WHERE v.deadline = :deadline")
    , @NamedQuery(name = "VwTarefas.findBySituacao", query = "SELECT v FROM VwTarefas v WHERE v.situacao = :situacao")
    , @NamedQuery(name = "VwTarefas.findByPrioridade", query = "SELECT v FROM VwTarefas v WHERE v.prioridade = :prioridade")
    , @NamedQuery(name = "VwTarefas.findByResponsavel", query = "SELECT v FROM VwTarefas v WHERE v.responsavel = :responsavel")})
public class VwTarefas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 50)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 200)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Size(max = 50)
    @Column(name = "situacao")
    private String situacao;
    @Size(max = 20)
    @Column(name = "prioridade")
    private String prioridade;
    @Size(max = 50)
    @Column(name = "responsavel")
    private String responsavel;

    public VwTarefas() {
    }

    public VwTarefas(int numero, String titulo, String descricao, String deadline, String situacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VwTarefas(int numero, String titulo, String descricao, String deadline, String situacao, String responsavel, String prioridade) {
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

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
}
