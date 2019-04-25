package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	
	private Connection connection = null;
	
	public UsuarioDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/tec_projeto2", "root", "130879"); // MUDAR PARA O USUARIO E SENHA DO SEU COMPUTADORRRRR!!!!
			System.out.println("conectou");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("oioioioi");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void adiciona(Usuario usuario) {
		System.out.println(usuario.getLogin());
		System.out.println(usuario.getSenha());
		String sql = "INSERT INTO usuario (login, senha) values(?, ?)";
		PreparedStatement stmt;
		System.out.println(connection);
		try {
			stmt = connection.prepareStatement(sql);

			stmt.setString(1,usuario.getLogin());
			stmt.setString(2,usuario.getSenha());
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getSenha());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean existeUsuario (Usuario usuario) {
		boolean existe = false;
		
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM Usuario  WHERE login=? AND senha=? LIMIT 1");
			
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			System.out.println(usuario.getLogin());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				if (rs.getInt(1) != 0) {
					existe = true;
				}
				rs.close();
				stmt.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
	}

}
