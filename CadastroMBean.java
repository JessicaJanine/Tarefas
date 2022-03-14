/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Conexao.classConexao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Tarefas.TbTarefas;
import Tarefas.VwTarefas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *ManageBean para realizar o cadastro de Tarefas
 * @author Jéssica Janine
 */
@ManagedBean
@SessionScoped
public class CadastroMBean {
    public TbTarefas tarefa = new TbTarefas();
    
    public String castrarTarefa() throws SQLException, Exception{
        classConexao con = new classConexao();
        
        if (con.cadastrar(tarefa)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Tarefa cadastrada com sucesso!"));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao cadastrar tarefa"));
        }
        con.fecharConexao();
        return "";
    }
    public List<VwTarefas> getTarefas() throws SQLException{
        classConexao con = new classConexao();
        List<VwTarefas> tarefas = con.listTarefas();
        
        return tarefas;
    }
    public TbTarefas getTbTarefas(){
        return tarefa;
    }
    
    public void setTarefa(TbTarefas tarefa){
        this.tarefa = tarefa;
    }
 
}
