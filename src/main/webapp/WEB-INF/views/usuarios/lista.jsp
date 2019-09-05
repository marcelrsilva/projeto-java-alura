<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Lista de Usuários Atuais">

<body>
	<div class="container"><a href="${s:mvcUrl('UC#form').build()}">Novo usuário</a>
		<div class="container">
			<h1>Lista de Usuários</h1>			
			<p> ${sucesso} </p>	
			<p> ${sucessorole} </p>			
			<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Roles</th>	
					<th></th>			
				</tr>
				<c:forEach items="${usuarios }" var="usuario">
					<tr>
						<td>${usuario.nome }</td>						
						<td>${usuario.email }</td>	
						<td>
							<c:forEach items="${usuario.roles }" var="role" varStatus="loop">
								${role.nome}
								<c:if test="${!loop.last}">,</c:if>
							</c:forEach>
						</td>	
						<td><a href="${s:mvcUrl('UC#listarRoles').arg(0, usuario.email).build()}">Editar</td>			
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</tags:pageTemplate>