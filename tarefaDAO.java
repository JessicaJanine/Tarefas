/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarefas;
import Conexao.classConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jéssica Janine
 */
public class tarefaDAO {
    
    private Connection conexaoDB;
    
    public tarefaDAO(){
        this.conexaoDB = classConexao.getConexao();
    }
    
    public List<TbTarefa> getTarefas() throws SQLException{
       List<TbTarefa> listaDeTarefas = new ArrayList<TbTarefa>();
       
       try {
       PreparedStatement st;
       st = this.conexaoDB.prepareStatement("SELECT * FROM tb_tarefa");
       ResultSet result = st.executeQuery();
       
       while (result.next()) {
            TbTarefa t = new TbTarefa();
            t.setNumero(result.getInt("numero"));
            t.setTitulo(result.getString("titulo"));
            t.setDescricao(result.getString("descricao"));
            t.setDeadline(result.getDate("deadline"));
            t.setPrioridade(result.getString("prioridade"));
            t.setResponsavel(result.getString("responsavel"));
            t.setSituacao(result.getString("situacao"));
            
            listaDeTarefas.add(t);
        }
       } catch (SQLException e){
           e.printStackTrace();
       }
       return listaDeTarefas;
       
    }
    
    public void inserirTarefa(TbTarefa tarefa) throws SQLException{
       Connection conexao = classConexao.getConexao();
       String sql = "INSERT INTO tb_tarefa VALUES (?,?,?,?,?,?,?)";
       
       try{
           PreparedStatement ps = conexao.prepareStatement(sql);
           ps.setInt(0, tarefa.getNumero());
           ps.setString(1, tarefa.getTitulo());
           ps.setString(2, tarefa.getDescricao());
           ps.setString(3, tarefa.getResponsavel());
           ps.setString(4, tarefa.getPrioridade());
           ps.setDate(5, (Date) tarefa.getDeadline());
           ps.setString(6, tarefa.getSituacao());
       } catch (SQLException e){
           e.printStackTrace();
       }
    }
    
    public void deleteTarefa(TbTarefa tarefa) throws SQLException{
        TbTarefa tarefa_d = new TbTarefa();
        Connection conexao = classConexao.getConexao();
        String sql = "DELETE * FROM tb_tarefa WHERE numero=?";
       
       try{
           PreparedStatement ps = conexao.prepareStatement(sql);
           ps.setInt(0, tarefa_d.getNumero());
           ps.execute();
           ps.close();
           conexao.close();
       } catch (SQLException e){
           e.printStackTrace();
       }
    }
    
     public void updateSituacao(TbTarefa tarefa) throws SQLException{
       TbTarefa tarefa_uS = new TbTarefa();
       Connection conexao = classConexao.getConexao();
       String sql = "UPDATE tb_tarefas SET situacao = 'concluida' WHERE numero = ?";
         try{
           PreparedStatement ps= conexao.prepareStatement(sql);
           ps.setInt(0, tarefa_uS.getNumero());
           ps.setString(6, tarefa_uS.getSituacao());
           ps.execute();
         
           
       } catch(SQLException erro) {
           erro.printStackTrace();
       }
  }
   
   public void updateTarefa(TbTarefa tarefa) throws SQLException{
       TbTarefa tarefa_uT = new TbTarefa();
       Connection conexao = classConexao.getConexao();
       String sql = "UPDATE tb_tarefas SET titulo = ?, descricao = ?, deadline= ?, situacao = ?, responsavel = ?, prioridade = ?  WHERE numero = ?";
       try{
           PreparedStatement ps= conexao.prepareStatement(sql);
           ps.setInt(0, tarefa_uT.getNumero());
           ps.setString(1, tarefa.getTitulo());
           ps.setString(2, tarefa.getDescricao());
           ps.setString(3, tarefa.getResponsavel());
           ps.setString(4, tarefa.getPrioridade());
           ps.setDate(5, (Date) tarefa.getDeadline());
           ps.setString(6, tarefa.getSituacao());
           ps.execute();
           
           
       } catch(SQLException erro) {
            erro.printStackTrace();
       }
    }
   
   public void selectTarefa(TbTarefa tarefa) throws SQLException{
       TbTarefa tarefa_sT = new TbTarefa();
       Connection conexao = classConexao.getConexao();   
       String sql = "SELECT * FROM tb_tarefas WHERE numero = ?";
       try{
           
           PreparedStatement ps= conexao.prepareStatement(sql);
           ps.setInt(0, tarefa_sT.getNumero());
           ps.setString(1, tarefa_sT.getTitulo());
           ps.setString(2, tarefa_sT.getDescricao());
           ps.setString(3, tarefa_sT.getResponsavel());
           ps.setString(4, tarefa_sT.getPrioridade());
           ps.setDate(5, (Date) tarefa_sT.getDeadline());
           ps.setString(6, tarefa_sT.getSituacao());
           ps.execute();
           
           
           
       } catch(SQLException erro) {
           erro.printStackTrace();
       }
       }
   
   public List<TbTarefa>buscarTituloTarefa(String titulo) throws SQLException{
       List<TbTarefa> tarefas = new ArrayList<TbTarefa>();
       try {
           PreparedStatement st;
           st = this.conexaoDB.prepareStatement("SELECT * FROM tb_tarefa WHERE titulo LIKE ?");
           st.setString(1, "%" + titulo + "%");
           ResultSet result = st.executeQuery();
           
           while (result.next()){
               TbTarefa tarefa = new TbTarefa();
               
               tarefa.setNumero(result.getInt("numero"));
               tarefa.setTitulo(result.getString("titulo"));
               tarefa.setDescricao(result.getString("descricao"));
               tarefa.setResponsavel(result.getString("responsavel"));
               tarefa.setPrioridade(result.getString("prioridade"));
               tarefa.setDeadline(result.getDate("deadline"));
               tarefa.setSituacao(result.getString("situacao"));
               
               tarefas.add(tarefa);
            }
       }
       catch (SQLException e){
           e.printStackTrace();
       }
        return tarefas;
   }
    
}
