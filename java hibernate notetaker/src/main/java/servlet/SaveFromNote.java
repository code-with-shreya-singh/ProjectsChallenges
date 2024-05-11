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

public class SaveFromNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SaveFromNote() {
        super();
      
    }

	
}
