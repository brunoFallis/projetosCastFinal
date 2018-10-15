<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="posts" class="br.com.cast.hospital.entities.PostDAO"/>

<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<style>
	#main{
		overflow: auto;
		height: 400px;
		width: 550px;
	}
	#con{
		height: 400px;
		width: 550px;
		margin-top:60px;
	}
	#btn{
		margin-top: 10px;
		margin-left: 15px;
	}
</style>

</head>
<body>
	
	<div class="container" id="con">
	<div id="main" class="col-sm-12">
		<table class="table table-bordered" style="text-align:center">
			<tr>
				<th>Post text</th>
				<th>Action</th>
			<c:forEach var="post" items="${posts.listPosts()}">
			<tr>
				<td class="col-sm-9">
					<c:out value="${post.text.length() < 30 ? post.text : post.text.substring(30)}"></c:out>
				</td>
				<td class="col-sm-3">
					<form class="col-sm" action="TakePost" method="get">
						<button name="viewPost" value="${post.id}" class="btn btn-info">View post</button>
					</form>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<form action="upload.jsp">
		<button class="btn btn-success" id="btn">New post</button>
	</form>
	</div>
</body>
</html>
