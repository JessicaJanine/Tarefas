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
 *ManageBean para realizar o cadastro de Tarefas
 * @author Jéssica Janine
 */
@ManagedBean
@SessionScoped
public class CadastroMBean {
    private TbTarefa tarefa;
    
    private List <TbTarefa> todasTarefas;
    
    public CadastroMBean(){
    tarefa = new TbTarefa();
    todasTarefas = new ArrayList<TbTarefa>();
    }
    
    public String entrarCadastro(){
        return "/listartarefas.jsf";
    }
    
  public String cadastrar() throws SQLException{
      tarefaDAO tarefa_dao = new tarefaDAO();
      tarefa_dao.inserirTarefa(tarefa);
      tarefa = new TbTarefa();
      FacesMessage msg = new FacesMessage("Tarefa cadastrada com sucesso!");
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
  
  public List<TbTarefa>getTarefas() throws SQLException{
      tarefaDAO tarefa_dao = new tarefaDAO();
      todasTarefas = tarefa_dao.getTarefas();
      return todasTarefas;
  }
  
  public void setTbTarefa(List<TbTarefa>todasTarefas){
      this.todasTarefas = todasTarefas;
  }


}

