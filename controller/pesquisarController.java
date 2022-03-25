/*
Jéssica Janine
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Tarefa;
import dao.TarefaDao;

/**
 *
 * @author Jéssica Janine
 */

@ManagedBean
@SessionScoped

public class pesquisarController {
    
    private Tarefa tarefa;
    private List<Tarefa> todasTarefas;
    
    public pesquisarController(){
        tarefa = new Tarefa();
        todasTarefas = new ArrayList<Tarefa>();
    }
    
    public Tarefa getTarefa(){
        return tarefa;
    }
    
    public void setTarefa(Tarefa tarefa){
        this.tarefa = tarefa;
    }
    
    public Tarefa getTarefasNum(){
        TarefaDao  tarefa_dao = new TarefaDao();
        tarefa = tarefa_dao.getTarefaByNumero();
        return tarefa;
    }
    
     public Tarefa getTarefasTit(){
        TarefaDao  tarefa_dao = new TarefaDao();
        tarefa = tarefa_dao.getTarefaByTitulo();
        return tarefa;
    }
    
     public Tarefa getTarefasResp(){
        TarefaDao  tarefa_dao = new TarefaDao();
        tarefa = tarefa_dao.getTarefaByResponsavel();
        return tarefa;
    }
    
  
    
}
