/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jéssica Janine
 */
public class classConexao {
   
   private static Connection conn;
   
 public static Connection setConexao() throws SQLException{
        if(conn == null){
    String url = "jdbc:postgresql://localhost:5432/eSig-TarefasTimerzone=UTC";
    String usuario = "postgres";
    String senha = "201291";
           try{
            Class.forName("org.postgres.Driver");
            conn = DriverManager.getConnection(url, usuario, senha);
            }
                catch(ClassNotFoundException e){
                System.err.println("SQLException: " + e.getMessage());
            }
        } 
        return conn;
 }

    public static Connection getConexao() {
        return conn; 
    }

}