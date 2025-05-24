<%-- 
    Document   : resultconsultarTODOS
    Created on : 23 de mai. de 2025, 21:44:20
    Author     : Pedrovisk
--%>

<%@page import="java.util.List"%>
<%@page import="model.Personagens"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos/styles.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado consultar todos</title>
    </head>
    <body>
        <h1>PERSONAGENS</h1>
        <%List<Personagens> Lprod = (List<Personagens>) request.getAttribute("Lprod");%>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Avaliação</th>
                <th>Remover</th>
                <th>Editar</th>
            </tr>
            <%for (Personagens p : Lprod) {%>
            <tr>                
                <td><%=p.getId()%></td>
                <td><%=p.getNome()%></td>
                <td><%=p.getDescricao()%></td>
                <td><%=p.getAvaliacao()%></td>
                <td align="center"><a href="ControlePersonagens?op=Deletar&txtid=<%=p.getId()%>"><img src="images/lixeira01.png" width="25" height="25"></a></td>
                <td align="center"><a href="ControlePersonagens?txtid=<%=p.getId()%>&txtnome=<%=p.getNome()%>&txtdescricao=<%=p.getDescricao()%>&txtavaliacao=<%=p.getAvaliacao()%>&op=Atualizar" ><img src="images/editar01.png" width="25" height="25"></a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
