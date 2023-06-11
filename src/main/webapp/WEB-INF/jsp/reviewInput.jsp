<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Entity.ProductEntity" %>
<% ProductEntity productEntity = (ProductEntity)request.getAttribute("productEntity"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レビュー入力画面</title>
</head>
<body>
<%= productEntity.getName() %>のレビュー
<form action ="" method="post">
  レビュー内容 : <input type="text" name="review">
  <input type="submit" value="レビュー登録する">
</form>
</body>
</html>