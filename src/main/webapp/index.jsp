<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <form action="/Sample2/ProdcutListServlet" method="get">
    <input type="submit" value="商品一覧">
  </form>
  <form action="/Sample2/MypageServlet" method="post">
    <input type="submit" value="マイページ">
  </form>
  <form action="/Sample2/AccountInputInitServlet"method="get">
    <input type="submit" value="会員登録">
  </form>
  <form action="/Sample2/LoginInputServlet"method="get">
    <input type="submit" value="ログイン">
  </form>
</body>

</html>