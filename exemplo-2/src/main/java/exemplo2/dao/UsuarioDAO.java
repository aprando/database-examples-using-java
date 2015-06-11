package exemplo2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import exemplo2.model.Usuario;

public class UsuarioDAO {
	
	private Connection getConnection() throws NamingException, SQLException{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/example");
		return ds.getConnection();	
	}
	
	public List<Usuario> listarTodos() throws Exception {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();

			StringBuilder sql = new StringBuilder();
			sql.append(" select usuario.id, usuario.nome, usuario.email, usuario.telefone ");
			sql.append(" from example_schema.usuario usuario ");
			rs = stmt.executeQuery(sql.toString());

			Usuario u = null;
			while (rs.next()) {
				u = new Usuario();
				u.setNome(rs.getString("nome"));
				u.setId(rs.getLong("id"));
				u.setEmail(rs.getString("email"));
				u.setTelefone(rs.getInt("telefone"));
				usuarios.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}

	
	public Usuario consultarPorPK(Long pk) throws Exception{
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();

			StringBuilder sql = new StringBuilder();
			sql.append(" select usuario.id, usuario.nome, usuario.email, usuario.telefone ");
			sql.append(" from example_schema.usuario usuario ");
			sql.append(" where usuario.id = " + pk);
			rs = stmt.executeQuery(sql.toString());

			Usuario u = null;
			if (rs.next()) {
				u = new Usuario();
				u.setNome(rs.getString("nome"));
				u.setId(rs.getLong("id"));
				u.setEmail(rs.getString("email"));
				u.setTelefone(rs.getInt("telefone"));
			}
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void remover(Long pk) throws Exception{
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();

			StringBuilder sql = new StringBuilder();
			sql.append(" delete from example_schema.usuario ");
			sql.append(" where id = " + pk);
			
			stmt.executeUpdate(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void salvar(Usuario usuario) throws Exception{
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();

			StringBuilder sql = new StringBuilder();
			if(usuario.getId() == null){
				//rs = stmt.executeQuery("select max(usuario.id) + 1 as pk from example_schema.usuario usuario");
				//rs.next();
				//long pk = rs.getLong("pk");
					
				//sql.append(" insert into example_schema.usuario(id, nome, email, telefone) ");
				//sql.append(" values ( " + pk +", '" + usuario.getNome());
				sql.append(" insert into example_schema.usuario(nome, email, telefone) ");
				sql.append(" values ('" + usuario.getNome());
				sql.append("', '" + usuario.getEmail() + "', " + usuario.getTelefone()  + " ) ");
			}else{
				sql.append(" update example_schema.usuario ");
				sql.append(" set nome = '" + usuario.getNome());
				sql.append("',email = '" + usuario.getEmail());
				sql.append("',telefone = " + usuario.getTelefone());
				sql.append(" where id = " + usuario.getId());
				
			}
			stmt.executeUpdate(sql.toString());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
