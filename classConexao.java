/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import Tarefas.TbTarefas;
import Tarefas.VwTarefas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jéssica Janine
 */
public class classConexao {
   
   public static Connection conn = null;
    
 public classConexao() throws SQLException{
        if(conn == null){
           try{
            Class.forName("org.postgres.Driver");
            
            }
                catch(ClassNotFoundException e){
                System.err.println("SQLException: " + e.getMessage());
            }
            
        }
        
    String url = "jdbc:postgresql://localhost:5432/Tarefas";
    String usuario = "postgres";
    String senha = "201291";
   conn = DriverManager.getConnection(url, usuario, senha);
        
 }
 
 public static void fecharConexao() throws SQLException{
     if (conn != null){
         conn.close();
    }
 }
 
 public boolean cadastrar(TbTarefas tarefa) throws Exception{
      
     PreparedStatement ps = null;
     Connection conn = null;
     if (tarefa == null) throw new Exception ("O valor passado não pode ser nulo");
     
     try {
         String sql = "INSERT INTO tb_tarefas (numero, titulo, descricao, deadline, situacao, responsavel, prioridade)" 
                 + "VALUES (?, ?, ?, ?, ?, ?, ?)";
         conn = this.conn;
         ps = conn.prepareStatement(sql);
         ps.setInt(1,tarefa.getNumero());
         ps.setString(2, tarefa.getTitulo());
         ps.setString(3, tarefa.getDescricao());
         ps.setDate(4, (Date) tarefa.getDeadline());
         ps.setString(5, tarefa.getSituacao());
         ps.setObject(6, tarefa.getResponsavel());
         ps.setObject(7, tarefa.getPrioridade());
         
         ps.executeUpdate();
         
         return true;
         
     } catch (SQLException sqle) {
         throw new Exception ("Erro ao cadastrar tarefa" + sqle);
     } finally {
         fecharConexao();
     }
 }
 
 public List<VwTarefas> listTarefas() {
       ArrayList<VwTarefas> tarefas = new ArrayList<VwTarefas>();
       Statement st = null;
       ResultSet rs = null;
       
       try{
           st = conn.createStatement();
           String sql = "SELECT * FROM vw_tarefas";
           rs = st.executeQuery(sql);
           
          while (rs.next()){
              
              VwTarefas tarefa = new VwTarefas(); 
              tarefa.setNumero(rs.getInt("numero"));
              tarefa.setTitulo(rs.getString("titulo"));
              tarefa.setDescricao(rs.getString("descricao"));
              tarefa.setDeadline(rs.getDate("deadline"));
              tarefa.setSituacao(rs.getString("situacao"));
              tarefa.setPrioridade(rs.getString("prioridade"));
              tarefa.setResponsavel(rs.getString("responsavel"));
              
              tarefas.add(tarefa);
                                  
          } 
        }
        catch(SQLException ex){
                System.err.println("SQLException: " + ex.getMessage());
                System.err.println("SQLState: " + ex.getSQLState());
                System.err.println("VendorError: " + ex.getErrorCode());
                return null;
          
        }  finally {
           try{
               if (rs != null){
                   rs.close();
               }
               if (st != null){
                   st.close();
               }
               if (classConexao.conn != null){
                   classConexao.conn.close();
               }
           }
             catch(SQLException ex){
                System.err.println("SQLException: " + ex.getMessage());
                System.err.println("SQLState: " + ex.getSQLState());
                System.err.println("VendorError: " + ex.getErrorCode());
                return null;
         } 
       }
       return tarefas;
   }
 public void excluirTarefa(TbTarefas tarefa) throws SQLException{
      TbTarefas et = new TbTarefas();
       try{
           Connection con = conn;
           PreparedStatement ps = con.prepareStatement("DELET * FROM tb_tarefas where numero = ?");
           
           ps.setInt(1, et.getNumero());
           ps.execute();
           ps.close();
           con.close();           
       } catch (SQLException a){
           System.out.print("Erro ao marcar tarefa como concluída: " + a.getMessage());
       }
   }
   
   public void concluirTarefa(TbTarefas tarefa) throws SQLException{
       try{
           String sql = "UPDATE tb_tarefas SET situacao = 'concluida' WHERE numero = ?";
           PreparedStatement ps= conn.prepareStatement(sql);
           ps.setInt(1, tarefa.getNumero());
           ps.execute();
           
           JOptionPane.showMessageDialog(null, "Tarefa concluída");
       } catch(SQLException erro) {
           JOptionPane.showMessageDialog(null, "Erro ao marcar tarefa como concluída" + erro.getMessage());  
       }
       fecharConexao();
   }
   
   public void atualizarTarefa(TbTarefas tarefa) throws SQLException{
       try{
           String sql = "UPDATE tb_tarefas SET numero = ?, titulo = ?, descricao = ?, deadline= ?, situacao = ?, responsavel = ?, prioridade = ?  WHERE numero = ?";
           PreparedStatement ps= conn.prepareStatement(sql);
           ps.setInt(1, tarefa.getNumero());
           ps.execute();
           
           JOptionPane.showMessageDialog(null, "Tarefa atualizada com sucesso");
       } catch(SQLException erro) {
           JOptionPane.showMessageDialog(null, "Erro ao atualizar tarefa" + erro.getMessage());  
       }
       fecharConexao();
       }
   
   public String pesquisarTarefa(TbTarefas tarefa, String tarefa1) throws SQLException{
          try{
           String sql = "SELECT * FROM tb_tarefas WHERE numero = ? AND situacao = 'em anadamento'";
           PreparedStatement ps= conn.prepareStatement(sql);
           ps.setInt(1, tarefa.getNumero());
           ps.setString(2, tarefa.getTitulo());
           ps.setString(3, tarefa.getDescricao());
           ps.setObject(4, tarefa.getPrioridade());
           ps.setObject(5, tarefa.getResponsavel());
           ps.setString(6, tarefa.getSituacao());
           ps.execute();
           
           JOptionPane.showMessageDialog(null, "Tarefa encontrada");
       } catch(SQLException erro) {
           JOptionPane.showMessageDialog(null, "Erro ao buscar tarefa" + erro.getMessage());  
       }
       fecharConexao();
        return tarefa1;
       }
 
    
}
