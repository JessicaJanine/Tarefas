/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Tarefas.TbTarefa;
import Tarefas.tarefaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Jéssica Janine
 */

@ManagedBean
@SessionScoped

public class listaDeTarefas {
    private TbTarefa tarefa;
    private List <TbTarefa> todasTarefas;
    
    public listaDeTarefas(){
    tarefa = new TbTarefa();
    todasTarefas = new ArrayList<TbTarefa>();
}
    
    public List<TbTarefa>getTarefas() throws SQLException{
      tarefaDAO tarefa_dao = new tarefaDAO();
      todasTarefas = tarefa_dao.getTarefas();
      return todasTarefas;
  }
  
  public void setTbTarefa(List<TbTarefa>todasTarefas){
      this.todasTarefas = todasTarefas;
  }
  
   public String atualizar() throws SQLException{
      tarefaDAO tarefa_dao = new tarefaDAO();
      tarefa_dao.updateTarefa(tarefa);
      tarefa = new TbTarefa();
      FacesMessage msg = new FacesMessage("Tarefa atualizada com sucesso!");
      msg.setSeverity(FacesMessage.SEVERITY_INFO);
      FacesContext.getCurrentInstance().addMessage("", msg);
      return "/listartarefas.jsf";
  }
   
   public String concluir() throws SQLException{
      tarefaDAO tarefa_dao = new tarefaDAO();
      tarefa_dao.updateSituacao(tarefa);
      tarefa = new TbTarefa();
      FacesMessage msg = new FacesMessage("Tarefa concluída com sucesso!");
      msg.setSeverity(FacesMessage.SEVERITY_INFO);
      FacesContext.getCurrentInstance().addMessage("", msg);
      return "/listartarefas.jsf";
  }
   
   public String excluir() throws SQLException{
      tarefaDAO tarefa_dao = new tarefaDAO();
      tarefa_dao.deleteTarefa(tarefa);
      tarefa = new TbTarefa();
      FacesMessage msg = new FacesMessage("A tarefa foi deletada");
      msg.setSeverity(FacesMessage.SEVERITY_INFO);
      FacesContext.getCurrentInstance().addMessage("", msg);
      return "/listartarefas.jsf";
  }
   
  public String pesquisar() throws SQLException{
      tarefaDAO tarefa_dao = new tarefaDAO();
      tarefa_dao.selectTarefa(tarefa);
      tarefa = new TbTarefa();
      FacesMessage msg = new FacesMessage("A tarefa foi deletada");
      msg.setSeverity(FacesMessage.SEVERITY_INFO);
      FacesContext.getCurrentInstance().addMessage("", msg);
      return "/listartarefas.jsf";
  }
  public TbTarefa getTbTarefa(){
      return tarefa;
  }
  
  public void setTbTarefa(TbTarefa tarefa){
      this.tarefa = tarefa;
  }
  
    public List<TbTarefa>buscarTituloTarefa(String titulo) throws SQLException{
      tarefaDAO tarefa_titulo = new tarefaDAO();
        List<TbTarefa> tarefas = tarefa_titulo.buscarTituloTarefa(titulo);
      return tarefas;
  }
 }
 
