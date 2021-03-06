/*
Jéssica Janine
 */
package model;

import java.util.Date;

public class Tarefa {

    private int numero;
    private String titulo;
    private String descricao;
    private String responsavel;
    private String prioridade;
    private Date deadline;
    private String situacao;
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
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
    public String toString() {
        return "Tarefa [numero=" + numero + ", titulo=" + titulo
                + ", descricao=" + descricao + ", responsavel=" + responsavel +  ", prioridade=" + prioridade +", deadline=" + deadline + ", situacao="
                + situacao + "]";
    }    
}