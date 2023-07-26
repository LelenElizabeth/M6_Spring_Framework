package cl.grupo2.M6_Spring_Framework.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cl.grupo2.M6_Spring_Framework.modelo.Capacitacion;
import utils.Log;
import utils.TipoLog;

@Repository
public class CapacitacionDAO implements ICapacitacionDAO {

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public ArrayList<Capacitacion> obtenerCapacitaciones() {

		String SQL_SELECT = "SELECT id, nombre, detalle,rut_cliente, dia, hora, lugar, duracion, cantidad_asistentes FROM Capacitaciones";
		
		Log.registrarInfo(getClass(), TipoLog.INFO, "Llamada al método obtenerCapacitaciones()");
		ArrayList<Capacitacion> listaCapacitacion = new ArrayList<>();

		
		return (ArrayList<Capacitacion>) template.query(SQL_SELECT, new CapacitacionRowMapper());
	}

	@Override
	public boolean crearCapacitacion(Capacitacion cap) {

		String SQL_INSERT = "INSERT INTO Capacitaciones(nombre, detalle,rut_cliente, dia, hora, lugar, duracion, cantidad_asistentes)VALUES(?,?,?,?,?,?,?,?)";

		template.update(SQL_INSERT, new Object[] { cap.getNombre(), cap.getDetalle(), cap.getRutCliente(), cap.getDia(),
				cap.getHora(), cap.getLugar(), cap.getDuracion(), cap.getCantidadAsistentes() });

		Log.registrarInfo(getClass(), TipoLog.INFO, "Llamada al método crearCapacitacion() desde CapacitacionDAO");
		System.out.println(cap);

		return true;
	}

	
	@Override
	public Capacitacion obtenerCapacitacion(int id) {
		String SQL_SELECT_FROM = "SELECT id, nombre, detalle,rut_cliente, dia, hora, lugar, duracion, cantidad_asistentes FROM Capacitaciones WHERE id =";
		return template.queryForObject(SQL_SELECT_FROM, new Object[] { id }, new CapacitacionRowMapper());
	}

	@Override
	public void actualizar(Capacitacion cap) {
		String SQL_UPDATE = "UPDATE Capacitacion SET nombre = ?, detalle = ?, rut_cliente = ?,"
				+ " dia = ?, hora = ?, lugar = ?, duracion = ?, cantidad_asistentes = ? WHERE id = ?";

		template.update(SQL_UPDATE, new Object[] { cap.getNombre(), cap.getDetalle(), cap.getRutCliente(), cap.getDia(),
				cap.getHora(), cap.getLugar(), cap.getDuracion(), cap.getCantidadAsistentes() });
	}

	@Override
	public void eliminar(int id) {
		String SQL_DELETE = "DELETE FROM Capacitacion WHERE id = ?";
		template.update(SQL_DELETE, new Object[] {id});
	}

	class CapacitacionRowMapper implements RowMapper<Capacitacion> {
		public Capacitacion mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Capacitacion(rs.getInt("id"), rs.getString("nombre"), rs.getString("detalle"),
					rs.getInt("rut_cliente"), rs.getString("dia"), rs.getString("hora"), rs.getString("lugar"),
					rs.getString("duracion"), rs.getInt("cantidad_asistentes"));
		}
	}

}
