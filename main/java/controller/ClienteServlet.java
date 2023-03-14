package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteM;
import persistence.ClienteDao;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteS")
public class ClienteServlet extends HttpServlet {
	private String cpf="";
	private String nome="";
	private String email="";
	private double limitC=0;
	private LocalDate data;
	private String bt;
	
	private static final long serialVersionUID = 1L;
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cpf = request.getParameter("Cpf");
		nome = request.getParameter("Nome");
		email = request.getParameter("Email");
		if(request.getParameter("limitC") != "") {
			limitC = Double.parseDouble(request.getParameter("limitC"));
		}
		if(request.getParameter("Data") != "") {
			data = LocalDate.parse(request.getParameter("Data"));
		}
		bt = request.getParameter("bt");
		
		ClienteM clm = new ClienteM();
		clm.setCpf(cpf);
		clm.setNome(nome);
		clm.setEmail(email);
		clm.setLimitC(limitC);
		clm.setData(data);
		List<ClienteM> lc = new ArrayList<ClienteM>();
		ClienteDao cd = new ClienteDao();
		
		try {
		switch(bt) {
		case "Inserir":
				cd.OPT(clm, "I");
				clm.setMsg(cd.getMsg());
				System.out.println("bolder"+cd.getMsg());
			break;
		case "Atualizar":
				cd.OPT(clm, "A");
				clm.setMsg(cd.getMsg());
		break;
		case "Deletar":
				cd.OPT(clm, "D");
				clm.setMsg(cd.getMsg());
		break;
		case "Listar":
			lc = cd.Listar();
			clm.setMsg(cd.getMsg());
		break;
		case "Buscar":
			clm = cd.Buscar(clm);
			clm.setMsg(cd.getMsg());
		break;
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("Cliente.jsp");
		request.setAttribute("val",cd.getMsg());
		request.setAttribute("lis",lc);
		request.setAttribute("cli", clm);
		rd.forward(request, response);
	}

}
