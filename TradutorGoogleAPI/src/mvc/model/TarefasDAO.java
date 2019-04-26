package mvc.model;

import java.sql.Date;
import java.sql.*;
import java.util.*;

public class TarefasDAO {
	private Connection connection = null;

	public TarefasDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/tec_projeto2", "root", "130879");
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
			}
		}
 
	public void adicionaDescricao(Tarefa tarefa) {
		try {
			String sql = "INSERT INTO data (texto,idioma,traducao,id_user) values(?,?,?,?)";
			PreparedStatement stmt =
		connection.prepareStatement(sql);
			stmt.setString(1,tarefa.getDescricao());
			stmt.setString(2,tarefa.getIdioma());
			stmt.setString(3,tarefa.getTraducao());
			stmt.setString(4,tarefa.getId_user());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	 public void adiciona(Tarefa tarefa) {
		 
		 String sql = "INSERT INTO data (texto,dataFinalizacao,idioma,traducao) values(?,?,?,?)";
		 try {
			 PreparedStatement stmt = connection.prepareStatement(sql);
			  stmt.setString(1,tarefa.getDescricao());
			  stmt.setDate(2, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			  stmt.setString(3,tarefa.getIdioma());
			  stmt.setString(4,tarefa.getTraducao());
			  stmt.execute();
			  stmt.close();
			  } catch (SQLException e) {e.printStackTrace();}}
	 
	 
	public List<Tarefa> getLista() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		try {
			PreparedStatement stmt = connection.
			prepareStatement("SELECT * FROM data");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("texto"));
				tarefa.setIdioma(rs.getString("idioma"));
				tarefa.setTraducao(rs.getString("traducao"));
					  
				Calendar data = Calendar.getInstance();
				Date dataFinalizacao = rs.getDate("dataFinalizacao");
				if(dataFinalizacao!=null) {
					data.setTime(dataFinalizacao);
					tarefa.setDataFinalizacao(data);
				}
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			} catch(SQLException e) {System.out.println(e);}
		return tarefas;
	}
			 public void remove(Tarefa tarefa) {
				 try {
					 PreparedStatement stmt =
			connection.prepareStatement("DELETE FROM data WHERE id=?");
					 stmt.setLong(1, tarefa.getId());
					 stmt.execute();
					 stmt.close();
				 } catch(SQLException e) {System.out.println(e);}
			}
			 public Tarefa buscaPorId(Long id) {
				 Tarefa tarefa = new Tarefa();
				 try {
					 PreparedStatement stmt =
			connection.prepareStatement("SELECT * FROM data WHERE id=? ");
					 stmt.setLong(1, id);
					 ResultSet rs = stmt.executeQuery();
					 if(rs.next()) {
						 tarefa.setId(rs.getLong("id"));
						 tarefa.setDescricao(rs.getString("descricao"));
						 tarefa.setIdioma(rs.getString("idioma"));
						 tarefa.setTraducao(rs.getString("traducao"));
			 			Calendar data = Calendar.getInstance();
			 			Date dataFinalizacao =
			rs.getDate("dataFinalizacao");
			 			if(dataFinalizacao!=null) {
			 				data.setTime(dataFinalizacao);
			 				tarefa.setDataFinalizacao(data);
			 			}
					 }
					 rs.close();
					 stmt.close();
				 } catch(SQLException e) {System.out.println(e);}
				 return tarefa;
			 }
			 
			 public void finaliza(Long id, Tarefa tarefa) {
			 	try {
			 		String sql = "UPDATE data SET dataFinalizacao=?,idioma=?,traducao=? WHERE id=?";
			 		PreparedStatement stmt =
			connection.prepareStatement(sql);
			 		stmt.setDate(1, new
			Date(Calendar.getInstance().getTimeInMillis()));
			 		stmt.setString(2,tarefa.getIdioma());
			 		stmt.setString(3,tarefa.getTraducao());
			 		stmt.setLong(4, id);
			 		stmt.executeUpdate();
			 		stmt.close();
			 	 } catch(SQLException e) {System.out.println(e);}
			 	}
			 public void close() {
			 	 try { connection.close();}
			 	 catch (SQLException e) {e.printStackTrace();
			 	 }
			 }
}