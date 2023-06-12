<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Entity.ProductEntity" %>
<% ProductEntity productEntity = (ProductEntity)session.getAttribute("productEntity"); %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レビュー入力画面</title>
</head>
<body>
    <c:if test="${not empty message}">
      <div class="message">
        <c:out value="${message}"/>
      </div>
    </c:if>
    <%= productEntity.getName() %>のレビュー中。
<form action ="/Sample2/ReviewServlet" method="post">
  レビュー内容 : <input type="text" name="review">
  <input type="submit" value="レビュー登録する">
</form>
</body>
</html>