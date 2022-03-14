/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Conexao.classConexao;
import Tarefas.TbTarefas;
import Tarefas.VwTarefas;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author Jéssica Janine
 */

@ManagedBean
@SessionScoped

public class listaDeTarefas {
    public listaDeTarefas(){
    
}
     public List<VwTarefas> getTarefas() throws SQLException{
        classConexao con = new classConexao();
        List<VwTarefas> tarefas = con.listTarefas();
        
        return tarefas;
    }
   
   
}
