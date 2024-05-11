<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_css_js.jsp" %>
<title>AddNotes</title>
</head>
<body>
   <div class="container">
   <%@include file="navbar.jsp" %>
   <br>
   <h1>Please add Your details....</h1>
   <br>
       <!--Form-->
   
   
   <form action="SaveFromNote12" metod="service">
  <div class="form-group">
    <label for="title">Title</label>
    <input name="title" required type="text" class="form-control" id="title"  placeholder="Enter your Title">
  </div>
  <div class="form-group">
    <label for="content">Note Content</label>
    <textarea 
    name="content"
    id="content"
    placeholder="enter your content here"
    required
    class="form-control"
    style="height:300px";    
    >
    </textarea>
  </div>
  <div class="container  text-center">
  
   <button type="submit" class="btn btn-primary">Add</button>
  
  </div>
 
</form>
   </div>
</body>
</html>