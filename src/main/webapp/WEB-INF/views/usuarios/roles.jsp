<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Cadastro de Roles">

<body>
	<div class="container">
		<h1>Cadastro de permissões para ${usuario.nome}</h1>
		<form:form action="${s:mvcUrl('UC#gravarRoles').arg(0, usuario.email).build() }" method="post"
			commandName="usuario">
			<div class="form-group">								
				Permissões: <form:checkbox path="roles" value="ROLE_ADMIN"/>ROLE_ADMIN <form:checkbox path="roles" value="ROLE_USER"/>ROLE_USER 
				<form:checkbox path="roles" value="ROLE_COMERCIAL"/>ROLE_COMERCIAL			
			</div>					
			<button type="submit" class="btn btn-primary">Atualizar</button>
		</form:form>
	</div>
</body>

</tags:pageTemplate>

