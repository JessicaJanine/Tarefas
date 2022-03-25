<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript" src="http://www.godtur.no/godtur/js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Cadastrar Tarefa</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=deadline]').datepicker();
        });
    </script>

    <form method="POST" action='TarefaController' name="frmAddTarefa">
         Numero : <input
            type="text" name="numero"
            value="<c:out value="${tarefa.numero}" />" /> <br /> 
        Titulo : <input
            type="text" name="titulo"
            value="<c:out value="${tarefa.titulo}" />" /> <br /> 
        Descricao : <input
            type="text" name="descricao"
            value="<c:out value="${tarefa.descricao}" />" /> <br /> 
        Responsavel : <input
            type="text" name="responsavel"
            value="<c:out value="${tarefa.responsavel}" />" /> <br /> 
        Prioridade : <input
            type="text" name="prioridade"
            value="<c:out value="${tarefa.prioridade}" />" /> <br /> 
        DEADLINE : <input
            type="text" placeholder="dd/MM/yyyy" name="deadline" data-date-format="dd/MM/yyyy"
            value="<fmt:formatDate pattern="dd/MM/yyyy" value="${tarefa.deadline}" />" /> <br /> 
        Situacao : <input type="text" name="situacao"
            value="<c:out value="${tarefa.situacao}" />" /> <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>