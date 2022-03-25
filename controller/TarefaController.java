package controller;


import dao.TarefaDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tarefa;
import org.jboss.weld.context.RequestContext;



@WebServlet(name = "Tarefas", urlPatterns = {"/TarefaController"})
public class TarefaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/cadTarefa.jsp";
    private static String LIST_TAREFA = "/listTarefa.jsp";
    private static String PESQ_TAREFA = "/WEB-INF/pesquisarTarefa.xhtml";
    private TarefaDao dao;

    public TarefaController() {
        super();
        dao = new TarefaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        

        if (action.equalsIgnoreCase("delete")){
            int tarefaNumero = Integer.parseInt(request.getParameter("tarefaNumero"));
            dao.deleteTarefa(tarefaNumero);
            forward = LIST_TAREFA;
            request.setAttribute("tarefas", dao.getAllTarefas());    
        } else if (action.equalsIgnoreCase("concluir")){
           int tarefaNumero = Integer.parseInt(request.getParameter("tarefaNumero"));
           dao.updateSituacao(tarefaNumero);
           forward = LIST_TAREFA;
           request.setAttribute("tarefas", dao.getAllTarefas()); 
        } else if (action.equalsIgnoreCase("listTarefa")){
            forward = LIST_TAREFA;
            request.setAttribute("tarefas", dao.getAllTarefas());
        } else if (action.equalsIgnoreCase("pesquisar")){
            forward = PESQ_TAREFA;
        } 
        else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(request.getParameter("titulo"));
        tarefa.setDescricao(request.getParameter("descricao"));
        tarefa.setResponsavel(request.getParameter("responsavel"));
        tarefa.setPrioridade(request.getParameter("prioridade"));
        try {
            Date deadline=null;
            String teste = request.getParameter("deadline");
            System.out.println(teste);
            if(request.getParameter("deadline")!=null){
                deadline = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("deadline"));
            }
            else{
                deadline = null;
            }
                
            tarefa.setDeadline(deadline);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tarefa.setSituacao(request.getParameter("situacao"));
                
        String tarefaNumero = request.getParameter("tarefaNumero");
        
        dao.addTarefa(tarefa);
       
        RequestDispatcher view = request.getRequestDispatcher(LIST_TAREFA);
        request.setAttribute("tarefas", dao.getAllTarefas());
        view.forward(request, response);
    }
}