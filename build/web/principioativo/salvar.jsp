<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Princípio Ativo</h1> 
        <form name="cadastrar" action="${pageContext.request.contextPath}/SalvarPrincipioAtivo" method="POST">
            <p>ID:<input type="text" name="idprincipioativo" value="${principioativo.idPrincipioAtivo}" readonly required/></p>             
            <p>Nome:<input type="text" name="nomeprincipioativo" value="${principioativo.nomePrincipioAtivo}"/></p>             
            <p>Observação:<textarea name="observacaoprincipioativo" rows="5" cds="50">${principioativo.observacaoPrincipioAtivo}</textarea></p>
            <p><input type="submit" name="cadastrar" value="Cadastrar"/></p>
            ${mensagem}
        </form>
    </body>
</html>
