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
		<table>
			<tr>

				<td style= "padding: 10px">Title&Date</td>

				<td >
					<div class="title">${article.title}</div>
					<div class="date">${article.date}</div>
				</td>
			</tr>

			<tr>

				<td style= "padding: 10px">Brief</td>

				<td>
					<div class="brief">${article.brief}</div>
				</td>
			</tr>

			<tr>

				<td style= "padding: 10px">Content</td>

				<td>
					<div class="content">${article.content}</div>
				</td>
			</tr>

		</table>
		
		
		<button class="red-button" type="button"
			onclick="if (!(confirm('Are you sure you want to delete this article?'))) return false;window.location.href='deleteArticle?id=${article.id}'; return false;">Delete</button>

		<button class="purple-button" type="button"
			onclick="window.location.href='showEditArticlePage?id=${article.id}'; return false;">Edit</button>

		<button class="purple-button" type="button"
			onclick="window.location.href='showMainPage'; return false;">Back</button>


	</div>

</body>
</html>