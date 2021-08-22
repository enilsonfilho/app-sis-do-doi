<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Remedio</h1>
        <form name="cadastrar" action="${pageContext.request.contextPath}/SalvarRemedio" method="POST">
            <p>ID:<input type="text" name="idremedio" value="${remedio.idRemedio}" readonly required/></p>             
            <p>Nome:<input type="text" name="nomeremedio" value="${remedio.nomeRemedio}"/></p>             
            <p>Preço:<input type=number name="precoremedio">${remedio.precoRemedio}</p>
            <p> Principio Ativo: <select name="cars">
                    <option value="" selected>Selecione Principio Ativo</option>
                    <c:forEach var="principio" items="${principios}">
                        <option value="${principio.idPrincipioAtivo}" selected>${principio.nomePrincipioAtivo}</option>  
                    </c:forEach>
            <p><input type="submit" name="cadastrar" value="Cadastrar"/></p>
            ${mensagem}
        </form>
    </body>
</html>
