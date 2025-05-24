    <%-- 
    Document   : atuaresult
    Created on : 23 de mai. de 2025, 21:17:56
    Author     : Pedrovisk
--%>

<%@page import="model.Personagens"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos/styles.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualização realizada</title>
    </head>
    <body>
        <h1>Faça sua atualização</h1>
        <%Personagens p = (Personagens) request.getAttribute("p");%>
        <%if (p.getNome() != null) {%>

        <form name="f1" action="ControlePersonagens" method="GET">
            ID..........: <%=p.getId()%> <input type="hidden" name="txtid" value="<%=p.getId()%>"> <BR>
            Nome...: <input class="buttons" type="text" name="txtnome" value="<%=p.getNome()%>">  <BR>
            Descrição...: <input class="buttons" type="text" name="txtdescricao" value="<%=p.getDescricao()%>">  <BR>
            Avaliação.......: <input class="buttons" type="text" name="txtavaliacao" value="<%=p.getAvaliacao()%>">  <BR>
            <input class="buttons" type="submit" name="op" value="EFETIVAR ATUALIZAÇÃO">
        </form>
        <%} else {%>
        <h2>Personagem não encontrado.</h2>
        <%}%>
    </body>
</html>
