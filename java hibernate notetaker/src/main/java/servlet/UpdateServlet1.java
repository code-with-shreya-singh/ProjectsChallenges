package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Note;
import helper.FactoryProvider;

/**
 * Servlet implementation class UpdateServlet1
 */
public class UpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			response.setContentType("text/html");  
			PrintWriter out=response.getWriter();  
			String Title=request.getParameter("title");
			int noteId=Integer.parseInt(request.getParameter("noteId").trim());
			String Content=request.getParameter("content");
			
			
			Session se=FactoryProvider.getFactory().openSession();
			Transaction tx=se.beginTransaction();
			
			Note note=se.get(Note.class,noteId);
			note.setTitle(Title);
			note.setContent(Content);
			note.setAddedDate(new Date());
			tx.commit();
			se.close(); 
			response.sendRedirect("view_all.jsp");
			
 			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	}

