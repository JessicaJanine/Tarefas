/*
Jéssica Janine
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Tarefa;
import util.DbUtil;

public class TarefaDao {

    private Connection connection;

    public TarefaDao() {
        connection = DbUtil.getConnection();
    }

    public void addTarefa(Tarefa tarefa) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into tb_tarefa(titulo,descricao,responsavel,prioridade,deadline,situacao) values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, tarefa.getTitulo());
            preparedStatement.setString(2, tarefa.getDescricao());
            preparedStatement.setString(3, tarefa.getResponsavel());
            preparedStatement.setString(4, tarefa.getPrioridade());
            System.out.println(tarefa.getDeadline());
            preparedStatement.setDate(5, new java.sql.Date(tarefa.getDeadline().getTime()));
            preparedStatement.setString(6, tarefa.getSituacao());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTarefa(int tarefaNumero) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from tb_tarefa where numero=?");
            preparedStatement.setInt(1, tarefaNumero);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public void updateSituacao(int tarefaNumero) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update tb_tarefa set situacao= 'concluida'" +
                            "where numero=?");
                  
            preparedStatement.setInt(1, tarefaNumero);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tarefa> getAllTarefas() {
        List<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tb_tarefa order by numero");
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setNumero(rs.getInt("numero"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setResponsavel(rs.getString("responsavel"));
                tarefa.setPrioridade(rs.getString("prioridade"));
                tarefa.setDeadline(rs.getDate("deadline"));
                tarefa.setSituacao(rs.getString("situacao"));
                listaDeTarefas.add(tarefa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeTarefas;
    }

    public Tarefa getTarefaByNumero() {
        Tarefa tarefa = new Tarefa();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tb_tarefa where numero=?");
            preparedStatement.setInt(1, tarefa.getNumero());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tarefa.setNumero(rs.getInt("numero"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setResponsavel(rs.getString("responsavel"));
                tarefa.setPrioridade(rs.getString("prioridade"));
                tarefa.setDeadline(rs.getDate("deadline"));
                tarefa.setSituacao(rs.getString("situacao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarefa;
    }
     public Tarefa getTarefaByTitulo() {
        Tarefa tarefa = new Tarefa();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tb_tarefa where titulo=?");
            preparedStatement.setString(1, tarefa.getTitulo());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tarefa.setNumero(rs.getInt("numero"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setResponsavel(rs.getString("responsavel"));
                tarefa.setPrioridade(rs.getString("prioridade"));
                tarefa.setDeadline(rs.getDate("deadline"));
                tarefa.setSituacao(rs.getString("situacao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarefa;
    }
      public Tarefa getTarefaByResponsavel() {
        Tarefa tarefa = new Tarefa();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tb_tarefa where responsavel=?");
            preparedStatement.setString(1, tarefa.getResponsavel());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tarefa.setNumero(rs.getInt("numero"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setResponsavel(rs.getString("responsavel"));
                tarefa.setPrioridade(rs.getString("prioridade"));
                tarefa.setDeadline(rs.getDate("deadline"));
                tarefa.setSituacao(rs.getString("situacao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarefa;
    }
}