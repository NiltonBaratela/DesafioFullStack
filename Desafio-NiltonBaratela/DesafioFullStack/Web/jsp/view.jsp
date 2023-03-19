<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<!-- <html lang="en"> -->
<head>
    <meta charset="UTF-8">
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
    <title>Visualização</title>
</head>
<body>

    <h1>TEste</h1>
    <%@ page import="br.com.desafio.*, br.com.crudjspjava.bean.*, java.util.*"%>
    <@ taglig uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

    <h1>
        Listagem empresas
    </h1>

    <%
    List<Empresa> list = empresaDao.getEmpresas();
    request.setAttribute("list", list);
    %>
</body>
</html>