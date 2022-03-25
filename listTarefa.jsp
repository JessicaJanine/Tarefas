<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Listando Tarefas</title>
    </head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Numero</th>
                <th>Titulo</th>
                <th>Descricao</th>
                <th>Responsavel</th>
                <th>Prioridade</th>
                <th>Deadline</th>
                <th>Situacao</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tarefas}" var="tarefa">
                <tr>
                    <td><c:out value="${tarefa.numero}" /></td>
                    <td><c:out value="${tarefa.titulo}" /></td>
                    <td><c:out value="${tarefa.descricao}" /></td>
                    <td><c:out value="${tarefa.responsavel}" /></td>
                    <td><c:out value="${tarefa.prioridade}" /></td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${tarefa.deadline}" /></td>
                    <td><c:out value="${tarefa.situacao}" /></td>
                    <td><a href="TarefaController?action=delete&tarefaNumero=<c:out value="${tarefa.numero}"/>">Delete</a></td>
                    <td><a href="TarefaController?action=concluir&tarefaNumero=<c:out value="${tarefa.numero}"/>">Concluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="TarefaController?action=insert">Cadastrar Tarefa</a></p>
    <p><a href="TarefaController?action=pesquisar">Pesquisar Tarefa</a></p>
    
</body>
</html>