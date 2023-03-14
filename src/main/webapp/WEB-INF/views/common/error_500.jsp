<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- Button trigger modal -->
			<button type="button" id="launch"  class="btn btn-primary d-none" data-bs-toggle="modal" data-bs-target="#exampleModal">
			  Launch demo modal
			</button>
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      
			      <div class="modal-body">
			        ${message}
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			        
			      </div>
			    </div>
			  </div>
			</div>
			<a href="/">Home</a>
		</div>
	</div>
</body>
</html>