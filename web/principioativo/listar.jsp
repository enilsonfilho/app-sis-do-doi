<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Principios Ativos</title>
    </head>
    <body>
        <h1>Lista de Principios Ativos</h1>
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
        <c:forEach var="principio" items="${principios}">
                <tr>
                    <td>${principio.idPrincipioAtivo}</td>
                    <td>${principio.nomePrincipioAtivo}</td>
                    <td>${principio.observacaoPrincipioAtivo}</td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirPrincipioAtivo?idprincipioativo=${principio.idPrincipioAtivo}">Excluir</a></td>                  
                    <td><a href="${pageContext.request.contextPath}/CarregarPrincipioAtivo?idprincipioativo=${principio.idPrincipioAtivo}">Alterar</a></td>                  
                </tr>
            </c:forEach>
        </tbody>
        </table>
    </body>
</html>
