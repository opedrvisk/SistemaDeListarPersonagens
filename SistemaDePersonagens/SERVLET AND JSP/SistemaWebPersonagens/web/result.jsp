<%-- 
    Document   : result
    Created on : 23 de mai. de 2025, 21:34:53
    Author     : Pedrovisk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos/styles.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Resultado</title>
    </head>
    <body>
        <%String msg = (String) request.getAttribute("message");%>
        
        <h1><%=msg%> realizado com sucesso.</h1>
    </body>
</html>