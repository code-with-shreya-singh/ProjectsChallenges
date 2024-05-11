<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>

<%@page import="entities.Note"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Note</title>
<%@include file="all_css_js.jsp" %>
</head>
<body>
<div class="container">
   <%@include file="navbar.jsp" %>
   <h1>Edit Your Note</h1>
   <br>
   <%
   int noteid=Integer.parseInt(request.getParameter("note_id").trim());
   Session se=FactoryProvider.getFactory().openSession();
   Note note=(Note)se.get(Note.class,noteid);

   %>
    <!--Form-->
   
   
   <form action="UpdateServlet1" metod="post">
   <input value="<%=note.getId()%>" name="noteId" type="hidden" />
  <div class="form-group">
    <label for="title">Title</label>
    <input name="title" 
    required 
    type="text" 
    class="form-control" 
    id="title"  
    placeholder="Enter your Title" 
    value="<%=note.getTitle()%>">
  </div>
  <div class="form-group">
    <label for="content">Note Content</label>
    <textarea 
    name="content"
    id="content"
    placeholder="enter your content here"
    required
    class="form-control"
    style="height:300px";><%=note.getContent() %></textarea>
  </div>
  <div class="container  text-center">
  
     <button type="submit" class="btn btn-primary">Save From Note</button>
  
  </div>
 
</form>
  </div>
</body>
</html>