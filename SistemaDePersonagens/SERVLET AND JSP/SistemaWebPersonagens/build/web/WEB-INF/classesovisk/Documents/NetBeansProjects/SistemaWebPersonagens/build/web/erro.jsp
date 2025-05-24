<%-- 
    Document   : erro
    Created on : 23 de mai. de 2025, 21:24:56
    Author     : Pedrovisk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos/styles.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deu erro</title>
    </head>
    <body>
        <%String msg = (String) request.getAttribute("message");%>
        <h1><%=msg%> não realizado</h1>
    </body>
</html>
