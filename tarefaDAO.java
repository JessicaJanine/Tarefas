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
    public List<TbTarefa> listarTarefas() throws SQLException{
       List<TbTarefa> listaDeTarefas = new ArrayList<TbTarefa>();
       Connection conexao = classConexao.getConexao();
       String sql = "SELECT * FROM tb_tarefa";
       try {
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            TbTarefa t = new TbTarefa();
            t.setNumero(rs.getInt("numero"));
            t.setTitulo(rs.getString("titulo"));
            t.setDescricao(rs.getString("descricao"));
            t.setDeadline(rs.getDate("deadline"));
            t.setPrioridade(rs.getString("prioridade"));
            t.setResponsavel(rs.getString("responsavel"));
            t.setSituacao(rs.getString("situacao"));
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
           ps.setInt(1, tarefa.getNumero());
           ps.setString(2, tarefa.getTitulo());
           ps.setString(3, tarefa.getDescricao());
           ps.setString(4, tarefa.getResponsavel());
           ps.setString(5, tarefa.getPrioridade());
           ps.setDate(6, (Date) tarefa.getDeadline());
           ps.setString(7, tarefa.getSituacao());
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
           ps.setInt(1, tarefa_d.getNumero());
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
           ps.setInt(1, tarefa_uS.getNumero());
           ps.setString(7, tarefa_uS.getSituacao());
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
           ps.setInt(1, tarefa_uT.getNumero());
           ps.setString(2, tarefa.getTitulo());
           ps.setString(3, tarefa.getDescricao());
           ps.setString(4, tarefa.getResponsavel());
           ps.setString(5, tarefa.getPrioridade());
           ps.setDate(6, (Date) tarefa.getDeadline());
           ps.setString(7, tarefa.getSituacao());
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
           ps.setInt(1, tarefa_sT.getNumero());
           ps.setString(2, tarefa_sT.getTitulo());
           ps.setString(3, tarefa_sT.getDescricao());
           ps.setString(4, tarefa_sT.getResponsavel());
           ps.setString(5, tarefa_sT.getPrioridade());
           ps.setDate(6, (Date) tarefa_sT.getDeadline());
           ps.setString(7, tarefa_sT.getSituacao());
           ps.execute();
           
           
       } catch(SQLException erro) {
           erro.printStackTrace();
       }
       }
    
}
