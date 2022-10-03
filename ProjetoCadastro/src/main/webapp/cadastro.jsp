<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Inicial</title>

<link rel="icon" href="https://1000logos.net/wp-content/uploads/2020/09/Java-Logo.png" type="image/x-icon" />
<link rel="stylesheet" type="" href="./styles/style.css">

</head>
<body>
	
	<form action="cadastro" method="POST">
		<div class="fields">
			<label>Nome: </label>
			<input type="text" name="nome" id="nome">
		</div>
		
		<div class="fields">
			<input type="submit" value="Cadastrar">
		</div>
	</form>
	
</body>
</html>