<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./CSS/cf.css">
</head>
<body>
<jsp:include page="h.jsp"></jsp:include>
<div align="center">
<form action="ClienteS" method="post">
<table>
<tr>
<td colspan="3">
<input id="Cpf" name="Cpf" type="text" placeholder="CPF" 
value="<c:out value="${cli.cpf}"></c:out>"></td>
<td><input id="bt" name="bt" type="submit" value="Buscar"></td>
</tr>
<tr>
<td colspan="4">
<input id="Nome" name="Nome" type="text" placeholder="NOME"
value="<c:out value="${cli.nome}"></c:out>"></td></tr>
<tr>
<td colspan="4">
<input id="Email" name="Email" type="text" placeholder="E-MAIL"
value="<c:out value="${cli.email}"></c:out>"></td></tr>
<tr>
<td colspan="4">
<input id="limitC" name="limitC" type="number" 
placeholder="Limite de Credito" step="0.01"
value="<c:out value="${cli.limitC}"></c:out>"></td></tr>
<tr>
<td colspan="4"><input id="Data" name="Data" type="date"
value="<c:out value="${cli.data}"></c:out>"></td></tr>
<tr>
<td><input id="bt" name="bt" type="submit" value="Inserir"></td>
<td><input id="bt" name="bt" type="submit" value="Atualizar"></td>
<td><input id="bt" name="bt" type="submit" value="Deletar"></td>
<td><input id="bt" name="bt" type="submit" value="Listar"></td>
</tr>
</table>
</form>
</div>
<br>
<div align="Center">
<c:if test="${not empty val}">
<c:out value="${val}"></c:out>
</c:if>
</div>
<br>
<div align="Center">
<c:if test="${not empty lis}">
<table border="1">
<thead>
<tr>
<th>CPF</th>
<th>Nome</th>
<th>EMail</th>
<th>Limite</th>
<th>Data-Nascimento</th>
</tr>
</thead>
<tbody>
<c:forEach items="${lis}" var="c">
<tr>
<td><c:out value="${c.cpf}"></c:out></td>
<td><c:out value="${c.nome}"></c:out></td>
<td><c:out value="${c.email}"></c:out></td>
<td><c:out value="${c.limitC}"></c:out></td>
<td><c:out value="${c.data}"></c:out></td>
</tr>
</c:forEach>
</tbody>
</table>
</c:if>
</div>
</body>
</html>