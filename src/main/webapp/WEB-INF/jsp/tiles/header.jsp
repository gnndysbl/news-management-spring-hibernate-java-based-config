<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
	<nav class="header-title">
		<ul class="header_ul">
			<a href="showMainPage" style="text-decoration: none; color: white;">
				<h1>News Management</h1>
			</a>
		</ul>

	</nav>


	<button class="purple-button" type="button" value="Add article"
		onclick="window.location.href='showAddArticlePage'; return false;">Add
		article</button>

	

</header>