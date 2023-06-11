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
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <% for(int i = 0; i < OrderPurchaseEntityList.size(); i++) {
        for(int j = 0;  j< OrderProductEntityList.size(); j++) {
          if(OrderPurchaseEntityList.get(i).getItem_id() == OrderProductEntityList.get(j).getId()){
        	  String str ="image/"+ OrderPurchaseEntityList.get(i).getItem_id() + ".png";%>
              商品名 : <%=OrderProductEntityList.get(j).getName()%>
              購入数 : <%=OrderPurchaseEntityList.get(i).getOrder_quantity()%>
        	  <img src= <%= str %>>
        	  <form action="/Sample2/ReviewServlet"method ="get">
        	  <button type="submit" name="id" value=<%=OrderPurchaseEntityList.get(i).getItem_id()%>>レビューを書く</button>
        	  </form> 
         <%}
        } 
      }
   %>


</body>
</html>