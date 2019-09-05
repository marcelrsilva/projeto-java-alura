<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Lista de Pedidos Atuais">

<body>
	<div class="container">
			<h1>Lista de Produtos</h1>			
			<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>ID</th>
					<th>Valor</th>
					<th>Data Pedido</th> 
					<th>Titulo</th>
				</tr>
				<c:forEach items="${pedidos }" var="pedido">
					<tr>
						<td>${pedido.id }</td>						
						<td>${pedido.valor }</td>
						<td><fmt:formatDate value="${pedido.data}" pattern="dd/MM/yyyy" /> </td>
						<td>
							<c:forEach items="${pedido.produtos }" var="produto" varStatus="loop">
								${produto.titulo}
								<c:if test="${!loop.last}">,</c:if>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>

</tags:pageTemplate>