<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Entity.OrderEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%

List<OrderEntity> OrderEntityList = (List<OrderEntity>)session.getAttribute("OrderEntityList");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>

  <form action="/ShopSite/AddToCartServlet" method="get">
   Tシャツ　数量:
   
     <select name="quantity">
     <option value="1">1</option>
     <option value="2">2</option>
     <option value="3">3</option>
     </select>
   <button type='submit' name="test"value="1">カートへ</button><br>
   パンツ <button type='submit' name="test"value="2">カートへ</button><br>
   シューズ <button type='submit' name="test"value="3">カートへ</button>
  </form>
</body>
</html>