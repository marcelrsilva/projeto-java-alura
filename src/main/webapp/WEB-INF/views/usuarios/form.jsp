<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Cadastro de Usuários">

	<c:url value="/resources/css" var="cssPath" />
	<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
	<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
	<style type="text/css">
body {
	padding: 60px 0px;
}
</style>
	<body>
		<div class="container">
			<h1>Cadastro de Usuários</h1>
			<form:form action="${s:mvcUrl('UC#gravar').build() }" method="post"
				commandName="usuario">
				<div class="form-group">
					<label>Nome</label>
					<form:input path="nome" cssClass="form-control" />
					<form:errors path="nome" />
				</div>
				<div class="form-group">
					<label>Email</label>
					<form:textarea path="email" cssClass="form-control" />
					<form:errors path="email" />
				</div>
				<div class="form-group">
					<label>Senha</label>
					<form:input type="password" path="senha" cssClass="form-control" />
					<form:errors path="senha" />
				</div>
				<div class="form-group">
					<label>Senha repetida</label>
					<form:input type="password" path="senhaRepetida" cssClass="form-control" />
					<form:errors path="senhaRepetida" />
				</div>
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</form:form>
		</div>
	</body>

</tags:pageTemplate>

