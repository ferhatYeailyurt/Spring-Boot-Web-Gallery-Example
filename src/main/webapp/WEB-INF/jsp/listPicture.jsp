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
    <link href="static/css/style.css" rel="stylesheet">
    


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
    
    
    
    <div class="container text-center" id="tasksDiv">
				<h3>Resimler</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Resim</th>
								<th>Resim Adı</th>
								<th>Açıklama</th>
								<th>Tarih</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="picture" items="${pictures}">
								<tr>
									<td>${picture.id}</td>
									<td>
									
									<img src="images/${picture.imagePath}" width ="50px" height="50px">
									</img>
									
									 	 <a name="path" value="${picture.imagePath}" href="/yazdir?path=${picture.imagePath} ">Göster</a>
									 	
									 	
									 	</td>
									
									<td>${picture.pictureName}</td>
									<td>${picture.pictureDescription}</td>
									<td>${picture.dateCreated}</td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			
			
		
			
	
			
    <script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
    </body>
</html>