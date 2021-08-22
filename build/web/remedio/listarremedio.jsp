<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remedio</title>
    </head>
    <body>
        <h1>Remedio</h1>
        <table border="1" align="center">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Observacao</th>
                <th colspan="2">Editar</th>
             </tr>
        </thead>
        <tbody>
        <c:forEach var="remedio" items="${remedios}">
                <tr>
                    <td>${remedio.idRemedio}</td>
                    <td>${remedio.nomeRemedio}</td>
                    <td>${remedio.precoRemedio}</td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirRemedio?idremedio=${remedio.idRemedio}">Excluir</a></td>                  
                    <td><a href="${pageContext.request.contextPath}/CarregarRemedio?idremedio=${remedio.idRemedio}">Alterar</a></td>                  
                </tr>
            </c:forEach>
        </tbody>
        </table>
    </body>
</html>
