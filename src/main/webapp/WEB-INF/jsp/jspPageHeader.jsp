<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<header class="page-header">
	<h1>TNEAT</h1>
	<nav>
		<ul class="main-nav">
			<li>カート</li>
		</ul>
	</nav>	
</header>
 <aside id="container">
    
    <nav>
    <ul>
      <li class="has-child"><a href="#">MEN</a>
        <form action="aaa" form="form">
        <button type="button">TOPS</button>
        <ul>
        <li>TOPS</li>
        <li><a href="#">BOTTOM</a></li>
        <li><a href="#">SHOES</a></li>
        </ul>
        </form>
      </li>
      <li class="has-child"><a href="#">WOMEN</a>
        <ul>
        <li><button type="submit">TOPS</button></li>
        <li><a href="#">BOTTOM</a></li>
        <li><a href="#">ONEPIECE</a></li>
        <li><a href="#">SHOES</a></li>
        </ul>
        <li class="has-child"><a href="#">マイページ</a>
        <li class="has-child"><a href="#">お問い合わせ</a>
        <li class="has-child"><a href="#">ログイン/ログアウト</a>
      </li>
    </ul>
  </nav>
 </aside>