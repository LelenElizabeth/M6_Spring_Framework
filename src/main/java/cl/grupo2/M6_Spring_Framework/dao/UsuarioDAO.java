package cl.grupo2.M6_Spring_Framework.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cl.grupo2.M6_Spring_Framework.modelo.TipoUsuario;
import cl.grupo2.M6_Spring_Framework.modelo.Usuario;
import utils.Log;
import utils.TipoLog;

@Repository
public class UsuarioDAO implements IUsuarioDAO{
	
	@Autowired
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template= template;
	}
	
	@Override
	public ArrayList<Usuario> obtenerUsuarios() {
		Log.registrarInfo(getClass(), TipoLog.INFO, "Llamada al método obtenerUsuarios()");
		String SQL_SELECT = "SELECT id, nombre, tipo FROM Usuarios";
		ArrayList<Usuario> usuarios = new ArrayList<>();
		return (ArrayList<Usuario>)template.query(SQL_SELECT,new UsuarioRowMapper2());
	}

	@Override
	public boolean crearUsuario(Usuario usu) {
		System.out.println(usu);
		String SQL_INSERT = "INSERT INTO Usuarios(nombre, contrasena,tipo)VALUES(?,?,?)";
		template.update(SQL_INSERT, new Object[] {usu.getNombre(),usu.getContraseña(),usu.getTipo().toString()});
		Log.registrarInfo(getClass(), TipoLog.INFO, "Llamada al método crearUsuarios()");
		return true;
	}

	@Override
	public Usuario obtenerUsuario(int id) {
	    String SQL_SELECT = "SELECT id, nombre, contrasena, tipo FROM Usuarios WHERE id = ?";
	    Log.registrarInfo(getClass(), TipoLog.INFO, "Llamada al método obtenerUsuario()");
		return template.queryForObject(SQL_SELECT, new Object[] {id}, new UsuarioRowMapper());
	}

	@Override
	public void actualizar(Usuario usu) {
		String SQL_UPDATE ;
		Boolean validacion = usu.getContraseña()!= null && usu.getContraseña() != "" ;
		if(validacion) {
			SQL_UPDATE =" UPDATE Usuarios SET nombre = ?, contrasena = ?, tipo = ? WHERE id = ?";
			template.update(SQL_UPDATE, new Object[] {usu.getNombre(),usu.getContraseña(),usu.getTipo()});
		} else {
			SQL_UPDATE =" UPDATE Usuarios SET nombre = ?, tipo = ? WHERE id = ?";
			template.update(SQL_UPDATE, new Object[] {usu.getNombre(),usu.getTipo()});
		}
		Log.registrarInfo(getClass(), TipoLog.INFO, "Llamada al método actualizar()");
		
		
	}

	@Override
	public void eliminar(int id) {
		String SQL_DELETE="DELETE FROM Usuarios WHERE id =?";
		template.update(SQL_DELETE, new Object[] {id});
		Log.registrarInfo(getClass(), TipoLog.INFO, "Llamada al método eliminar()");
		
	}
	
	public class UsuarioRowMapper implements RowMapper<Usuario>{
		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Usuario(rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("contrasena"),
					TipoUsuario.parse(rs.getString("tipo")));
		}
	}

	public class UsuarioRowMapper2 implements RowMapper<Usuario>{
		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Usuario(rs.getInt("id"),
					rs.getString("nombre"),
					TipoUsuario.parse(rs.getString("tipo")));
		}
	}
}
