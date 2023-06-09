<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Entity.OrderPurchaseEntity" %>
<%@ page import="Entity.ProductEntity" %>
<% 
List<OrderPurchaseEntity> OrderPurchaseEntityList = 
                          (List<OrderPurchaseEntity>)request.getAttribute("OrderPurchaseEntityList");

List<ProductEntity> OrderProductEntityList = 
                          (List<ProductEntity>)request.getAttribute("OrderProductEntityList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%= OrderProductEntityList.get(0).getId() %>
  <%= OrderProductEntityList.get(1).getId() %>
</body>
</html>