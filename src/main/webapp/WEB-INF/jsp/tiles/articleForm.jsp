<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

	<div class=container-view>

		<form:form action="saveArticle" modelAttribute="article" method="POST">

			<!-- need to associate this data with article id -->

			<form:hidden path="id" />

			<label for="title">Title:</label>
			<form:textarea path="title" 
				placeholder="write_title_here" rows="2" />

			<label for="brief">Brief:</label>
			<form:textarea path="brief" placeholder="write_brief_here" rows="3" />

			<label for="content">Content:</label>
			<form:textarea path="content" placeholder="write_content_here"
				rows="8" />

			<div class=errors>
				<form:errors path="title" />
			</div>

			<div class=errors>
				<form:errors path="brief" />
			</div>

			<div class=errors>
				<form:errors path="content" />
			</div>


			<input type="submit" value="Save" class="purple-button" />

			<button class="red-button" type="button"
				onclick="window.location.href='showMainPage'; return false;">Cancel</button>
		</form:form>


	</div>

</body>
</html>