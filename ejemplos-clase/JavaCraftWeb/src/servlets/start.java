package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import negocio.CtrlABMCPersona;

/**
 * Servlet implementation class start
 */
@WebServlet("/start")
public class start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CtrlABMCPersona ctrl = new CtrlABMCPersona();
		Persona p1= new Persona();
		p1.setDni(Integer.parseInt(request.getParameter("Personaje1")));
		Persona p2= new Persona();
		p2.setDni(Integer.parseInt(request.getParameter("Personaje2")));
		p1=ctrl.getPersona(p1);
		p2=ctrl.getPersona(p2);
		//response.getWriter().append("P1: ").append(p1.getNombre()+" "+p1.getApellido());
		//response.getWriter().append("P2: ").append(p2.getNombre()+" "+p2.getApellido());
		request.getSession().setAttribute("P1", p1);
		request.getSession().setAttribute("P2", p2);
		//response.sendRedirect("WEB-INF/war.jsp");
		request.getRequestDispatcher("WEB-INF/war.jsp").forward(request, response);
		
	}

}
