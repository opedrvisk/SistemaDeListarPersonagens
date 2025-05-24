<%-- 
    Document   : resultconsultarID
    Created on : 23 de mai. de 2025, 21:49:13
    Author     : Pedrovisk
--%>

<%@page import="model.Personagens"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos/styles.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da consulta pelo ID</title>
    </head>
    <body>
        <h1>Resultado da consulta pelo ID</h1>
        <%Personagens p = (Personagens) request.getAttribute("p");%>
        <%if (p.getNome() != null) {%>
        ID..........: <%=p.getId()%> <BR>
        Nome...: <%=p.getNome()%> <BR>
        Descrição...: <%=p.getDescricao()%> <BR>
        Avaliação.......: <%=p.getAvaliacao()%> <BR>
        <%} else {%>
        <h2>Personagem não encontrado.</h2>
        <%}%>
    </body>
</html>
