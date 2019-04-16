<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2>Página de Login</h2>
 <form action="efetuaLogin" method="post">
 Login: <input type="text" name="login" /> <br/>
 Senha: <input type="password" name="senha" /> <br/>
 <input type="submit" value="Entrar" />
 </form>
 <form action="registro" method="post">
 <input type="submit" value="Registro" />
 </form>
</body>
</html>