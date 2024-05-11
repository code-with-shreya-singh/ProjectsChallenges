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
 * Servlet implementation class SaveFromNote12
 */
public class SaveFromNote12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveFromNote12() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			response.setContentType("text/html");  
			PrintWriter out=response.getWriter();  
			String Title=request.getParameter("title");
			String Content=request.getParameter("content");
			Note note=new Note(Title, Content,new Date());
			
			Session se=FactoryProvider.getFactory().openSession();
			Transaction tx=se.beginTransaction();
			
			se.save(note);
			tx.commit();
			se.close(); 
			out.println("<h1 style='text-align:center'>Record add Sucessfully</h1>");
			out.println("<h1 style='text-align:center'><a href='view_all.jsp'>view All Notes</a></h1>");
			
 			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


}
