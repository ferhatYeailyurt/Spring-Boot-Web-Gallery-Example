<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Resimleri Listele</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    


  </head>
    <body>
    <div role="navigation">
    	<div class="navbar navbar-inverse">
    		<a href="/" class="navbar-brand">Anasayfa</a>
    			<div class="navbar-collapse collapse">
    				<ul class="nav navbar-nav">
    					<li><a href="<c:url value='/newPicture' />">Resim Ekle</a></li>
    					<li><a href="<c:url value='/listPicture' />">Resimleri Listele</a></li>
    				</ul>
    			</div>
    	</div>
    </div>
    <script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
    </body>
</html>