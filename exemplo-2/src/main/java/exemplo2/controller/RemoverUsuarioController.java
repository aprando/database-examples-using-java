package exemplo2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exemplo2.dao.UsuarioDAO;
import exemplo2.model.Usuario;

@WebServlet("/removerUsuario")
public class RemoverUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoverUsuarioController() {
	}

	private UsuarioDAO dao = new UsuarioDAO();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	private void doService(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Long pk = Long.parseLong(request.getParameter("id"));
			dao.remover(pk);
			
			request.setAttribute("msgSucesso", "Usuario removido com sucesso!");
			request.getRequestDispatcher("/listarUsuarios").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("/views/erro.jsp")
			.forward(request, response);

		}

	}
}
