package exemplo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exemplo.model.Usuario;

public class UsuarioDAO {

	public List<Usuario> listarTodos() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.33.10:3306/example_schema", "root", "root");

			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append(" select usuario.id, usuario.nome, usuario.telefone ");
			sql.append(" from example_schema.usuario usuario ");
			rs = stmt.executeQuery(sql.toString());

			Usuario u = null;
			while (rs.next()) {
				u = new Usuario();
				u.setTelefone(rs.getLong("telefone"));
				u.setNome(rs.getString("nome"));
				u.setId(rs.getLong("id"));
				usuarios.add(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//conn.close();
				//stmt.close();
				//rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return usuarios;
	}


}
