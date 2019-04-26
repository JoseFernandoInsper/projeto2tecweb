<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Tarefa traduzida</h3>
 	<form action="traduzida" method="post">
 	<input name="idioma" type="text">
 	<input name="descricao" type="text">
 	 <a href="traduzir">Sair do sistema</a>
 	<button type="submit" name="traducao" value="${Translate.execute(tarefa.getDescricao(), Language.PORTUGUESE, Language.ENGLISH); }"> traduzir  </button>
 	<textarea name="trad" rows="6" cols="80"></textarea><br>
 	</form>
</body>
</html>