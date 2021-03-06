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
    
    <script>

		function setCookie(cname,cvalue,exdays) {
		    var d = new Date();
		    d.setTime(d.getTime() + (exdays*24*60*60*1000));
		    var expires = "expires=" + d.toGMTString();
		    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
		}
		var l=0;
		function getCookie(cname) {
		    var name = cname + "=";
		    var decodedCookie = decodeURIComponent(document.cookie);
		    var ca = decodedCookie.split(';');
		    for(var i = 0; i < ca.length; i++) {
		        var c = ca[i];
		        while (c.charAt(0) == ' ') {
		            c = c.substring(1);
		        }
		        if (c.indexOf(name) == 0) {
		            return c.substring(name.length, c.length);
		        }
		    }
			l=l+1;
			document.getElementById('count').innerHTML=l;
		    return "";
		}
		
		function checkCookie() {
		    var user=getCookie("username");
		    if (user != "") {
		        document.getElementById('count').innerHTML=user;
		    } else {
		       user = prompt("Lütfen kontrol ediniz:","");
		       if (user != "" && user != null) {
		           setCookie("username", user, 30);
		       }
		    }
		}
		
		</script>
    
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
										
											<a name="path" value="${picture.imagePath}" href="/yazdir?path=${picture.imagePath}" >
											<img src="images/${picture.imagePath}" width ="50px" height="50px" onclick="getCookie()" ></img>
											</a>
											<div id="count">Sayıyı Göster</div>
									 	
									 	
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