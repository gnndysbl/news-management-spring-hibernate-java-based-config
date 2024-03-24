<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Main page</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/header_footer.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/main.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/buttons.css"/>" />

</head>

<body>
	<c:import url="/WEB-INF/jsp/tiles/header.jsp" />

	<c:import url="/WEB-INF/jsp/tiles/articleForm.jsp" />

	<c:import url="/WEB-INF/jsp/tiles/footer.jsp" />
</body>
</html>