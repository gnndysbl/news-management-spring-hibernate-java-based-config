<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

	<div class="container-view">

		<div class="container-place-new-article"
			onclick="location.href='showAddArticlePage';"
			style="cursor: pointer;">Add article</div>

		<c:forEach var="article" items="${news}">


			<div style="display: flex">


				<div class="container-article-preview" style="border:2px solid #505050; cursor: pointer;"
					onclick="location.href='showArticle?id=${article.id}';">
					

					<div class="title" >${article.title}</div>
					<div class="date">${article.date}</div>
					<div class="brief">${article.brief}</div>

				</div>

				<div class="container-delete"
					onclick="if (!(confirm('Are you sure you want to delete this article?'))) return false;location.href='deleteArticle?id=${article.id}';"
					style="cursor: pointer;">Delete</div>

				<div class="container-edit"
					onclick="location.href='showEditArticlePage?id=${article.id}';"
					style="cursor: pointer;">Edit</div>

			</div>

		</c:forEach>

	</div>

</body>
</html>