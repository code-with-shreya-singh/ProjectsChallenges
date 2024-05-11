package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Note;
import helper.FactoryProvider;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
		try {
			response.setContentType("text/html");  
			PrintWriter out=response.getWriter(); 
			int noteId=Integer.parseInt(request.getParameter("note_id").trim());
			Session se=FactoryProvider.getFactory().openSession();
			Transaction tx=se.beginTransaction();
			Note note=(Note)se.get(Note.class,noteId);
			se.delete(note);
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
